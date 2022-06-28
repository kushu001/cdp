package com.chomolungma.system.role.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.role.application.service.RoleService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.domain.repository.mapper.RoleMapper;
import com.chomolungma.system.role.domain.service.NewRoleDomainService;
import com.chomolungma.system.role.domain.service.OneRoleDomainService;
import com.chomolungma.system.role.interfaces.assembler.RoleAssembler;
import com.chomolungma.system.role.interfaces.dto.OutRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.interfaces.dto.Role;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import com.chomolungma.system.role.interfaces.mapstruct.RoleEntityMapStruct;
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
    public OutRoleSearchDTO getPageRoles(Page<RoleEntity> page, RoleEntity role) {
        QueryWrapper<RoleEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(role.getName() != null,"name", role.getName()).like(role.getCode() != null,"code",role.getCode()).eq(role.getStatus()!=null,"status",role.getStatus());
        Page<RoleEntity> roles = roleMapper.selectPage(page,queryWrapper);
        return RoleAssembler.toOutRoleSearchDTO(roles);
    }

    @Override
    public List<Role> getRoles(RoleEntity roleEntity) {
        List<RoleEntity> roles = roleMapper.selectList(new QueryWrapper<>());
        return RoleEntityMapStruct.INSTANCE.toList(roles);
    }

    @Override
    public OutRoleFormDTO getRole(Long id) {
        return RoleAssembler.toOutRoleFormDTO(execute(new OneRoleDomainService(id)));
    }

    @Override
    public void createRole(RoleEntity roleEntity) {
        execute(new NewRoleDomainService(roleEntity));
    }

    @Override
    public void updateRole(RoleEntity roleEntity) {
        roleMapper.updateById(roleEntity);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        roleMapper.deleteBatchIds(ids);
    }

    @Override
    public void authorized(Long roleId, List<RoleMenuDTO> permissions) {
        iRoleRepository.save(roleId, permissions);
    }

    @Override
    public List<RoleMenuDTO> permission(Long roleId) {
        return iRoleRepository.query(roleId);
    }


}
