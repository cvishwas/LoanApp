package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoanFormController {

	@RequestMapping(value = "/loanForm", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		return "loanForm";
	}

	@RequestMapping(value = "/loanForm", method = RequestMethod.POST)
	public String loanForm(ModelMap model, @RequestParam String firstname, @RequestParam String lastname,
			@RequestParam String DoB, @RequestParam String city, @RequestParam String state, @RequestParam String zip,
			@RequestParam String country, @RequestParam String ssn, @RequestParam String phoneNum,
			@RequestParam String salary, @RequestParam String creditScore, @RequestParam String maritalStatus) {
		return "loanForm";
	}

}
