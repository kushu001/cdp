package com.chomolungma.system.login.application.service.impl;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.login.domain.UserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class SecurityServiceImpl implements UserDetailsService {
    private final IAccountRepository iAccountRepository;

    public SecurityServiceImpl(IAccountRepository iAccountRepository) {
        this.iAccountRepository = iAccountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 查询用户是否存在
        Account account = iAccountRepository.queryAccount(username);

        if(Objects.isNull(account)){
            throw new BusinessRuntimeException("用户名或密码错误");
        }
        List<String> permissions = iAccountRepository.findPermissions(account.getId());
        return new UserDetail(account, permissions);
    }
}
