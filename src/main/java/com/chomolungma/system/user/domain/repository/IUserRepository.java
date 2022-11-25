package com.chomolungma.system.user.domain.repository;

import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;

import java.util.List;

public interface IUserRepository {
    List<UserDTO> getUsers(String code, User user);
    void save(User user);
    void remove(List<Long> ids);
    User findUser(String idNumber);
    User findUser(Long id);
}
