package com.chomolungma.system.user.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;

import java.util.List;

public interface UserService {
    PageUserDTO getUsers(String code, Page<UserEntity> page, UserEntity userEntity);

    UserDTO getUser(Long id);

    void createUser(Long orgId, UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUsers(String code, List<String> ids);

    List<MenuDTO> getMenus(List<Long> roleIds);
}
