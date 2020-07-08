package com.chomolungma.app.auth.controller;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chomolungma.app.auth.pojo.User;
import com.chomolungma.common.BaseController;
import com.chomolungma.common.ResultResponse;

@RestController
public class UserController extends BaseController{

	//注册用户
	public ResultResponse register(@RequestBody User user) {
		
		
		
		
		return success();
	}
	
}
