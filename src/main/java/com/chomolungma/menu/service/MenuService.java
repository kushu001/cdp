package com.chomolungma.menu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.menu.pojo.Menu;

import java.util.List;

public interface MenuService {

    IPage<Menu> queryMenu(Page<Menu> page, Menu menu);


    List<Menu> query(Menu menu);


    void createMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenus(Long id);
}
