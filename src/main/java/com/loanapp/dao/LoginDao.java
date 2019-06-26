package com.loanapp.dao;

import com.loanapp.beans.LoginBean;

public interface LoginDao {
	public boolean authenticateUser(LoginBean loginBean);
	public String authorize(LoginBean bean);
}
