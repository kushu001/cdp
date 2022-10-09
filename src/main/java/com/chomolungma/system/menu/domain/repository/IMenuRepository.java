package com.chomolungma.system.menu.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;

public interface IMenuRepository {
    void save(MenuEntity menuEntity);

    void remove(Long id);
}
