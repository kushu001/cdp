package com.chomolungma.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.user.pojo.User;

public interface UserService{

    IPage<User> queryUser(Page<User> page, User user,Long orgId);

    void addUser(User user);

    void deleteUser(String ids);

    void updateUser(User user);

}
