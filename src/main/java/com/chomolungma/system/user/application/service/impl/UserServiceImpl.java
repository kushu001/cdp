package com.chomolungma.system.user.application.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.org.domain.entity.OrgEntity;
import com.chomolungma.system.org.mapper.OrgMapper;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.OrgUserEntity;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.domain.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.domain.repository.mapper.UserMapper;
import com.chomolungma.system.user.domain.service.*;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.User;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends BaseService implements UserService {
    @Autowired
    private GetMenuDomainService getMenuDomainService;

    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrgMapper orgMapper;

    @Autowired
    private OrgUserMapper orgUserMapper;
    @Override
    public PageUserDTO getUsersByOrg(String code, Page<UserEntity> page, UserEntity userEntity) {
        List<OrgEntity> orgEntities = orgMapper.selectList(new QueryWrapper<OrgEntity>().likeRight("code", code));
        List<OrgUserEntity> orgUserEntities = orgUserMapper.selectList(new QueryWrapper<OrgUserEntity>().in("org_id", orgEntities.stream().map(OrgEntity::getId).collect(Collectors.toList())));
        List<Long> userIds = orgUserEntities.stream().map(OrgUserEntity::getUserId).collect(Collectors.toList());
        return iUserRepository.getUserByIds(userIds, (int)page.getCurrent(), (int)page.getSize());
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

    @Override
    public PageUserDTO getUsers(Page<UserEntity> page, UserEntity userEntity) {
        return UserAssembler.toPageUserDTO(userMapper.selectPage(page, new QueryWrapper<UserEntity>().like(userEntity.getName() !=null,"name",userEntity.getName())));
    }

    @Override
    public List<User> getUsers(String code, UserEntity userEntity) {
        return UserAssembler.toDTO(iUserRepository.getUsers(code, userEntity));
    }
}
