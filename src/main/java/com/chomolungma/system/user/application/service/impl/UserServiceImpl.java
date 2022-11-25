package com.chomolungma.system.user.application.service.impl;

import com.chomolungma.system.menu.interfaces.dto.MenuDTO;
import com.chomolungma.system.role.domain.service.GetMenuDomainService;
import com.chomolungma.system.user.application.service.UserService;
import com.chomolungma.system.user.domain.entity.Org;
import com.chomolungma.system.user.domain.entity.User;
import com.chomolungma.system.user.domain.repository.IUserRepository;
import com.chomolungma.system.user.domain.service.impl.IUserDomainService;
import com.chomolungma.system.user.infrastructure.adapter.OrgAdapter;
import com.chomolungma.system.user.interfaces.assembler.UserAssembler;
import com.chomolungma.system.user.interfaces.dto.PageUserDTO;
import com.chomolungma.system.user.interfaces.dto.UserDTO;
import com.chomolungma.system.user.interfaces.dto.UserFormDTO;
import com.chomolungma.system.user.interfaces.dto.UserSearchDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageUserDTO getUsers(String code, String name, String idNumber, String phone, String tel, String address, Integer page, Integer limit) {
        User user = new User();
        user.setName(name);
        user.setIdNumber(idNumber);
        user.setPhone(phone);
        user.setTel(tel);
        user.setAddress(address);
        PageHelper.startPage(page, limit);
        List<UserDTO> userOrgDOS = iUserRepository.getUsers(code, user);
        PageInfo<UserDTO> pageInfo = new PageInfo<>(userOrgDOS);
        return UserAssembler.toPageUserDTO(pageInfo);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user  = iUserRepository.findUser(id);
        return UserAssembler.toDTO(user);
    }

    @Override
    public void createUser(Long orgId, UserFormDTO userFormDTO) {
        User user = UserAssembler.toEntity(userFormDTO);
        Org org = orgAdapter.adapter(orgId);
        user.setOrg(org);
        iUserDomainService.addUser(user);
    }

    @Override
    public void updateUser(User user) {
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
    public List<UserDTO> getUsers(String code, String name, String idNumber, String phone, String tel, String address) {
        User user = new User();
        user.setName(name);
        user.setIdNumber(idNumber);
        user.setPhone(phone);
        user.setTel(tel);
        user.setAddress(address);
        return iUserRepository.getUsers(code, user);
    }

    @Override
    public void audit(Long userId) {
        User user = iUserRepository.findUser(userId);
        user.audit();
        iUserRepository.save(user);
    }
}
