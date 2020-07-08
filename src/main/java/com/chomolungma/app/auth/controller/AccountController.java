package com.chomolungma.app.auth.controller;

import com.chomolungma.app.auth.form.AccountForm;
import com.chomolungma.app.auth.pojo.Account;
import com.chomolungma.app.auth.service.AccountService;
import com.chomolungma.common.AppException;
import com.chomolungma.common.BaseController;
import com.chomolungma.common.ResultResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
	
	@Autowired
	private AccountService accountService;


	/**
	 * 注册账户信息
	 * @param accountForm
	 * @return
	 */
	@PostMapping("/register")
	public ResultResponse register(@RequestBody AccountForm accountForm) {
		Account account = new Account();
		BeanUtils.copyProperties(accountForm, account);
		accountService.register(account);
		return success();
	}



	@PutMapping("/update/password")
	public ResultResponse modifyPassword(
										 @RequestParam String originPassword,
										 @RequestParam String userPassword,
										 @RequestParam String confirmPassword
										 ) throws AppException {
		accountService.modifyPassword(originPassword,userPassword,confirmPassword);
		return success();
	}


	/**
	 * 批量重置密码
	 * @param ids
	 * @return
	 */
	@PutMapping("/password/reset/{ids}")
	public ResultResponse resetPassword(@PathVariable String ids){
		accountService.resetPassword(ids.split(","));
		return success();
	}
	
}
