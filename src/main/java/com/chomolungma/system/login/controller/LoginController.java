package com.chomolungma.system.login.controller;

import com.chomolungma.common.result.Result;
import com.chomolungma.system.log.application.service.LoginLogService;
import com.chomolungma.system.login.param.LoginForm;
import com.chomolungma.system.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm){
        String token = loginService.login(loginForm.getUsername(),loginForm.getPassword());
        response.addHeader("Authorization","Bearer " + token);
        return Result.success();
    }
}
