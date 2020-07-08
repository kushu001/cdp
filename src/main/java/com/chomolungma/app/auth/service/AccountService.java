package com.chomolungma.app.auth.service;

import com.chomolungma.app.auth.pojo.Account;
import com.chomolungma.common.AppException;

public interface AccountService {
	void register(Account account);

	void modifyPassword(String originPassword,String password, String confirmPassword) throws AppException;

	void resetPassword(String[] ids);
}
