package com.chomolungma.app.auth.pojo;

import com.chomolungma.common.BaseBo;

public class Account extends BaseBo{
    private String userName;
	
    private String userPassword;
    
    private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
