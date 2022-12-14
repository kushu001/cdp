package com.chomolungma.system.menu.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;

import java.util.List;

public interface IMenuRepository {
    List<MenuDO> find(List<Long> roleIds);
    List<MenuDTO> find();
    List<MenuDTO> find(String type);
    void save(MenuEntity menuEntity);

    void remove(Long id);
}
