package com.loanapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.loanapp.beans.LoanData;
import com.loanapp.beans.User;

/**
 * Manager Repository class allow to retrieve loans
 * data from database.
 * 
 * @author Gursimran Singh
 */

@Repository
public class ManagerRepo 
{
	@Autowired
	MySqlProperties database;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * This is a method for getting all the loans details.
	 * 
	 * @return list of loans data
	 */
	public List<LoanData> getLoans()
	{
		String sqlQuery = "select loan_app_loans.loan_id, loan_app_loan_types.loan_type, loan_status, review_status, customer_id \n" + 
				"from loan_app_loan_types\n" + 
				"inner join loan_app_loans\n" + 
				"on loan_app_loan_types.loan_id = loan_app_loans.loan_type;";
		
		return jdbcTemplate.query(sqlQuery, new RowMapper<LoanData>() {
			@Override  
		    public LoanData mapRow(ResultSet rs, int rownumber) throws SQLException {  
		        LoanData data = new LoanData(rs.getInt("loan_id"), rs.getString("loan_type"), 
		        		rs.getString("loan_status"), rs.getString("review_status"));  
		        
		        data.setAssignedTo(getUserById(rs.getInt("customer_id")));
		        
		        return data;  
		    }  
		});
	}
	
	/**
	 * This method return user object based provided user id
	 * 
	 * @param userId
	 * @return User object
	 */
	public User getUserById(int userId)
	{	
		return jdbcTemplate.queryForObject("select user_id, first_name, last_name from loan_app_users "
				+ "where user_id = ?", new Object[] {userId}, new UserRowMapper());
	}
	
	/**
	 * This is a method for getting all the reviewers and underwriters.
	 * 
	 * @return list of reviewers and underwriters
	 */
	public List<User> getRevAndUnderWiters()
	{
		return jdbcTemplate.query("select user_id, first_name, last_name from loan_app_users "
				+ "where user_role = ? OR user_role = ?", new Object[] {"Reviewer", "Underwriter"}, new UserRowMapper());
	}
	
	//Inner User row mapping class
	private class UserRowMapper implements RowMapper<User>
	{
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException 
		{
			User user = new User();
			user.setUserID(rs.getInt("user_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setLastName(rs.getString("last_name"));
			return user;
		}
	}
}
