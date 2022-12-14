package com.chomolungma.auth.login.application.service.impl;

import com.chomolungma.core.UserDetail;
import com.chomolungma.core.exception.BusinessRuntimeException;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.entity.Role;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SecurityServiceImpl implements UserDetailsService {
    private final IAccountRepository iAccountRepository;

    public SecurityServiceImpl(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户是否存在
        Account account = iAccountRepository.findAccount(username);

        if(Objects.isNull(account)){
            throw new BusinessRuntimeException("用户名或密码错误");
        }

        List<String> permissions = iAccountRepository.findPermissions(account.getId());

        List<String> resources = iAccountRepository.findResources(account.getId());
        return new UserDetail(account.getId(), account.getUsername(), account.getPassword(), account.getRoles().stream().map(Role::getId).collect(Collectors.toList()), permissions, resources);
    }
}
