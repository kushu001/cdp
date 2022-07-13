package com.chomolungma.system.org.interfaces.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.system.org.application.service.OrgService;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.interfaces.assembler.OrgAssembler;
import com.chomolungma.system.org.interfaces.param.OrgParam;
import com.chomolungma.system.org.interfaces.param.OrgSearchParam;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/v1/org")
public class OrgController {

    private OrgService orgService;

    private UserService userService;

    private OrgMapper orgMapper;

    public OrgController(OrgService orgService,UserService userService, OrgMapper orgMapper){
        this.orgService = orgService;
        this.userService = userService;
        this.orgMapper = orgMapper;
    }

    @GetMapping
    public Result queryOrg(OrgSearchParam orgSearchParam){
       List<OrgEntity> orgList = orgMapper.selectVo(OrgAssembler.convertParamToEntity(orgSearchParam));
        return Result.success(OrgAssembler.toDTO(orgList));

    }


    @GetMapping("/{id}")
    public Result getOrg(@PathVariable("id") Long id){
        return Result.success(orgMapper.selectById(id));
    }

    @GetMapping("/all")
    public Result queryAll(){
        return Result.success(orgMapper.selectList(new QueryWrapper<>()));
    }


    @PostMapping
    public Result createOrg(@RequestBody OrgParam orgParam){
        orgService.createOrg(OrgAssembler.convertParamToEntity(orgParam));
        return Result.success();
    }

    @PutMapping
    public Result updateOrg(@RequestBody OrgParam orgParam){
        orgService.updateOrg(OrgAssembler.convertParamToEntity(orgParam));
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteOrg(@PathVariable("id") Long id){
        orgService.deleteOrg(id);
        return Result.success();
    }

    @GetMapping("/{code}/user")
    public Result getUsersByOrgId(@PathVariable("code") String code, UserSearchDTO userSearchDTO){
        Page<UserEntity> page = new Page<>(userSearchDTO.getPage(), userSearchDTO.getLimit());
        return Result.success(userService.getUsersByOrg(code, page, UserAssembler.toUserEntity(userSearchDTO)));
    }

    @DeleteMapping("/{code}/user/{ids}")
    public Result deleteUsers(@PathVariable("code") String code, @PathVariable("ids") String ids){
        userService.deleteUsers(code, Arrays.asList(ids.split(",")));
        return Result.success();
    }

}
