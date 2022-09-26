package com.chomolungma.system.role.application.service;

import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;

import java.util.List;

public interface RoleService {

    void createRole(RoleEntity roleEntity);

    void updateRole(RoleEntity roleEntity);

    void deleteByIds(List<String> ids);

    void authorized(Long roleId, List<RoleMenuDTO> permissions);

    List<RoleMenuDTO> permission(Long roleId);
}
