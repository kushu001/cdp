package com.chomolungma.core.interceptors;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.common.tools.TokenUtils;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.entity.AccountEntity;
import com.chomolungma.system.log.application.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor  implements HandlerInterceptor {
    @Autowired
    private LoginLogService loginLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String bearerToken = response.getHeader("Authorization");
        if (bearerToken == null){
            throw new BusinessRuntimeException("令牌信息不存在！");
        }

        String[] tokenArray = bearerToken.split(" ");
        AccountEntity accountEntity = TokenUtils.decode(tokenArray[1]);
        CurrentProfileHolder.setContext(accountEntity);
        loginLogService.generateLoginLog();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
