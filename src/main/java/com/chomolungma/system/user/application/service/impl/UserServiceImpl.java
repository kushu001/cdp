package com.chomolungma.system.user.application.service.impl;

import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.UserEntity;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.domain.service.impl.IUserDomainService;
import com.chomolungma.system.user.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final GetMenuDomainService getMenuDomainService;
    private final IUserRepository iUserRepository;
    private final IUserDomainService iUserDomainService;
    private final OrgAdapter orgAdapter;

    public UserServiceImpl(GetMenuDomainService getMenuDomainService, IUserRepository iUserRepository, IUserDomainService iUserDomainService, OrgAdapter orgAdapter) {
        this.getMenuDomainService = getMenuDomainService;
        this.iUserRepository = iUserRepository;
        this.iUserDomainService = iUserDomainService;
        this.orgAdapter = orgAdapter;
    }

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

    @Override
    public void audit(Long userId) {
        iUserRepository.audit(userId);
    }
}
