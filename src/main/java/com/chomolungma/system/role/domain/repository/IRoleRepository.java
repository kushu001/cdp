package com.chomolungma.system.role.domain.repository;

import com.chomolungma.system.menu.domain.entity.MenuEntity;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.RoleMenuDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IRoleRepository {
     void save(Long roleId, List<RoleMenuDTO> permissions);

     void save(RoleEntity role);

     List<MenuEntity> query(List<Long> roleIds);

     List<RoleMenuDTO> queryMenus(Long roleId);

     PageInfo<RoleEntity> query(int current, int size, RoleEntity role);

     List<RoleEntity> queryAll();

     RoleEntity query(Long roleId);

     void remove(List<Long> ids);

}
