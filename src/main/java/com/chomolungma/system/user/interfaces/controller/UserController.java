package com.chomolungma.system.user.interfaces.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.common.result.Result;
import com.chomolungma.system.user.param.UserParam;
import com.chomolungma.system.user.param.UserSearchParam;
import com.chomolungma.system.user.pojo.User;
import com.chomolungma.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{orgId}")
    public Result queryUser(UserSearchParam userSearchParam, @PathVariable("orgId") Long orgId){

        Page<User> page = new Page<>(userSearchParam.getCurrent(), userSearchParam.getPageSize());

        User user = new User();

        user.setName(userSearchParam.getName());

        user.setGender(userSearchParam.getGender());

        user.setTel(userSearchParam.getTel());

        user.setAddr(userSearchParam.getAddr());

        user.setCompany(userSearchParam.getCompany());

        user.setStatus(userSearchParam.getStatus());

        IPage<User> userList = userService.queryUser(page,user,orgId);

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

    @PutMapping
    public Result updateUser(@RequestBody UserParam userParam){

        User user = new User();

        user.setId(userParam.getId());

        user.setName(userParam.getName());

        user.setGender(userParam.getGender());

        user.setTel(userParam.getTel());

        user.setAddr(userParam.getAddr());

        user.setCompany(userParam.getCompany());

        user.setStatus(userParam.getStatus());

        userService.updateUser(user);

        return Result.success();
    }


    @DeleteMapping("/{ids}")
    public Result deleteUser(@PathVariable("ids") String ids){
        userService.deleteUser(ids);
        return Result.success();
    }

}
