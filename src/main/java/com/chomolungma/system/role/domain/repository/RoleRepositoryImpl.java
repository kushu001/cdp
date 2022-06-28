package com.chomolungma.system.role.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.menu.domain.repository.converter.MenuConverter;
import com.chomolungma.system.menu.domain.repository.dataobject.MenuDO;
import com.chomolungma.system.role.domain.repository.dataobject.RolePermissionDO;
import com.chomolungma.system.role.domain.repository.mapper.RoleMapper;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleRepositoryImpl implements IRoleRepository{
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void save(Long roleId, List<RoleMenuDTO> permissions) {
        roleMapper.deletePermissionByRoleId(roleId);
        RolePermissionDO permissionDO = new RolePermissionDO();
        permissionDO.setRoleId(roleId);
        permissionDO.setPermissions(permissions);
        if (permissions.size() > 0) {
            roleMapper.insertRolePermission(permissionDO);
        }
    }

    @Override
    public List<MenuEntity> query(List<Long> roleIds) {
        List<MenuDO> menuDOS = roleMapper.selectMenusByRoleIds(roleIds);
        return MenuConverter.INSTANCE.toEntity(menuDOS);
    }

    @Override
    public List<RoleMenuDTO> query(Long roleId) {
        return roleMapper.selectMenusByRoleId(roleId);
    }
}
