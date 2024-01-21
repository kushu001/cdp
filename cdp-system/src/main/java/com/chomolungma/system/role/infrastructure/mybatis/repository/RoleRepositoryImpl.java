package com.chomolungma.system.role.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.infrastructure.converter.RoleConverter;
import com.chomolungma.system.role.infrastructure.dataobject.RoleDO;
import com.chomolungma.system.role.infrastructure.dataobject.RolePermissionDO;
import com.chomolungma.system.role.interfaces.assembler.RoleAssembler;
import com.chomolungma.system.role.interfaces.dto.RoleDTO;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import com.chomolungma.system.role.infrastructure.mybatis.repository.mapper.RoleMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RoleRepositoryImpl implements IRoleRepository {
    private final RoleMapper roleMapper;


    public RoleRepositoryImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public void saveMenus(Long roleId, List<Long> permissions) {
        roleMapper.deleteMenusPermissionByRoleId(roleId);
        RolePermissionDO permissionDO = new RolePermissionDO();
        permissionDO.setRoleId(roleId);
        permissionDO.setPermissions(permissions);
        if (!permissions.isEmpty()) {
            roleMapper.insertRoleMenusPermission(permissionDO);
        }
    }
    @Override
    public void saveOperations(Long roleId, List<Long> permissions) {
        roleMapper.deleteOperationsPermissionByRoleId(roleId);
        RolePermissionDO permissionDO = new RolePermissionDO();
        permissionDO.setRoleId(roleId);
        permissionDO.setPermissions(permissions);
        if (!permissions.isEmpty()) {
            roleMapper.insertRoleOperationsPermission(permissionDO);
        }
    }

    @Override
    public void saveResources(Long roleId, List<Long> permissions) {
        roleMapper.deleteResourcesPermissionByRoleId(roleId);
        RolePermissionDO permissionDO = new RolePermissionDO();
        permissionDO.setRoleId(roleId);
        permissionDO.setPermissions(permissions);
        if (!permissions.isEmpty()) {
            roleMapper.insertRoleResourcesPermission(permissionDO);
        }
    }

    @Override
    public void save(RoleEntity role) {
        RoleDO roleDO = RoleConverter.INSTANCE.toDO(role);
        if (role.getId() == null){
            roleMapper.insert(roleDO);
        } else {
            roleMapper.updateById(roleDO);
        }
        saveMenus(roleDO.getId(), Arrays.stream(new long[]{263L, 265L})
                .boxed()
                .collect(Collectors.toList()));


    }

    @Override
    public List<RolePermissionDTO> findMenus(Long roleId) {
        return roleMapper.selectMenusByRoleId(roleId);
    }

    @Override
    public List<RolePermissionDTO> findOperation(Long roleId) {
        return roleMapper.getOperations(roleId);
    }

    @Override
    public List<Long> findResources(Long roleId) {
        return roleMapper.getResources(roleId);
    }

    @Override
    public PageInfo<RoleDTO> find(int current, int size, RoleEntity role) {
        RoleDO roleDO = RoleConverter.INSTANCE.toDO(role);
        PageHelper.startPage(current,size);
        List<RoleDO> roleDOS = roleMapper.selectList(new QueryWrapper<RoleDO>().like(roleDO.getName() != null,"name", roleDO.getName()).like(roleDO.getCode() != null, "code", roleDO.getCode()).eq(roleDO.getEnabled() != null, "enabled", roleDO.getEnabled()));
        List<RoleEntity> roleEntities = RoleConverter.INSTANCE.toEntity(roleDOS);
        return new PageInfo<>(RoleAssembler.toDTO(roleEntities));
    }

    @Override
    public List<RoleDTO> findAll() {
        List<RoleDO> roleDOS = roleMapper.selectList(new QueryWrapper<>());
        return RoleAssembler.toDTO(RoleConverter.INSTANCE.toEntity(roleDOS));
    }

    @Override
    public RoleEntity find(Long roleId) {
        return RoleConverter.INSTANCE.toEntity(roleMapper.selectById(roleId));
    }

    @Override
    public void remove(List<Long> ids) {
        // 删除角色信息
        roleMapper.deleteBatchIds(ids);

        // 删除角色关联的菜单权限信息
        roleMapper.deletePermissionByBatchRoleIds(ids);

        // 删除角色关联账户信息
        roleMapper.deleteAccountRoleByBatchRoleIds(ids);

    }
}
