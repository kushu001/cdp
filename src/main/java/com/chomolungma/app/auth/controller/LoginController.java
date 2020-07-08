package com.chomolungma.app.auth.controller;

import com.chomolungma.app.auth.form.AccountForm;
import com.chomolungma.app.auth.pojo.Account;
import com.chomolungma.app.auth.service.LoginService;
import com.chomolungma.common.AppException;
import com.chomolungma.common.BaseController;
import com.chomolungma.common.ResultResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class LoginController extends BaseController {


    @Autowired
    private LoginService loginService;


    /**
     * 登录
     * @param accountForm
     * @param response
     * @return
     * @throws AppException
     */
    @RequestMapping("/login")
    public ResultResponse login(@Valid @RequestBody AccountForm accountForm, HttpServletResponse response) throws AppException {

        Account account = new Account();

        BeanUtils.copyProperties(accountForm,account);

        String token = loginService.verify(account);

        response.setHeader("Authorization","Bearer " + token);

        return success();
    }


    /**
     * 登出
     * @param response
     * @return
     */
    @RequestMapping("/logout")
    public ResultResponse logout(HttpServletResponse response){
        response.setHeader("Authorization",null);
        return success();
    }
}
