package com.chomolungma.login.controller;

import com.chomolungma.common.exception.BusinessRuntimeException;
import com.chomolungma.common.result.Result;
import com.chomolungma.login.param.LoginForm;
import com.chomolungma.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletResponse response;

    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm){
        String token = loginService.login(loginForm.getUsername(),loginForm.getPassword());
        response.addHeader("Authorization","Bearer " + token);
        return Result.success();
    }
}
