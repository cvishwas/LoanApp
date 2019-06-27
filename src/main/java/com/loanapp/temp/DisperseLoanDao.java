package com.loanapp.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Repository
public class DisperseLoanDao 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void updateStatus(int loadId)
	{
		String sql = "update loan_app_loans set loan_status = 'Completed' where loan_id = ?";
		jdbcTemplate.update(sql, new Object[] {loadId});
	}
}
