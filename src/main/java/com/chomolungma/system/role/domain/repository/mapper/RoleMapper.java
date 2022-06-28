package com.chomolungma.system.role.domain.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.menu.domain.repository.dataobject.MenuDO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.dataobject.RolePermissionDO;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper extends BaseMapper<RoleEntity> {
    void insertRolePermission(@Param("rolePermissionDO")RolePermissionDO rolePermissionDO);

    List<MenuDO> selectMenusByRoleIds(List<Long> roleIds);

    void deletePermissionByRoleId(Long roleId);

    List<RoleMenuDTO> selectMenusByRoleId(Long roleId);
}
