package com.loanapp.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanapp.temp.sampleLoan;

@Controller
public class CustomerDashboardController {
	
	@RequestMapping("/customerDashboard")
	public String customerDashboard(HttpServletRequest request) {
		// User user = request.getSession().getAttribute("user");
		// Database logic here to build an arrayList of loans
		
		// for now use static data
		ArrayList<sampleLoan> loanList = new ArrayList<sampleLoan>(Arrays.asList(
				new sampleLoan("4/16/19", "Pending","Personal", "7/1/19/ - 1/1/20","$20,000"),
				new sampleLoan("7/30/20", "Pending","Auto", "12/1/20/ - 12/1/21","$70,000"),
				new sampleLoan("3/2/21", "Pending","Mortgage", "6/15/21/ - 12/31/51","$150,000"),
				new sampleLoan("6/12/22", "Active","Business", "9/12/22/ - 6/30/23","$1,000,000")
			));
		
		request.setAttribute("customerName", "Ryan Roskowski");
		request.setAttribute("loanList", loanList);
		return "customerDashboard";
	}
}

