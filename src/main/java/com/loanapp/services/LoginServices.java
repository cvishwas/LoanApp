package com.loanapp.services;

import com.loanapp.beans.LoginBean;

public interface LoginServices {

	public boolean authenticateUser(LoginBean loginBean);
	public String authorize(LoginBean bean);
	
}
