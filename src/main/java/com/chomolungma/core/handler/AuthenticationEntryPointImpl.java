package com.chomolungma.core.handler;

import com.alibaba.fastjson.JSON;
import com.chomolungma.common.result.Result;
import com.chomolungma.common.tools.WebUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) {
        Result result = Result.fail("认证失败", null);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
