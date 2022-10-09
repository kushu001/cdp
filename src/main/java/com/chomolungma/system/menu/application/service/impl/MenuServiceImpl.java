package com.chomolungma.system.menu.application.service.impl;

import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private IMenuRepository iMenuRepository;
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
}
