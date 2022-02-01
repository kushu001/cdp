package com.chomolungma.role.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.role.enity.RoleEntity;
import com.chomolungma.role.mapstruct.RoleEntityMapStruct;
import com.chomolungma.role.bo.InRoleBO;
import com.chomolungma.role.bo.OutRoleBO;
import com.chomolungma.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    public RoleService roleService;

    @GetMapping
    public Result pageList(InRoleBO inRoleBO){
        RoleEntity role = RoleEntityMapStruct.INSTANCE.toEntity(inRoleBO);
        OutRoleBO pageResult = roleService.getRoles(new Page<>(inRoleBO.getPage(), inRoleBO.getLimit()),role);
        return Result.success(pageResult);
    }
}
