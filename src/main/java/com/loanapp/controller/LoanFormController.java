package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoanFormController {

	@RequestMapping(value = "/loanFormPersonalDetails", method = RequestMethod.GET)
	public String showCustomerDetails(ModelMap model) {
		return "loanFormPersonalDetails";
	}

	@RequestMapping(value = "/loanFormPersonalDetails", method = RequestMethod.POST)
	public String loanFormPersonalDetails(ModelMap model, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String DoB, @RequestParam String city, @RequestParam String state, @RequestParam String zip,
			@RequestParam String country, @RequestParam String ssn, @RequestParam String phoneNum,
			@RequestParam String salary, @RequestParam String maritalStatus) {

		int userSSN = Integer.parseInt(ssn);

		return "loanFormLoanDetails";
	}

	@RequestMapping(value = "/loanFormLoanDetails", method = RequestMethod.GET)
	public String showLoanDetails(ModelMap model) {
		return "loanFormLoanDetails";
	}

	@RequestMapping(value = "/loanFormLoanDetails", method = RequestMethod.POST)
	public String loanFormLoanDetails(ModelMap model, @RequestParam String loanAmount, @RequestParam String downPayment,
			@RequestParam String cosigner, @RequestParam String reasonOfLoan) {

		return "loanFormLoanDetails";
	}

}
