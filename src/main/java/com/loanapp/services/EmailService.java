package com.loanapp.services;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmailService {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6243784017654272480L;
	@Autowired
	JdbcTemplate jdbcTemplate;
	int loanID;
	String body;

	EmailService(int loanID, String approvalStatus) {
		this.loanID = loanID;
		this.body = approvalStatus;
	}
	public int updateEmail()
	{
		String query = "update loan_app_loans set email_status=1 where loan_id = " + this.getLoanID();
		return jdbcTemplate.update(query);
	}

	public int getLoanID() {
		return loanID;
	}

	public void setLoanID(int loanID) {
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