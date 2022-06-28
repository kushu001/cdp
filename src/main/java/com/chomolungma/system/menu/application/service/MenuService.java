package com.chomolungma.system.menu.application.service;

import com.chomolungma.system.menu.domain.entity.MenuEntity;

public interface MenuService {
    void createMenu(MenuEntity menuEntity);

    void deleteMenu(Long id);

    void updateMenu(MenuEntity menuEntity);
}
