package com.chomolungma.core;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MyFilter implements Filter {
    private  final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/writeExcelToDir")));
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            String requestURI = servletRequest.getRequestURI();
            //if (ALLOWED_PATHS.contains(requestURI)){
            if (requestURI.contains("/import")){
                chain.doFilter(servletRequest,response);
            }else {
                requestWrapper = new MultiReadHttpServletRequest(servletRequest);
                //获取请求中的流如何，将取出来的字符串，再次转换成流，然后把它放入到新request对象中。
                // 在chain.doFiler方法中传递新的request对象
                chain.doFilter(requestWrapper, response);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
