package com.chomolungma.core;

import com.chomolungma.core.interceptors.AuthenticationInterceptor;
import com.chomolungma.core.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private AuthenticationInterceptor authenticationInterceptor;

    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).excludePathPatterns("/**/login");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**/login");
    }
}
