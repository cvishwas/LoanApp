package com.loanapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.loanapp.beans.DBProperties;
import com.loanapp.beans.Loan;

@Repository
public class CustomerLoanDao {
	
	@Autowired
	DBProperties properties;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int getUserId(String username) {
		return  (Integer) jdbcTemplate.queryForObject(
				"select USER_ID from LOAN_APP_USERS where USER_LOGIN = '" + username + "'", Integer.class);
	}
	
	public int getCustomerId(int userId) {
		return  (Integer) jdbcTemplate.queryForObject(
				"select CUSTOMER_ID from LOAN_APP_CUSTOMER_INFO where USER_ID = "+userId, Integer.class);
	}
	
	public List<Loan> getLoans(int customerId){
		return jdbcTemplate.query("select * from LOAN_APP_LOANS where CUSTOMER_ID = " + customerId,
				new RowMapper<Loan>() {
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
				// loan.setReviewStatus(rs.getString("EMAIL_STATUS"));
				loan.setDownPayment(rs.getDouble("DOWN_PAYMENT"));
				return loan;
			}
		});
	}
	
	public String getCustomerFirstName(String username) {
		return  (String) jdbcTemplate.queryForObject(
				"select FIRST_NAME from LOAN_APP_USERS where USER_LOGIN = '"+username+"'", String.class);
	}
	
	public String getCustomerLastName(String username) {
		return (String) jdbcTemplate.queryForObject(
				"select LAST_NAME from LOAN_APP_USERS where USER_LOGIN = '"+username+"'", String.class);
	}
	
	public List<String> getTypes(){
		return jdbcTemplate.query("select LOAN_TYPE from LOAN_APP_LOAN_TYPES order by LOAN_ID",
				new RowMapper<String>() {
			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getString(1);
			}
		});

	}
}
