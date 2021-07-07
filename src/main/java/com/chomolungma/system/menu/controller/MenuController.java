package com.chomolungma.system.menu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.system.common.result.Result;
import com.chomolungma.system.menu.mapper.MenuMapper;
import com.chomolungma.system.menu.param.MenuParam;
import com.chomolungma.system.menu.param.MenuSearchParam;
import com.chomolungma.system.menu.pojo.Menu;
import com.chomolungma.system.menu.service.MenuService;
import com.chomolungma.system.menu.assembler.MenuAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {

    private MenuService menuService;

    private MenuMapper menuMapper;

    public MenuController(MenuService menuService, MenuMapper menuMapper){
        this.menuService = menuService;
        this.menuMapper = menuMapper;
    }

    @GetMapping
    public Result queryMenu(MenuSearchParam menuSearchParam){

        Menu menu = new Menu();

        menu.setName(menuSearchParam.getName());

        menu.setUrl(menuSearchParam.getUrl());

        menu.setIcon(menuSearchParam.getIcon());

        menu.setStatus(menuSearchParam.getStatus());

        List<Menu> menuList = menuService.query(menu);

        return Result.success(MenuAssembler.convertToDto(menuList));

    }

    @GetMapping("/all")
    public Result queryAll(){
        return Result.success(menuMapper.selectList(new QueryWrapper<>()));
    }


    @PostMapping
    public Result createMenu(@RequestBody MenuParam menuParam){
        menuService.createMenu(MenuAssembler.convertParamToEntity(menuParam));
        return Result.success();
    }

    @PutMapping
    public Result updateMenu(@RequestBody MenuParam menuParam){
        menuService.updateMenu(MenuAssembler.convertParamToEntity(menuParam));
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteMenu(@PathVariable("id") Long id){
        menuService.deleteMenus(id);
        return Result.success();
    }
}
