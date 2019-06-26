package com.loanapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.services.ManagerServices;

@RestController
public class ManagerController 
{
	@Autowired
	ManagerServices managerServices;
	
	@RequestMapping("/managerDash")
	public ModelAndView managerView(HttpServletRequest req)
	{
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("manager-view");
		modelAndView.addObject("loanData", managerServices.getLoans());
		modelAndView.addObject("dropDownList", managerServices.getRevAndUnderWiters());
		modelAndView.addObject("edit", req.getParameter("editId"));
	
		return modelAndView;
	}
}
