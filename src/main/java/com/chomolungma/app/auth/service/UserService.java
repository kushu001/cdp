package com.chomolungma.app.auth.service;

import com.chomolungma.app.auth.pojo.User;

public interface UserService {

	void register(User user);
	
	void modifyPassword(int id, String password);
	
	void updateUser(User user);
	
	
}
