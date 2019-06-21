package com.loanapp.services;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import com.loanapp.dao.MySqlProperties;

public class EmailService extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6243784017654272480L;
	@Autowired
	MySqlProperties database;
	@Autowired
	JdbcTemplate jdbcTemplate;
	String loanID;
	String body;

	EmailService(String loanID, String approvalStatus) {
		this.loanID = loanID;
		this.body = approvalStatus;
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp){
	    try {
			resp.sendRedirect(req.getContextPath() + "/redirected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int updateEmail()
	{
		String query = "update loan_app_loans set email_status=1 where loan_id = " + this.getLoanID();
		return jdbcTemplate.update(query);
	}

	public String getLoanID() {
		return loanID;
	}

	public void setLoanID(String loanID) {
		this.loanID = loanID;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	public static void main(String args[]) {

		
	}
}