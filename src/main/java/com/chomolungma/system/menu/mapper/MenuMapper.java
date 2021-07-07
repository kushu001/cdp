package com.chomolungma.system.menu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.menu.pojo.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<Menu> {
    IPage<Menu> selectPageVo(Page<?> page, @Param("org") Menu menu);

    List<Menu> selectVo(Menu menu);

    void deleteMenus(Long id);
}
