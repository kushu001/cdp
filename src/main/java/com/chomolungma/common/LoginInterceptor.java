package com.chomolungma.common;

import com.chomolungma.app.auth.pojo.User;
import com.chomolungma.common.utils.JWTUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");


        if (authorization == null) {
            throw new AppException("用户没权限！");
        } else {
            Map<String, String> user = JWTUtils.verifyToken(authorization.substring(7));
            User u = new User();
            BeanUtils.populate(u,user);
            request.setAttribute("user", u);
        }



        if(!(handler instanceof HandlerMethod)) {

        }


        MethodParameter[] methodParameters = ((HandlerMethod) handler).getMethodParameters();



        return super.preHandle(request, response, handler);
    }
}
