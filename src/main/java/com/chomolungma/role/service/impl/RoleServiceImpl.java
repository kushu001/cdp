package com.chomolungma.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.mapper.RoleMapper;
import com.chomolungma.role.mapstruct.RoleEntityMapStruct;
import com.chomolungma.role.bo.OutRoleBO;
import com.chomolungma.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleMapper roleMapper;

    @Override
    public OutRoleBO getRoles(Page<RoleEntity> page, RoleEntity role) {
        Page<RoleEntity> roles = roleMapper.selectPage(page,new QueryWrapper<RoleEntity>().like(false,"name", role.getName()));
        return RoleEntityMapStruct.INSTANCE.toBO(roles);
    }
}
