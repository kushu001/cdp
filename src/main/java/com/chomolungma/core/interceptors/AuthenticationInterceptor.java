package com.chomolungma.core.interceptors;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.core.CurrentProfileHolder;
import com.chomolungma.system.account.infrastructure.TokenUtils;
import com.chomolungma.system.account.interfaces.dto.AccountDTO;
import com.chomolungma.system.log.application.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private OperateLogService operateLogService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null){
            throw new BusinessRuntimeException("令牌信息不存在！");
        }

        String[] tokenArray = bearerToken.split(" ");
        AccountDTO account = TokenUtils.decode(tokenArray[1]);
        CurrentProfileHolder.setContext(account);
        operateLogService.generateOperateLog();
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CurrentProfileHolder.remove();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }


}
