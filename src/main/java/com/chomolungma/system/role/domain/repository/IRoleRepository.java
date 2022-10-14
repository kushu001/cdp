package com.chomolungma.system.role.domain.repository;

import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleRepository {
     void saveMenus(Long roleId, List<Long> permissions);

     void saveOperations(Long roleId, List<Long> permissions);

     void save(RoleEntity role);

     List<MenuDO> query(List<Long> roleIds);

     List<RolePermissionDTO> queryMenus(Long roleId);

     List<RolePermissionDTO> queryOperation(Long roleId);

     PageInfo<RoleEntity> query(int current, int size, RoleEntity role);

     List<RoleEntity> queryAll();

     RoleEntity query(Long roleId);

     void remove(List<Long> ids);

}
