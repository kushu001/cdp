package com.chomolungma.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.user.mapper.UserMapper;
import com.chomolungma.user.param.UserParam;
import com.chomolungma.user.param.UserSearchParam;
import com.chomolungma.user.pojo.User;
import com.chomolungma.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Result queryUser(UserSearchParam userSearchParam){

        Page<User> page = new Page<>(userSearchParam.getCurrent(), userSearchParam.getPageSize());

        User user = new User();

        user.setName(userSearchParam.getName());

        user.setGender(userSearchParam.getGender());

        IPage<User> userList = userService.queryUser(page,user);

        return Result.success(userList);

    }


    @PostMapping
    public Result addUser(@RequestBody UserParam userParam){

        User user = new User();

        user.setName(userParam.getName());

        user.setGender(userParam.getGender());

        user.setTel(userParam.getTel());

        user.setAddr(userParam.getAddr());

        user.setCompany(userParam.getCompany());

        user.setStatus(userParam.getStatus());

        userService.addUser(user);

        return Result.success();
    }


    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return Result.success();
    }

}
