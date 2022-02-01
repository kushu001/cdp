package com.chomolungma.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.chomolungma.account.entity.AccountEntity;
import com.chomolungma.account.mapper.AccountMapper;
import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.common.tools.TokenUtils;
import com.chomolungma.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public String login(String username, String password) {
        // 查询用户是否存在
        AccountEntity accountEntity = accountMapper.selectOne(new QueryWrapper<AccountEntity>().eq("username",username).eq("password",password));

        if(accountEntity == null)
            throw new BusinessRuntimeException("用户名或密码错误！");
        // 如果存在，生成token，并且将token置入缓存，方便下次存取
        String token = TokenUtils.encode(accountEntity);

        return token;
    }
}
