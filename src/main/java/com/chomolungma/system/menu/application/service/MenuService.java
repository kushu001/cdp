package com.chomolungma.system.menu.application.service;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;

import java.util.List;

public interface MenuService {
    void createMenu(MenuEntity menuEntity);

    void deleteMenu(Long id);

    void updateMenu(MenuEntity menuEntity);

    List<MenuDO> permissions(String type);
}
