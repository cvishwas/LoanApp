package com.loanapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.Dao.ManagerRepo;

@RestController
public class ManagerDashBoardController 
{
	@Autowired
	ManagerRepo managerRep;
	
	@RequestMapping("/managerDash")
	public ModelAndView managerView(HttpServletRequest req)
	{
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("manager-view");
		modelAndView.addObject("loanData", managerRep.getLoans());
		modelAndView.addObject("dropDownList", managerRep.getRevAndUnderWiters());
		modelAndView.addObject("edit", req.getParameter("editId"));
	
		return modelAndView;
	}

	
}
