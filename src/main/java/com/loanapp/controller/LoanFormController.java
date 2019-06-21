package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoanFormController {

    @RequestMapping(value="/loanForm", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "loanForm";
    }
	@RequestMapping(value="/loanForm", method = RequestMethod.POST)
	public String loanForm(ModelMap model) {
		return "loanForm";
	}

}
