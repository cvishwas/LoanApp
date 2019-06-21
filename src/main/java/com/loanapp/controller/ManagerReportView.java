package com.loanapp.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanapp.temp.sampleLoan;

@Controller
public class ManagerReportView {
	
	@RequestMapping(value = "/managerReport")
	public String managerReporting(HttpServletRequest request) {
		// connect to database to get all the loans in time period. Not yet implemented.
		
		// Dummy data using Ryan's loan class.
		ArrayList<sampleLoan> loanList = new ArrayList<sampleLoan>(Arrays.asList(
				new sampleLoan(1, "Pending"),
				new sampleLoan(2, "Pending"),
				new sampleLoan(3, "Pending"),
				new sampleLoan(4, "Active")
			));
		
		request.setAttribute("loanList", loanList);
		return "managerReportView";
	}
}