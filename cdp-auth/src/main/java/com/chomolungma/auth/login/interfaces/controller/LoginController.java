package com.chomolungma.auth.login.interfaces.controller;


import com.chomolungma.auth.login.param.LoginForm;
import com.chomolungma.auth.login.application.service.LoginService;
import com.chomolungma.auth.login.param.ResetPasswordDTO;
import com.chomolungma.core.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class LoginController {
    private final LoginService loginService;

    private final HttpServletResponse response;

    public LoginController(LoginService loginService, HttpServletResponse response) {
        this.loginService = loginService;
        this.response = response;
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm){
        String token = loginService.login(loginForm.getUsername(),loginForm.getPassword());
        response.addHeader("Authorization","Bearer " + token);
        return Result.success();
    }

    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO){
        loginService.resetPassword(resetPasswordDTO.getOldPassword(), resetPasswordDTO.getNewPassword(), resetPasswordDTO.getConfirmPassword());
        return Result.success();
    }


    @PostMapping("/logout")
    public Result logout(){
        response.addHeader("Authorization",null);
        return Result.success();
    }
}
