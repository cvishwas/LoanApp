package com.loanapp.dao;



import java.util.List;


import com.loanapp.beans.LoanData;
import com.loanapp.beans.User;


public interface ManagerDao 
{

	 
	public List<LoanData> getLoans();
	public User getUserById(int userId);
	public List<User> getRevAndUnderWiters();
	
}
