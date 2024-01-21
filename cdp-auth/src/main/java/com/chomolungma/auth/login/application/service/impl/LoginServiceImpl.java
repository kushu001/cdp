package com.chomolungma.auth.login.application.service.impl;


import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.core.UserDetail;
import com.chomolungma.core.exception.BusinessRuntimeException;
import com.chomolungma.auth.login.application.service.LoginService;
import com.chomolungma.common.utils.TokenUtils;
import com.chomolungma.system.account.domain.entity.Account;
import com.chomolungma.system.account.domain.repository.IAccountRepository;
import com.chomolungma.system.account.interfaces.controller.AccountController;
import com.chomolungma.system.staff.domain.entity.Staff;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;

    private final Cache<String, Object> caffeineCache;

    private final IAccountRepository iAccountRepository;

    public LoginServiceImpl(AuthenticationManager authenticationManager, Cache<String, Object> caffeineCache, IAccountRepository iAccountRepository) {
        this.authenticationManager = authenticationManager;
        this.caffeineCache = caffeineCache;
        this.iAccountRepository = iAccountRepository;
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

    @Override
    public void resetPassword(String oldPassword, String newPassword, String confirmPassword) {
        if (oldPassword.equals(newPassword)){
            throw new RuntimeException("新密码不能与旧密码相同");
        } else if (!newPassword.equals(confirmPassword)) {
            throw new RuntimeException("两次密码不一致");
        } else {
            // 查询旧密码是否正确
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String userName = CurrentProfileHolder.getProfile().getUsername();
            Account account = iAccountRepository.findAccount(userName);
            if (encoder.matches(oldPassword, account.getPassword())){
                account.setPassword(encoder.encode(newPassword));
                iAccountRepository.save(account);
            }else {
                throw new RuntimeException("旧密码不正确，请重新填写");
            }

        }
    }
}
