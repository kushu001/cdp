package com.chomolungma.system.user.application.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.service.*;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private GetMenuDomainService getMenuDomainService;
    @Override
    public PageUserDTO getUsers(String code, Page<UserEntity> page, UserEntity userEntity) {
        Page<UserEntity> pageUsers  = execute(new PageUsersDomainService(code, page, userEntity));
        return UserAssembler.toPageUserDTO(pageUsers);
    }

    @Override
    public UserDTO getUser(Long id) {
        return UserAssembler.fromUserEntity(execute(new GetUserDomainService(id)));
    }

    @Override
    public void createUser(Long orgId, UserEntity userEntity) {
        execute(new CreateUserDomainService(orgId, userEntity));
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        execute(new UpdateUserDomainService(userEntity));
    }

    @Override
    public void deleteUsers(String code, List<String> ids) {
        execute(new DeleteUserDomainService(code, ids));
    }


    @Override
    public List<MenuDTO> getMenus(List<Long> roleIds) {
        return getMenuDomainService.getMenusByRoleIds(roleIds);
    }
}
