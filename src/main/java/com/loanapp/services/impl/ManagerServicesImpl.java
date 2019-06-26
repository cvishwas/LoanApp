package com.loanapp.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.beans.LoanData;
import com.loanapp.beans.User;
import com.loanapp.dao.ManagerDao;
import com.loanapp.services.ManagerServices;

@Service
public class ManagerServicesImpl implements ManagerServices{
	
	@Autowired
	ManagerDao managerDaoImpl; 

	@Override
	public List<LoanData> getLoans() {
		// TODO Auto-generated method stub
		return managerDaoImpl.getLoans();
	}

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return managerDaoImpl.getUserById(userId);
	}

	@Override
	public List<User> getRevAndUnderWiters() {
		// TODO Auto-generated method stub
		return managerDaoImpl.getRevAndUnderWiters();
	}

}
