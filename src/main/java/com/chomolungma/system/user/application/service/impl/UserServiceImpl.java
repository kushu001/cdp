package com.chomolungma.system.user.application.service.impl;

import com.chomolungma.core.application.service.BaseService;
import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.org.domain.repository.IOrgRepository;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.domain.service.impl.IUserDomainService;
import com.chomolungma.system.user.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.*;
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
    private IUserDomainService iUserDomainService;
    @Autowired
    private IOrgRepository iOrgRepository;
    @Autowired
    private OrgAdapter orgAdapter;
    @Override
    public PageUserDTO getUsersByOrg(String code, UserSearchDTO userSearchDTO) {
        com.chomolungma.system.user.domain.entity.User user = UserAssembler.toEntity(userSearchDTO);
        return iUserRepository.getUsersByCode(code, user, userSearchDTO.getPage(), userSearchDTO.getLimit());
    }

    @Override
    public UserDTO getUser(Long id) {
        return iUserRepository.findUser(id);
    }

    @Override
    public void createUser(Long orgId, UserFormDTO userFormDTO) {
        com.chomolungma.system.user.domain.entity.User user = UserAssembler.toEntity(userFormDTO);
        Org org = orgAdapter.adapter(orgId);
        user.setOrg(org);
        iUserDomainService.addUser(user);
    }

    @Override
    public void updateUser(com.chomolungma.system.user.domain.entity.User user) {
        iUserDomainService.modifyUser(user);
    }

    @Override
    public void deleteUsers(String code, List<String> ids) {
        iUserRepository.remove(ids.stream().map(Long::valueOf).collect(Collectors.toList()));
    }


    @Override
    public List<MenuDTO> getMenus(List<Long> roleIds) {
        return getMenuDomainService.getMenusByRoleIds(roleIds);
    }

    @Override
    public PageUserDTO getUsers(UserSearchDTO userSearchDTO) {
        return iUserRepository.getUsers(UserAssembler.toEntity(userSearchDTO), userSearchDTO.getPage(), userSearchDTO.getLimit());
    }

    @Override
    public List<User> getUsers(String code, UserEntity userEntity) {
        return UserAssembler.toDTO(iUserRepository.getUsers(code, userEntity));
    }
}
