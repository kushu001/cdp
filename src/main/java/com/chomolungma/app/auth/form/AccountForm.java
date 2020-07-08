package com.chomolungma.app.auth.form;

import javax.validation.constraints.NotBlank;

public class AccountForm {
	
	@NotBlank(message="用户名不能为空")
	private String userName;
	
	@NotBlank(message="密码不能为空")
	private String userPassword;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
