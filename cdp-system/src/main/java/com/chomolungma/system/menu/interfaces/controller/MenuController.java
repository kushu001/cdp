package com.chomolungma.system.menu.interfaces.controller;

import com.chomolungma.system.menu.application.service.MenuService;
import com.chomolungma.core.result.Result;
import com.chomolungma.system.menu.domain.repository.IMenuRepository;
import com.chomolungma.system.menu.interfaces.assembler.MenuAssembler;
import com.chomolungma.system.menu.interfaces.param.MenuParam;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/menu")
public class MenuController {
    private final MenuService menuService;
    private final IMenuRepository iMenuRepository;

    public MenuController(MenuService menuService, IMenuRepository iMenuRepository){
        this.iMenuRepository = iMenuRepository;
        this.menuService = menuService;
    }

    @GetMapping
    public Result queryMenu(){
        return Result.success(iMenuRepository.find());
    }

    @GetMapping("/type/{type}")
    public Result queryMenuPermissions(@PathVariable("type") String type){
        return Result.success(menuService.permissions(type));
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
        menuService.deleteMenu(id);
        return Result.success();
    }
}
