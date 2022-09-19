package com.chomolungma.system.user.application.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.org.infrastructure.mybatis.repository.mapper.OrgMapper;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.domain.service.DeleteUserDomainService;
import com.chomolungma.system.user.domain.service.GetUserDomainService;
import com.chomolungma.system.user.domain.service.UpdateUserDomainService;
import com.chomolungma.system.user.domain.service.UserDomainService;
import com.chomolungma.system.user.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.OrgUserMapper;
import com.chomolungma.system.user.infrastructure.mybatis.repository.mapper.UserMapper;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private UserDomainService userDomainService;

    @Autowired
    private IOrgRepository iOrgRepository;

    @Autowired
    private OrgAdapter orgAdapter;
    @Override
    public PageUserDTO getUsersByOrg(String code, UserSearchDTO userSearchDTO) {
        return iUserRepository.getUserByIds(code, userSearchDTO.getPage(), userSearchDTO.getLimit());
    }

    @Override
    public UserDTO getUser(Long id) {
        return UserAssembler.fromUserEntity(execute(new GetUserDomainService(id)));
    }

    @Override
    public void createUser(Long orgId, UserFormDTO userFormDTO) {
        com.chomolungma.system.user.domain.entity.User user = UserAssembler.toEntity(userFormDTO);
        Org org = orgAdapter.adapter(orgId);
        user.setOrg(org);
        userDomainService.save(user);
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
        //return UserAssembler.toPageUserDTO(userMapper.selectPage(page, new QueryWrapper<UserEntity>().like(userEntity.getName() !=null,"name",userEntity.getName())));
        return null; //TODO
    }

    @Override
    public List<User> getUsers(String code, UserEntity userEntity) {
        return UserAssembler.toDTO(iUserRepository.getUsers(code, userEntity));
    }
}
