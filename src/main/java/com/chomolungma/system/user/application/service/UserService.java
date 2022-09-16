package com.chomolungma.system.user.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.interfaces.dto.*;

import java.util.List;

public interface UserService {
    PageUserDTO getUsersByOrg(String code, UserSearchDTO userSearchDTO);

    UserDTO getUser(Long id);

    void createUser(Long orgId, UserFormDTO userFormDTO);

    void updateUser(UserEntity userEntity);

    void deleteUsers(String code, List<String> ids);

    List<MenuDTO> getMenus(List<Long> roleIds);

    PageUserDTO getUsers(Page<UserEntity> page, UserEntity userEntity);

    List<User> getUsers(String code, UserEntity userEntity);
}
