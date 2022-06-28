package com.chomolungma.core.interceptors;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.common.tools.TokenUtils;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.entity.AccountEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null){
            throw new BusinessRuntimeException("令牌信息不存在！");
        }

        String[] tokenArray = bearerToken.split(" ");
        AccountEntity accountEntity = TokenUtils.decode(tokenArray[1]);
        CurrentProfileHolder.setContext(accountEntity);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentProfileHolder.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
