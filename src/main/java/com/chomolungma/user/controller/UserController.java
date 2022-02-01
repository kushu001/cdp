package com.chomolungma.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.user.param.UserParam;
import com.chomolungma.user.param.UserSearchBO;
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
    public Result queryUser(UserSearchBO userSearchParam){

        Page<User> page = new Page<>(userSearchParam.getPage(), userSearchParam.getLimit());

        User user = new User();

        user.setName(userSearchParam.getName());

        user.setGender(userSearchParam.getGender());

        user.setTel(userSearchParam.getTel());

        user.setAddr(userSearchParam.getAddr());

        user.setCompany(userSearchParam.getCompany());

        user.setStatus(userSearchParam.getStatus());

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
