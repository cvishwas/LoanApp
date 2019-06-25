package com.loanapp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.loanapp.beans.DBProperties;
import com.loanapp.beans.Loan;
import com.loanapp.beans.LoanDataReviewer;

@Controller
public class ReviewerDashboardController {
	
	@Autowired
	DBProperties props;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/reviewerDashboard")
	public String reviewerDashboard(Model model, HttpServletRequest req) {
		
		List<Loan> loans = jdbcTemplate.query("select * from LOAN_APP_LOANS where LOAN_STATUS = 'pending'", new RowMapper<Loan>() {
			public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
				Loan loan = new Loan();
				loan.setLoanID(rs.getInt("LOAN_ID"));
				loan.setLoanType(rs.getInt("LOAN_TYPE"));
				loan.setCustomerID(rs.getInt("CUSTOMER_ID"));
				loan.setAmount(rs.getDouble("AMOUNT"));
				loan.setStartDate(rs.getString("START_DATE"));
				loan.setLoanDuration(rs.getInt("LOAN_DURATION"));
				loan.setInterestRate(rs.getDouble("INTEREST_RATE"));
				loan.setLoanStatus(rs.getString("LOAN_STATUS"));
				loan.setReviewStatus(rs.getString("EMAIL_STATUS"));
				loan.setDownPayment(rs.getDouble("DOWN_PAYMENT"));
				
				
				return loan;
			}
		
		});
		
//		for(Loan i: loans) {
//			jdbcTemplate.execute("update LOAN_APP_LOANS set LOAN_STATUS = 'in review' where LOAN_ID = " + i.getLoanID() + ";");
//		}
//		
		List<String> types = jdbcTemplate.query("select LOAN_TYPE from LOAN_APP_LOAN_TYPES order by LOAN_ID", new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException{
				return rs.getString(1);
			}
		});
		
		ArrayList<String> name = new ArrayList<String>();
		
		for(int i =0; i < loans.size(); i++) {
			String fName = (String) jdbcTemplate.queryForObject("select FIRST_NAME from LOAN_APP_USERS where USER_ID= ?", new Object[] { loans.get(i).getCustomerID()}, String.class);
			String lName = (String) jdbcTemplate.queryForObject("select FIRST_NAME from LOAN_APP_USERS where USER_ID= ?", new Object[] { loans.get(i).getCustomerID()}, String.class);
			name.add(fName + " " + lName);
		}
		
		
		
		model.addAttribute("customerName", name);
		model.addAttribute("loans", loans);
		model.addAttribute("types", types);
		return "ReviewersView";
		
	}
	
	@RequestMapping(value="completed", method = RequestMethod.POST) 
	public String update(@ModelAttribute("loanid") int i) {
			jdbcTemplate.update("update LOAN_APP_LOANS set LOAN_STATUS = 'reviewed' where LOAN_ID =" + i);
		return "ReviewersView";
		
	}
	
	@RequestMapping(value="need more information", method = RequestMethod.POST)
	public String update2(@ModelAttribute("loanid") int s) {
		jdbcTemplate.update("update LOAN_APP_LOANS set LOAN_STATUS = 'need more information' where LOAN_ID =" + s);
		return "ReviewersView";
	}

}
