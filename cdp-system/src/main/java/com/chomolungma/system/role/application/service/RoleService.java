package com.chomolungma.system.role.application.service;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;

import java.util.List;

public interface RoleService {

    void createRole(RoleEntity roleEntity);

    void updateRole(RoleEntity roleEntity);

    void authorizedMenus(Long roleId, List<Long> permissions);

    void authorizedOperations(Long roleId, List<Long> permissions);

    void authorizedResources(Long roleId, List<Long> permissions);

    List<RolePermissionDTO> menus(Long roleId);

    List<RolePermissionDTO> operations(Long roleId);

    List<Long> resources(Long roleId);
}
