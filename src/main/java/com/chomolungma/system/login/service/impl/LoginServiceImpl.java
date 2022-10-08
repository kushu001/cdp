package com.chomolungma.system.login.service.impl;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.system.account.domain.assembler.AccountAssembler;
import com.chomolungma.system.account.infrastructure.TokenUtils;
import com.chomolungma.system.login.domain.UserDetail;
import com.chomolungma.system.login.service.LoginService;
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
        String token = TokenUtils.encode(AccountAssembler.toDTO(userDetail.getAccount()));

        caffeineCache.put("userId"+ userDetail.getAccount().getId(), userDetail);

        return token;
    }
}
