package com.chomolungma.common;

import javax.servlet.http.HttpServletRequest;

import com.chomolungma.app.auth.pojo.Account;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserManager {

	public static Account getCurrentUser() {
		UserManager userManager = new UserManager();
		HttpServletRequest request = userManager.getRequest();
		Account account = (Account)request.getAttribute("account");
		return account;
	}
	
	
	public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
}
