package com.chomolungma.system.role.application.service.impl;

import com.chomolungma.system.role.application.service.RoleService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    public final IRoleRepository iRoleRepository;

    public RoleServiceImpl(IRoleRepository iRoleRepository) {
        this.iRoleRepository = iRoleRepository;
    }


    @Override
    public void createRole(RoleEntity roleEntity) {
        iRoleRepository.save(roleEntity);
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        iRoleRepository.save(roleEntity);
    }

    @Override
    public void authorizedMenus(Long roleId, List<Long> permissions) {
        iRoleRepository.saveMenus(roleId, permissions);
    }

    @Override
    public void authorizedOperations(Long roleId, List<Long> permissions) {
        iRoleRepository.saveOperations(roleId, permissions);
    }

    @Override
    public List<RolePermissionDTO> menus(Long roleId) {
        return iRoleRepository.queryMenus(roleId);
    }

    @Override
    public List<RolePermissionDTO> operations(Long roleId) {
        return iRoleRepository.queryOperation(roleId);
    }


}
