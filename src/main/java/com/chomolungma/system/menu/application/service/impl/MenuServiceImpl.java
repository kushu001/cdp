package com.chomolungma.system.menu.application.service.impl;

import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.service.CreateMenuDomainService;
import com.chomolungma.system.menu.domain.service.DeleteMenuDomainService;
import com.chomolungma.system.menu.domain.service.UpdateMenuDomainService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseService implements MenuService {

    @Override
    public void createMenu(MenuEntity menuEntity) {
        execute(new CreateMenuDomainService(menuEntity));
    }

    @Override
    public void deleteMenu(Long id) {
        execute(new DeleteMenuDomainService(id));
    }

    @Override
    public void updateMenu(MenuEntity menuEntity) {
        execute(new UpdateMenuDomainService(menuEntity));
    }
}
