package com.chomolungma.app.auth.service;

import com.chomolungma.app.auth.pojo.Account;

public interface LoginService {

	String verify(Account account);
}
