package com.loanapp.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.beans.LoginBean;
import com.loanapp.dao.LoginDao;
import com.loanapp.services.LoginServices;

@Service
public class LoginServicesImpl implements LoginServices {
	
	@Autowired
	LoginDao loginDaoImpl;

	@Override
	public boolean authenticateUser(LoginBean loginBean) {
		// TODO Auto-generated method stub
		return loginDaoImpl.authenticateUser(loginBean);
	}

	@Override
	public String authorize(LoginBean bean) {
		// TODO Auto-generated method stub
		return loginDaoImpl.authorize(bean);
	}

}
