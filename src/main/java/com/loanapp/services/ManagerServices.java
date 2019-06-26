package com.loanapp.services;

import java.util.List;

import com.loanapp.beans.LoanData;
import com.loanapp.beans.User;

public interface ManagerServices {
	public List<LoanData> getLoans();
	public User getUserById(int userId);
	public List<User> getRevAndUnderWiters();	

}
