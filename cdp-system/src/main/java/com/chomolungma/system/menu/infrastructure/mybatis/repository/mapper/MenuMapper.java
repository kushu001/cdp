package com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDO> {
    List<MenuDO> selectMenusByRoleIds(List<Long> roleIds);
    void deleteRoleMenuRelByMenuId(Long menuId);

    void deleteMenus(Long menuId);
}
