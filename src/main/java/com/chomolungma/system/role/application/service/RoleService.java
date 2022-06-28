package com.chomolungma.system.role.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.OutRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.Role;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;

import java.util.List;

public interface RoleService {
    OutRoleSearchDTO getPageRoles(Page<RoleEntity> page, RoleEntity role);

    List<Role> getRoles(RoleEntity roleEntity);
    OutRoleFormDTO getRole(Long id);

    void createRole(RoleEntity roleEntity);

    void updateRole(RoleEntity roleEntity);

    void deleteByIds(List<String> ids);

    void authorized(Long roleId, List<RoleMenuDTO> permissions);

    List<RoleMenuDTO> permission(Long roleId);
}
