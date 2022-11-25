package com.chomolungma.system.user.application.service;

import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.interfaces.dto.*;

import java.util.List;

public interface UserService {
    PageUserDTO getUsers(String code, String name, String idNumber, String phone, String tel, String address, Integer page, Integer limit);
    List<UserDTO> getUsers(String code, String name, String idNumber, String phone, String tel, String address);
    UserDTO getUser(Long id);
    void createUser(Long orgId, UserFormDTO userFormDTO);
    void updateUser(User user);
    void deleteUsers(String code, List<String> ids);
    List<MenuDTO> getMenus(List<Long> roleIds);
    void audit(Long userId);
}
