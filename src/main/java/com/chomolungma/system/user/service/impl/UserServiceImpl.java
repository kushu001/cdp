package com.chomolungma.system.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.user.mapper.UserMapper;
import com.chomolungma.system.user.pojo.User;
import com.chomolungma.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public IPage<User> queryUser(Page<User> page, User user, Long orgId) {
        return userMapper.selectPageVo(page,user,orgId);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUser(String ids) {
        userMapper.deleteBatchIds(Arrays.asList(ids.split(",")));
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

}
