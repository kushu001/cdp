package com.chomolungma.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.user.mapper.UserMapper;
import com.chomolungma.user.pojo.User;
import com.chomolungma.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> queryUser(Page<User> page, User user) {
        return userMapper.selectPageVo(page,user);
    }

}
