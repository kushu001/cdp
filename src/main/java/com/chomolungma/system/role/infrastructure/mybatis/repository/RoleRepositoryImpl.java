package com.chomolungma.system.role.infrastructure.mybatis.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.infrastructure.converter.RoleConverter;
import com.chomolungma.system.role.infrastructure.dataobject.RoleDO;
import com.chomolungma.system.role.infrastructure.dataobject.RolePermissionDO;
import com.chomolungma.system.role.infrastructure.mybatis.repository.mapper.RoleMapper;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        if (permissions.size() > 0) {
            roleMapper.insertRoleMenusPermission(permissionDO);
        }
    }
    @Override
    public void saveOperations(Long roleId, List<Long> permissions) {
        roleMapper.deleteOperationsPermissionByRoleId(roleId);
        RolePermissionDO permissionDO = new RolePermissionDO();
        permissionDO.setRoleId(roleId);
        permissionDO.setPermissions(permissions);
        if (permissions.size() > 0) {
            roleMapper.insertRoleOperationsPermission(permissionDO);
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

    }

    @Override
    public List<MenuDO> query(List<Long> roleIds) {
        return roleMapper.selectMenusByRoleIds(roleIds);
    }

    @Override
    public List<RolePermissionDTO> queryMenus(Long roleId) {
        return roleMapper.selectMenusByRoleId(roleId);
    }

    @Override
    public List<RolePermissionDTO> queryOperation(Long roleId) {
        return roleMapper.getOperations(roleId);
    }

    @Override
    public PageInfo<RoleEntity> query(int current, int size, RoleEntity role) {
        RoleDO roleDO = RoleConverter.INSTANCE.toDO(role);
        PageHelper.startPage(current,size);
        List<RoleDO> roleDOS = roleMapper.selectList(new QueryWrapper<RoleDO>().like(roleDO.getName() != null,"name", roleDO.getName()).like(roleDO.getCode() != null, "code", roleDO.getCode()).eq(roleDO.getStatus() != null, "status", roleDO.getStatus()));
        return new PageInfo<>(RoleConverter.INSTANCE.toEntity(roleDOS));
    }

    @Override
    public List<RoleEntity> queryAll() {
        List<RoleDO> roleDOS = roleMapper.selectList(new QueryWrapper<>());
        return RoleConverter.INSTANCE.toEntity(roleDOS);
    }

    @Override
    public RoleEntity query(Long roleId) {
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
