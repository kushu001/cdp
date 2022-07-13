package com.chomolungma.system.user.interfaces.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

//    @GetMapping
//    public Result list(){
//        List<UserEntity> users = userMapper.selectList(new QueryWrapper<>());
//        return Result.success(users);
//    }

    @GetMapping
    public Result pageList(UserSearchDTO userSearchDTO){
        Page<UserEntity> page = new Page<>(userSearchDTO.getPage(), userSearchDTO.getLimit());
        return Result.success(userService.getUsers(page, UserAssembler.toUserEntity(userSearchDTO)));
    }

    @GetMapping("/org/{code}")
    public Result pageList(@PathVariable("code") String code, UserSearchDTO userSearchDTO){
        Page<UserEntity> page = new Page<>(userSearchDTO.getPage(), userSearchDTO.getLimit());
        return Result.success(userService.getUsersByOrg(code, page, UserAssembler.toUserEntity(userSearchDTO)));
    }

    @GetMapping("/{id}")
    public Result info(@PathVariable("id") Long id){
        return Result.success(userService.getUser(id));
    }

    @PostMapping("/org/{orgId}")
    public Result createUser(@PathVariable("orgId") Long orgId, @RequestBody UserFormDTO userFormDTO){
        userService.createUser(orgId, UserAssembler.toUserEntity(userFormDTO));
        return Result.success();
    }

    @PutMapping
    public Result updateUser(@RequestBody UserFormDTO userFormDTO){
        userService.updateUser(UserAssembler.toUserEntity(userFormDTO));
        return Result.success();
    }

    @GetMapping("/menu")
    public Result getMenus(){
        List<Long> roleIds = CurrentProfileHolder.getProfile().getRoleIds();
        return Result.success(userService.getMenus(roleIds));
    }

}
