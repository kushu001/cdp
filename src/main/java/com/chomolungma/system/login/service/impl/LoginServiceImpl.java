package com.chomolungma.system.login.service.impl;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.infrastructure.TokenUtils;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private IAccountRepository iAccountRepository;

    @Override
    public String login(String username, String password) {
        // 查询用户是否存在
        Account account = iAccountRepository.queryAccountUser(username,password);

        if(account == null)
            throw new BusinessRuntimeException("用户名或密码错误！");
        // 如果存在，生成token，并且将token置入缓存，方便下次存取
        String token = TokenUtils.encode(AccountAssembler.toDTO(account));

        return token;
    }
}
