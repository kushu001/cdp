package com.chomolungma.app.auth.service.impl;


import com.chomolungma.app.auth.dao.AccountMapper;
import com.chomolungma.app.auth.pojo.Account;
import com.chomolungma.app.auth.service.LoginService;
import com.chomolungma.common.utils.JWTUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@Service
public class LoginServiceImpl implements LoginService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public String verify(Account account) {
        account.setUserPassword(DigestUtils.md5DigestAsHex(account.getUserPassword().getBytes()));
        Map<String, String> user = accountMapper.findByUsernameAndPassword(account);
        return JWTUtils.createToken(user);
    }
}
