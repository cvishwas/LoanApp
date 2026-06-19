package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loanapp.beans.Loan;

/*
 * Currently only allows editing of the loan's details, not the user's details.
 * 
 * Pulled code from the LoanForm to keep things looking consistent.
 */

@Controller
public class LoanFormEditController {

	// The loan to be edited.  Provides data to fill the form with the existing values.
	// I'm not sure of the best way to set it yet.
	Loan loan;
	
    @RequestMapping(value="/loanFormEdit", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
    	model.addAttribute("loan", loan);
        return "loanFormEdit";
    }
	@RequestMapping(value="/loanFormEdit", method = RequestMethod.POST)
	public String loanForm(ModelMap model){
		return "loanFormEdit";
	}

}
