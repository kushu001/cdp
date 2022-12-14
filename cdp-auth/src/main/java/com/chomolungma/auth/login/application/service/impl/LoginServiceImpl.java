package com.chomolungma.auth.login.application.service.impl;


import com.chomolungma.core.UserDetail;
import com.chomolungma.core.exception.BusinessRuntimeException;
import com.chomolungma.auth.login.application.service.LoginService;
import com.chomolungma.common.utils.TokenUtils;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;

    private final Cache<String, Object> caffeineCache;

    public LoginServiceImpl(AuthenticationManager authenticationManager, Cache<String, Object> caffeineCache) {
        this.authenticationManager = authenticationManager;
        this.caffeineCache = caffeineCache;
    }

    @Override
    public String login(String username, String password) {
        // 查询用户是否存在
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)){
            throw new BusinessRuntimeException("用户名或密码错误");
        }

        UserDetail userDetail = (UserDetail)authenticate.getPrincipal();

        // 如果存在，生成token，并且将token置入缓存，方便下次存取
        String token = TokenUtils.encode(userDetail.getAccountId());

        caffeineCache.put("accountId_"+ userDetail.getAccountId(), userDetail);

        return token;
    }
}
