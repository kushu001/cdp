package com.chomolungma.system.role.interfaces.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.role.interfaces.assembler.RoleAssembler;
import com.chomolungma.system.role.interfaces.dto.InPermissionDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.OutRoleSearchDTO;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import com.chomolungma.system.role.application.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @GetMapping
    public Result pageList(InRoleSearchDTO inRoleSearchDTO){
        RoleEntity role = RoleAssembler.toEntity(inRoleSearchDTO);
        OutRoleSearchDTO pageResult = roleService.getPageRoles(new Page<>(inRoleSearchDTO.getPage(), inRoleSearchDTO.getLimit()),role);
        return Result.success(pageResult);
    }

    @GetMapping("/all")
    public Result list(InRoleFormDTO inRoleFormDTO){
        RoleEntity role = RoleAssembler.toEntity(inRoleFormDTO);
        return Result.success(roleService.getRoles(role));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(roleService.getRole(id));
    }

    @PostMapping
    public Result createRole(@RequestBody InRoleFormDTO inRoleFormDTO){
        RoleEntity role = RoleAssembler.toEntity(inRoleFormDTO);
        roleService.createRole(role);
        return Result.success();
    }

    @PutMapping
    public Result updateRole(@RequestBody InRoleFormDTO inRoleFormDTO){
        RoleEntity role = RoleAssembler.toEntity(inRoleFormDTO);
        roleService.updateRole(role);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result deleteById(@PathVariable("ids") String ids){
        roleService.deleteByIds(Arrays.asList(ids.split(",")));
        return Result.success();
    }

    @PostMapping("/{roleId}/authorized")
    public Result authorized(@PathVariable("roleId") Long roleId, @RequestBody InPermissionDTO inPermissionDTO){
        roleService.authorized(roleId, inPermissionDTO.getPermissions());
        return Result.success();
    }

    @GetMapping("/{roleId}/permission")
    public Result permission(@PathVariable("roleId") Long roleId){
        return Result.success(roleService.permission(roleId));
    }
}
