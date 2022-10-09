package com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {
    void deleteRoleMenuRelByMenuId(Long menuId);

    void deleteMenus(Long menuId);
}
