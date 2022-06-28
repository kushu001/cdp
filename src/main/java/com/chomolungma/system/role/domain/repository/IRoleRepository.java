package com.chomolungma.system.role.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;

import java.util.List;

public interface IRoleRepository {
     void save(Long roleId, List<RoleMenuDTO> permissions);

     List<MenuEntity> query(List<Long> roleIds);

     List<RoleMenuDTO> query(Long roleId);

}
