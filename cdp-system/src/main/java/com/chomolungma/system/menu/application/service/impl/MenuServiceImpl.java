package com.chomolungma.system.menu.application.service.impl;

import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final IMenuRepository iMenuRepository;

    public MenuServiceImpl(IMenuRepository iMenuRepository) {
        this.iMenuRepository = iMenuRepository;
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
    public List<MenuDTO> permissions(String type) {
        return iMenuRepository.find(type);
    }


}
