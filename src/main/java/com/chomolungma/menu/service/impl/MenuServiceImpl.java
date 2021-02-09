package com.chomolungma.menu.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.menu.mapper.MenuMapper;
import com.chomolungma.menu.pojo.Menu;
import com.chomolungma.menu.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private MenuMapper menuMapper;

    public MenuServiceImpl(MenuMapper menuMapper){
        this.menuMapper = menuMapper;
    }

    @Override
    public IPage<Menu> queryMenu(Page<Menu> page, Menu menu) {
        return menuMapper.selectPageVo(page,menu);
    }

    @Override
    public List<Menu> query(Menu menu) {
        return menuMapper.selectVo(menu);
    }

    @Override
    public void createMenu(Menu menu) {
        menuMapper.insert(menu);
    }


    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateById(menu);
    }

    @Override
    public void deleteMenus(Long id) {
        menuMapper.deleteMenus(id);
    }
}
