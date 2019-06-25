package com.loanapp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanapp.beans.DBProperties;
import com.loanapp.beans.Loan;

@Controller
public class CustomerDashboardController {
	
	@Autowired
	DBProperties props;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@RequestMapping("/customerDashboard")
	public String customerDashboard(Model model, HttpServletRequest request) {
		
		
		// this is how im expecting to recieve the customerId, subject to change
		//int customerId = (int) request.getSession().getAttribute("customerId");
		
			
		// get the customers loans
		List<Loan> loans =  jdbcTemplate.query("select * from LOAN_APP_LOANS where CUSTOMER_ID = "+1, new RowMapper<Loan>() {
			public Loan mapRow(ResultSet rs, int rowNum) throws SQLException{
				Loan loan = new Loan();
				loan.setLoanID(rs.getInt("LOAN_ID"));
				loan.setLoanType(rs.getInt("LOAN_TYPE"));
				loan.setCustomerID(rs.getInt("CUSTOMER_ID"));
				loan.setAmount(rs.getDouble("AMOUNT"));
				loan.setStartDate(rs.getString("START_DATE"));
				loan.setLoanDuration(rs.getInt("LOAN_DURATION"));
				loan.setInterestRate(rs.getDouble("INTEREST_RATE"));
				loan.setLoanStatus(rs.getString("LOAN_STATUS"));
			//	loan.setReviewStatus(rs.getString("EMAIL_STATUS"));
				loan.setDownPayment(rs.getDouble("DOWN_PAYMENT"));
				return loan;
				
			}
		});
		
		// get loan types, will use to parse the loan type (int) attribute in the JSP
		List<String> types = jdbcTemplate.query("select LOAN_TYPE from LOAN_APP_LOAN_TYPES order by LOAN_ID", new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				return rs.getString(1);
			}
		});
		
		// get the customers first name
		String customerFirstName = (String) jdbcTemplate.queryForObject(
		        "select FIRST_NAME from LOAN_APP_USERS where CUSTOMER_INFO = ?", new Object[] { 1 }, String.class);
		
		// get the customers last name
		String customerLastName = (String) jdbcTemplate.queryForObject(
				        "select LAST_NAME from LOAN_APP_USERS where CUSTOMER_INFO = ?", new Object[] { 1 }, String.class);
		
		model.addAttribute("customerName", customerFirstName + " " + customerLastName);
		model.addAttribute("loans", loans);
		model.addAttribute("types", types);
		return "customerDashboard";
	}
}