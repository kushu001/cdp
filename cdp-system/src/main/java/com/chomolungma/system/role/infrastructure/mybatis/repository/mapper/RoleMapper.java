package com.chomolungma.system.role.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.role.infrastructure.dataobject.RoleDO;
import com.chomolungma.system.role.infrastructure.dataobject.RolePermissionDO;
import com.chomolungma.system.role.interfaces.dto.RolePermissionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
    void insertRoleMenusPermission(@Param("rolePermissionDO") RolePermissionDO rolePermissionDO);
    void insertRoleOperationsPermission(@Param("rolePermissionDO")RolePermissionDO rolePermissionDO);
    void deleteMenusPermissionByRoleId(Long roleId);
    void deleteOperationsPermissionByRoleId(Long roleId);
    List<RolePermissionDTO> selectMenusByRoleId(Long roleId);
    void deletePermissionByBatchRoleIds(List<Long> ids);
    void deleteAccountRoleByBatchRoleIds(List<Long> ids);
    List<RolePermissionDTO> getOperations(Long roleId);
    List<Long> getResources(Long roleId);
}
