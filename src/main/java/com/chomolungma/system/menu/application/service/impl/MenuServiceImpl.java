package com.chomolungma.system.menu.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    private final IMenuRepository iMenuRepository;

    private final MenuMapper menuMapper;

    public MenuServiceImpl(IMenuRepository iMenuRepository, MenuMapper menuMapper) {
        this.iMenuRepository = iMenuRepository;
        this.menuMapper = menuMapper;
    }

    @Override
    public void createMenu(MenuEntity menuEntity) {
        iMenuRepository.save(menuEntity);
    }

    @Override
    public void deleteMenu(Long id) {
        iMenuRepository.remove(id);
    }

    @Override
    public void updateMenu(MenuEntity menuEntity) {
        iMenuRepository.save(menuEntity);
    }

    @Override
    public List<MenuDO> permissions(String type) {
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

        return results;
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
