package com.chomolungma.system.user.domain.repository;

import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;

import java.util.List;

public interface IUserRepository {
    PageUserDTO getUsersByCode(String code, User user, int current, int size);
    PageUserDTO getUsers(User user, int current, int size);

    List<UserEntity> getUsers(String code, UserEntity userEntity);

    void save(User user);

    void remove(List<Long> ids);

    User findUser(String idNumber);

    UserDTO findUser(Long id);

    void audit(Long id);
}
