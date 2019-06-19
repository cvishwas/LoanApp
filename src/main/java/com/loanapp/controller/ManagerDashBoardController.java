package com.loanapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.beans.LoanData;

@Controller
public class ManagerDashBoardController 
{
	@RequestMapping("/managerDash")
	public ModelAndView managerView()
	{
		List<LoanData> data = new ArrayList<>(Arrays.asList(
				new LoanData(1, "Mortage", "Pending", "Assigned", "Underwriter 1"),	
				new LoanData(1, "Auto", "Active", "Unassigned", ""),	
				new LoanData(1, "Personal", "Closed", "Assigned", "Underwriter 2"),	
				new LoanData(1, "Business", "Approved", "Assigned", "Underwriter 3"),	
				new LoanData(1, "Mortage", "Pending", "Unassigned", "")	
				));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manager-view");
		modelAndView.addObject("loanData", data);
		
		return modelAndView;
	}
}
