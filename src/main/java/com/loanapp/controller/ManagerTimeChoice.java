package com.loanapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loanapp.beans.DBProperties;
import com.loanapp.beans.Loan;

@Controller
public class ManagerTimeChoice {
	
	@RequestMapping(value = "/timeChoice")
	public String managerReport(Map<String, Object> model) {
		return "managerReport";
	}

	
	@RequestMapping(value = "/getLoans", method = RequestMethod.POST)
	public String obtainLoans(@RequestParam("time") String t, ModelMap model) {
		final String DB_DRIVER = DBProperties.getDriverclassname();
		final String DB_URL = DBProperties.getUrl();
		final String DB_USER = DBProperties.getUsername();
		final String DB_PASS = DBProperties.getPassword();
		
		ArrayList<Loan> loans = new ArrayList<Loan>();
		int timeC = Integer.parseInt(t);
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime minusDate = currentDate.minusDays(timeC);
		DateTimeFormatter ymd =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String upperBound = currentDate.format(ymd);
		String lowerBound = minusDate.format(ymd);
		
		String selectQuery = "SELECT loan_id, loan_type, loan_status, start_date FROM loan_app_loans "
				+ "WHERE start_date >= '" + lowerBound  + "' AND start_date <= '" 
				+ upperBound + "';";
		
		try {
			// Change the database stuff depending on what database you use.
//			Class.forName("org.postgresql.Driver");
//			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loan", "postgres", "xdkb07cqn72");
			Class.forName(DB_DRIVER); 				
			Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);	
			
			Statement s = con.createStatement();
			ResultSet result = s.executeQuery(selectQuery);
			
			while (result.next()) {
				loans.add(new Loan(result.getInt("loan_id"), result.getInt("loan_type"), result.getString("loan_status"), result.getString("start_date")));
			}
			
			model.put("loanData", loans);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "managerReportView";
	}
}
