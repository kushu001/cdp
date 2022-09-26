package com.chomolungma.system.role.application.service.impl;

import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.role.application.service.RoleService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.infrastructure.mybatis.repository.mapper.RoleMapper;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseService implements RoleService {
    @Autowired
    public RoleMapper roleMapper;

    @Autowired
    public IRoleRepository iRoleRepository;


    @Override
    public void createRole(RoleEntity roleEntity) {
        iRoleRepository.save(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        iRoleRepository.save(roleEntity);
    }

    @Override
    public void authorized(Long roleId, List<RoleMenuDTO> permissions) {
        iRoleRepository.save(roleId, permissions);
    }

    @Override
    public List<RoleMenuDTO> permission(Long roleId) {
        return iRoleRepository.queryMenus(roleId);
    }


}
