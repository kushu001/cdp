package com.chomolungma.system.menu.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.infrastructure.converter.MenuConverter;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuRepositoryImpl implements IMenuRepository {

    private final MenuMapper menuMapper;

    public MenuRepositoryImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
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
}
