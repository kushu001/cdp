package com.chomolungma.auth.handler;

import com.alibaba.fastjson.JSON;
import com.chomolungma.core.result.Result;
import com.chomolungma.common.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        Result result = Result.fail("用户名密码不正确", HttpStatus.FORBIDDEN);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
