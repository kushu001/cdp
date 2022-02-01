package com.chomolungma.role.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.bo.OutRoleBO;

public interface RoleService {
    OutRoleBO getRoles(Page<RoleEntity> page, RoleEntity role);
}
