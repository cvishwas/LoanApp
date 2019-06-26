package com.loanapp.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.loanapp.beans.Loan;
import com.loanapp.dao.CustomerLoanDao;

@Controller
public class CustomerDashboardController {
	
	@Autowired
	CustomerLoanDao dao;
	
	
	@RequestMapping("/customerDashboard")
	public String customerDashboard(Model model, HttpServletRequest request) {
		String username = (String) request.getSession().getAttribute("username");

		// get the userId
		int userId = dao.getUserId(username);
		
		// get the customerId
		int customerId = dao.getCustomerId(userId);

		// get the customers loans
		List<Loan> loans = dao.getLoans(customerId);
		
		// get loan types, will use to parse the loan type (int) attribute in the JSP
		List<String> types = dao.getTypes();

		// get the customers first name
		String customerFirstName = dao.getCustomerFirstName(username);
		
		// get the customers last name
		String customerLastName = dao.getCustomerLastName(username);
		
		model.addAttribute("customerName", customerFirstName + " " + customerLastName);
		model.addAttribute("loans", loans);
		model.addAttribute("types", types);
		return "customerDashboard";
	}
}