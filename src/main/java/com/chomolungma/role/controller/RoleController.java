package com.chomolungma.role.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.role.bo.InRoleFormBO;
import com.chomolungma.role.bo.OutRoleSearchBO;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.mapstruct.RoleEntityMapStruct;
import com.chomolungma.role.bo.InRoleSearchBO;
import com.chomolungma.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @GetMapping
    public Result pageList(InRoleSearchBO inRoleSearchBO){
        RoleEntity role = RoleEntityMapStruct.INSTANCE.fromSearchBO(inRoleSearchBO);
        OutRoleSearchBO pageResult = roleService.getRoles(new Page<>(inRoleSearchBO.getPage(), inRoleSearchBO.getLimit()),role);
        return Result.success(pageResult);
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(roleService.getRole(id));
    }

    @PostMapping
    public Result createRole(InRoleFormBO inRoleFormBO){
        RoleEntity role = RoleEntityMapStruct.INSTANCE.fromFormBO(inRoleFormBO);
        roleService.createRole(role);
        return Result.success();
    }

    @PutMapping
    public Result updateRole(InRoleFormBO inRoleFormBO){
        RoleEntity role = RoleEntityMapStruct.INSTANCE.fromFormBO(inRoleFormBO);
        roleService.updateRole(role);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable("ids") String ids){
        roleService.deleteByIds(Arrays.asList(ids.split(",")));
        return Result.success();
    }
}
