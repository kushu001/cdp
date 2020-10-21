package com.chomolungma.user.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.common.result.Result;
import com.chomolungma.user.mapper.UserMapper;
import com.chomolungma.user.param.UserSearchParam;
import com.chomolungma.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping
    public Result queryUser(UserSearchParam userSearchParam){
        Page<User> page = new Page<>(userSearchParam.getCurrent(), userSearchParam.getPageSize());
        User user = new User();
        user.setName(userSearchParam.getName());
        user.setGender(userSearchParam.getGender());

        IPage<User> userList = userMapper.selectPageVo(page,user);
        Result result =Result.success("成功",userList);
        return result;
    }
}
