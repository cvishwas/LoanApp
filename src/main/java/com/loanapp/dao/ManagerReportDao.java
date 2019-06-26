package com.loanapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.loanapp.beans.Loan;
import com.loanapp.dao.mapper.LoanMapper;


@Component
public class ManagerReportDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Loan> getLoans(String upperBound, String lowerBound) {
		List<Loan> loans = jdbcTemplate.query("SELECT loan_id, loan_type, loan_status, start_date FROM loan_app_loans "
				+ "WHERE start_date >= '" + lowerBound  + "' AND start_date <= '" 
				+ upperBound + "';", new LoanMapper());
		
		return loans;
	}
}
