package com.chomolungma.system.role.interfaces.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.core.interfaces.dto.PageDTO;
import com.chomolungma.system.role.application.service.RoleService;
import com.chomolungma.system.role.domain.enity.RoleEntity;
import com.chomolungma.system.role.domain.repository.IRoleRepository;
import com.chomolungma.system.role.interfaces.assembler.RoleAssembler;
import com.chomolungma.system.role.interfaces.dto.InPermissionDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleFormDTO;
import com.chomolungma.system.role.interfaces.dto.InRoleSearchDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    public final RoleService roleService;

    public final IRoleRepository iRoleRepository;

    public RoleController(RoleService roleService, IRoleRepository iRoleRepository) {
        this.roleService = roleService;
        this.iRoleRepository = iRoleRepository;
    }

    @GetMapping
    public Result pageList(PageDTO pageDTO,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String code,
                           @RequestParam(required = false) Integer status){
        InRoleSearchDTO inRoleSearchDTO = new InRoleSearchDTO();
        inRoleSearchDTO.setName(name);
        inRoleSearchDTO.setCode(code);
        inRoleSearchDTO.setStatus(status);
        RoleEntity role = RoleAssembler.toEntity(inRoleSearchDTO);
        return Result.success(RoleAssembler.toDTO(iRoleRepository.query(pageDTO.getPage(), pageDTO.getLimit(), role)));
    }

    @GetMapping("/all")
    public Result list(){
        return Result.success(iRoleRepository.queryAll());
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(iRoleRepository.query(id));
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
        iRoleRepository.remove(Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList()));
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
