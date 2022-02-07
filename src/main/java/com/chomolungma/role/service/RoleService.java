package com.chomolungma.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.role.bo.OutRoleFormBO;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.bo.OutRoleSearchBO;

import java.util.List;

public interface RoleService {
    OutRoleSearchBO getRoles(Page<RoleEntity> page, RoleEntity role);

    OutRoleFormBO getRole(Long id);

    void createRole(RoleEntity roleEntity);

    void updateRole(RoleEntity roleEntity);

    void deleteByIds(List<String> ids);
}
