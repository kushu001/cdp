package com.chomolungma.system.menu.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;

import java.util.List;

public interface IMenuRepository {

    List<MenuDTO> query();
    List<MenuDTO> query(String type);
    void save(MenuEntity menuEntity);

    void remove(Long id);
}
