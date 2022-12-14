package com.chomolungma.auth.handler;

import com.alibaba.fastjson.JSON;
import com.chomolungma.common.utils.WebUtils;
import com.chomolungma.core.result.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        Result result = Result.fail("此接口没有权限",  HttpStatus.METHOD_NOT_ALLOWED);
        String json = JSON.toJSONString(result);
        WebUtils.renderString(response, json);
    }
}
