package com.chomolungma.system.user.domain.repository;

import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;

import java.util.List;

public interface IUserRepository {
    PageUserDTO getUserByIds(String code, int current, int size);

    List<UserEntity> getUsers(String code, UserEntity userEntity);

    void save(User user);

    User findUser(String idNumber);
}
