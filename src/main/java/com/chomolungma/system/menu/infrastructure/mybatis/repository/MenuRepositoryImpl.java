package com.chomolungma.system.menu.infrastructure.mybatis.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.infrastructure.converter.MenuConverter;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper.MenuMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MenuRepositoryImpl implements IMenuRepository {

    private final MenuMapper menuMapper;

    public MenuRepositoryImpl(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Override
    public void save(MenuEntity menuEntity) {
        MenuDO menuDO = MenuConverter.INSTANCE.toDO(menuEntity);
        if (menuDO.getId() == null){
            menuMapper.insert(menuDO);
        }else{
            menuMapper.updateById(menuDO);
        }
    }

    @Override
    @Transactional
    public void remove(Long id) {
        menuMapper.deleteMenus(id);
        menuMapper.deleteRoleMenuRelByMenuId(id);
    }
}
