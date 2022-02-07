package com.chomolungma.role.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.role.bo.OutRoleFormBO;
import com.chomolungma.role.bo.OutRoleSearchBO;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.mapper.RoleMapper;
import com.chomolungma.role.mapstruct.RoleEntityMapStruct;
import com.chomolungma.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    public RoleMapper roleMapper;

    @Override
    public OutRoleSearchBO getRoles(Page<RoleEntity> page, RoleEntity role) {
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(role.getName() != null,"name", role.getName()).like(role.getCode() != null,"code",role.getCode()).eq(role.getStatus()!=null,"status",role.getStatus());
        Page<RoleEntity> roles = roleMapper.selectPage(page,queryWrapper);
        return RoleEntityMapStruct.INSTANCE.toOutRoleSearchBO(roles);
    }

    @Override
    public OutRoleFormBO getRole(Long id) {
        RoleEntity role = roleMapper.selectById(id);
        return RoleEntityMapStruct.INSTANCE.toOutRoleFormBO(role);
    }

    @Override
    public void createRole(RoleEntity roleEntity) {
        roleMapper.insert(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        roleMapper.updateById(roleEntity);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        roleMapper.deleteBatchIds(ids);
    }


}
