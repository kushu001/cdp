package com.chomolungma.system.role.domain.repository;

import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import com.chomolungma.system.role.interfaces.dto.RoleDTO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleRepository {
     void saveMenus(Long roleId, List<Long> permissions);

     void saveOperations(Long roleId, List<Long> permissions);

     void save(RoleEntity role);

     List<RolePermissionDTO> findMenus(Long roleId);

     List<RolePermissionDTO> findOperation(Long roleId);

     List<Long> findResources(Long roleId);

     PageInfo<RoleDTO> find(int current, int size, RoleEntity role);

     List<RoleDTO> findAll();

     RoleEntity find(Long roleId);

     void remove(List<Long> ids);

}
