package com.loanapp.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.loanapp.beans.Loan;

public class LoanMapper implements RowMapper<Loan>{

	@Override
	public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Loan l = new Loan();
		l.setLoanID(rs.getInt("loan_id"));
		l.setLoanType(rs.getInt("loan_type"));
		l.setLoanStatus(rs.getString("loan_status"));
		l.setStartDate(rs.getString("start_date"));
		return l;
	}

}
