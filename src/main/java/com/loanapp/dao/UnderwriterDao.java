package com.loanapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.loanapp.beans.UnderWriterDBHelper;
import com.loanapp.beans.LoanDataUnderwriter;

@Repository
public class UnderwriterDao {

	
	@Autowired
	UnderWriterDBHelper database;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*
	 * @param noparam
	 * getUnderWriter data pulls all the underwriter information with the review status 'Reviewed'
	 * @returns List of underwriter object.
	 */
	public List<LoanDataUnderwriter> getUnderWriterData()
	{
		// Use this query to pull customer information also if required.
		//String queryString = "select a.loan_id,a.loan_type,a.customer_id,a.review_status,c.FIRST_NAME,c.LAST_NAME from loan_app_loans a, loan_app_loan_types b, loan_app_users c where "+"a.loan_id=b.LOAN_ID and a.CUSTOMER_ID = c.USER_ID and a.review_status='reviewed";
		
		// Querying loan app table for under writer information.
		String queryString = "select a.loan_id,a.loan_type,a.customer_id,a.loan_status from loan_app_loans a, loan_app_loan_types b where "+"a.loan_id=b.LOAN_ID and a.loan_status='reviewed'";
				
					 
		return jdbcTemplate.query(queryString, new RowMapper<LoanDataUnderwriter>() {
			@Override  
		    public LoanDataUnderwriter mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        LoanDataUnderwriter undList = new LoanDataUnderwriter(rs.getInt("loan_id"), rs.getInt("loan_type"), rs.getInt("customer_id"),
		        		 rs.getString("loan_status"));  
		        
		        System.out.println(" Generated Data From Table :"+undList);
		        return undList;  
		    }  
		});
	}

	
}
