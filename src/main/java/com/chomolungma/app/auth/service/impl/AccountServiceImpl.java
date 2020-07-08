package com.chomolungma.app.auth.service.impl;

import com.chomolungma.app.auth.dao.AccountMapper;
import com.chomolungma.app.auth.pojo.Account;
import com.chomolungma.app.auth.service.AccountService;
import com.chomolungma.common.AppException;
import com.chomolungma.common.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	@Autowired
	private Environment env;

	@Override
	public void register(Account account) {
		account.setUserPassword(DigestUtils.md5DigestAsHex(account.getUserPassword().getBytes()));
		accountMapper.save(account);
	}

	@Override
	public void modifyPassword(String originPassword, String password, String confirmPassword) throws AppException {
		Account account = UserManager.getCurrentUser();
		Account originAccount = accountMapper.findById(account.getId());
		if (!originAccount.getUserPassword().equals(originPassword)){
			throw new AppException("原始密码不正确！");
		}

		if (!password.equals(confirmPassword)){
			throw new AppException("两次密码不一致！");
		}
		account.setUserPassword(password);
		accountMapper.update(account);

	}

	@Override
	public void resetPassword(String[] ids) {
		String resetPassword = env.getProperty("chomolungma.reset.password");
		accountMapper.resetPasswordById(ids, DigestUtils.md5DigestAsHex(resetPassword.getBytes()));
	}


}
