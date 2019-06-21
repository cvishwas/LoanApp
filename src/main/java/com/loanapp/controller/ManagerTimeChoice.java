package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerTimeChoice {
	
	@RequestMapping(value = "/timeChoice")
	public String managerReport(Map<String, Object> model) {
		return "managerReport";
	}
}
