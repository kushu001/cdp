package com.chomolungma.system.menu.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.menu.infrastructure.converter.MenuConverter;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper.MenuMapper;
import com.chomolungma.system.menu.interfaces.assembler.MenuAssembler;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuRepositoryImpl implements IMenuRepository {

    private final MenuMapper menuMapper;

    public MenuRepositoryImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public List<MenuDO> find(List<Long> roleIds) {
        return menuMapper.selectMenusByRoleIds(roleIds);
    }

    @Override
    public List<MenuDTO> find() {
        List<MenuDO> menuList = menuMapper.selectList(new QueryWrapper<MenuDO>().orderByAsc("sort"));
        return MenuAssembler.convertToDto(menuList);
    }

    @Override
    public List<MenuDTO> find(String type) {
        List<MenuDO> results = new ArrayList<>();
        if (type.equals("0")){
            results = menuMapper.selectList(new QueryWrapper<MenuDO>().eq("type", type).orderByAsc("sort"));
        }else if (type.equals("1")){
            List<MenuDO> operations = menuMapper.selectList(new QueryWrapper<MenuDO>().orderByDesc("type").orderByAsc("sort"));
            Map<Long, MenuDO> map = new HashMap<>();
            for (MenuDO menuDO: operations) {
                map.put(menuDO.getId(), menuDO);
            }
            Map<Long, MenuDO> result = new HashMap<>();
            for (MenuDO menuDO: operations) {
                if (menuDO.getType().equals("1")){
                    fuc(result, map, menuDO);
                }
            }
            for (Map.Entry<Long, MenuDO> menuDO : result.entrySet()) {
                results.add(menuDO.getValue());
            }
        }

        return MenuAssembler.convertToDto(results);
    }

    @Override
    @Transactional
    public void save(MenuEntity menuEntity) {
        MenuDO menuDO = MenuConverter.INSTANCE.toDO(menuEntity);
        if (menuDO.getId() == null){
            menuMapper.insert(menuDO);
            if (menuDO.getPid() != 0L){
                MenuDO parentMenu = menuMapper.selectById(menuDO.getPid());
                if (parentMenu.getHasLeaf() == null || !parentMenu.getHasLeaf()){
                    parentMenu.setHasLeaf(true);
                    menuMapper.updateById(parentMenu);
                }
            }
        }else{
            menuMapper.updateById(menuDO);
        }
    }

    @Override
    @Transactional
    public void remove(Long id) {
        MenuDO menu = menuMapper.selectById(id);
        // 先删除当前菜单节点
        menuMapper.deleteMenus(id);
        // 查询当前菜单节点的父节点是否还有子节点
        List<MenuDO> menuDOS = menuMapper.selectList(new QueryWrapper<MenuDO>().eq("pid", menu.getPid()));

        if (menuDOS.size() == 0){ //如果没有子节点了就将父节点设置成没有子节点的状态
            MenuDO parentMenu = menuMapper.selectById(menu.getPid());
            if (parentMenu.getHasLeaf() == null || parentMenu.getHasLeaf()){
                parentMenu.setHasLeaf(false);
                menuMapper.updateById(parentMenu);
            }
        }

        // 删除角色关联菜单的记录
        menuMapper.deleteRoleMenuRelByMenuId(id);
    }

    private void fuc(Map<Long, MenuDO> result, Map<Long, MenuDO> allMap, MenuDO menuDO){
        if (menuDO.getPid() != 0L){
            result.put(menuDO.getId(), menuDO);
            fuc(result, allMap, allMap.get(menuDO.getPid()));
        }else {
            result.put(menuDO.getId(), menuDO);
        }

    }
}
