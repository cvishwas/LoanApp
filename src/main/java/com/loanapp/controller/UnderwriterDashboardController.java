package com.loanapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.beans.LoanDataUnderwriter;

@Controller
public class UnderwriterDashboardController 
{
	@RequestMapping("/underwriterDash")
	public ModelAndView underWriterView()
	{
		List<LoanDataUnderwriter> undList= new ArrayList<>(Arrays.asList(
				new LoanDataUnderwriter(1, "Sara","Mortage", "Pending", "Assigned" ),	
				new LoanDataUnderwriter(2, "Jane","Personal", "Approved", "Assigned" ),	
				new LoanDataUnderwriter(5,"Tom", "Business", "Active", "Assigned")	
				));

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("underwriterDashboard");
		modelAndView.addObject("undList", undList);

		return modelAndView;
	}
}
	

