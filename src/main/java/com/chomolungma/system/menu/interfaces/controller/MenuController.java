package com.chomolungma.system.menu.interfaces.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.system.menu.infrastructure.dataobject.MenuDO;
import com.chomolungma.system.menu.infrastructure.mybatis.repository.mapper.MenuMapper;
import com.chomolungma.system.menu.interfaces.assembler.MenuAssembler;
import com.chomolungma.system.menu.param.MenuParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;

    private final MenuMapper menuMapper;

    public MenuController(MenuMapper menuMapper, MenuService menuService){
        this.menuMapper = menuMapper;
        this.menuService = menuService;
    }

    @GetMapping
    public Result queryMenu(){
        List<MenuDO> menuList = menuMapper.selectList(new QueryWrapper<MenuDO>().orderByAsc("sort"));
        return Result.success(MenuAssembler.convertToDto(menuList));
    }

    @GetMapping("/type/{type}")
    public Result queryMenuPermissions(@PathVariable("type") String type){
        return Result.success(menuService.permissions(type));
    }



//
//    @GetMapping("/all")
//    public Result queryAll(){
//        return Result.success(menuMapper.selectList(new QueryWrapper<>()));
//    }


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
        menuService.deleteMenu(id);
        return Result.success();
    }
}
