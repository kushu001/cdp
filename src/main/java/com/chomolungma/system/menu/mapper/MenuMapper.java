package com.chomolungma.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chomolungma.system.menu.domain.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenuMapper extends BaseMapper<MenuEntity> {
    void deleteRoleMenuRelByMenuId(Long menuId);

    void deleteMenus(Long menuId);
}
