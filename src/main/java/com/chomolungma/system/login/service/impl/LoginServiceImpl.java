package com.chomolungma.system.login.service.impl;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.common.tools.TokenUtils;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.account.repository.IAccountRepository;
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
        AccountEntity accountEntity = iAccountRepository.queryAccountUser(username,password);

        if(accountEntity == null)
            throw new BusinessRuntimeException("用户名或密码错误！");
        // 如果存在，生成token，并且将token置入缓存，方便下次存取
        String token = TokenUtils.encode(accountEntity);

        return token;
    }
}
