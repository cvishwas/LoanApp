package com.loanapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.loanapp.beans.LoginBean;
import com.loanapp.dao.LoginDao;

@Service
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	@Override
	public boolean authenticateUser(LoginBean loginBean) {
		try {
		int result = jdbcTemplate.queryForObject(
			    "SELECT COUNT(*) FROM loan_app_users where user_login ='"+loginBean.getUsername()+"' and user_pass = '"+loginBean.getPassword()+"'", Integer.class);
		if(result > 0)
			return true;
		else
			return false;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public String authorize(LoginBean bean) {
		String result = "";
		try {
		result = jdbcTemplate.queryForObject(
			    "select user_role from loan_app_users where user_login='"+bean.getUsername()+"'", String.class);

		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}
	

}
