package com.loanapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.loanapp.services.TimeChoiceServices;
//Controllers
@Controller
public class ManagerTimeChoice {
	
	@Autowired
	TimeChoiceServices TCS;
	
	@RequestMapping(value = "/timeChoice")
	public String managerReport(Map<String, Object> model) {
		return "managerReport";
	}
	
	@RequestMapping(value = "/getLoans", method = RequestMethod.POST)
	public String obtainLoans(@RequestParam("time") String t, ModelMap model) {
		model.put("loanData", TCS.getLoans(t));
		return "managerReportView";
	}
}