package com.chomolungma.system.user.domain.service.impl;


import com.chomolungma.system.user.domain.entity.User;

public interface IUserDomainService {
    void addUser(User user);

    void modifyUser(User user);
}
