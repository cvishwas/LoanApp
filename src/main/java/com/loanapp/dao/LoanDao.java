package com.loanapp.dao;


import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import com.loanapp.beans.Loan;

public class LoanDao {

	private JdbcTemplate template;
	
	//Default constructor
	public LoanDao() {}
	
	public LoanDao(JdbcTemplate template) {
		this.template = template;
	}
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//Goes through the result query obtained from the SQL query
	//Puts each row into a loan object in a list
	public List<Loan> queryLoans(String sqlStatement){
		
		return template.query(sqlStatement, new LoanMapper());
	}
}
