package com.loanapp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.beans.LoanDataUnderwriter;
import com.loanapp.dao.UnderwriterDao;

@RestController
public class UnderwriterDashboardController 
{
	@Autowired
	UnderwriterDao underwriterDao;

	@RequestMapping("/underwriterDash")
	public ModelAndView underWriterView()
	{
		List<LoanDataUnderwriter> undList =underwriterDao.getUnderWriterData();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("underwriterDashboard");
		modelAndView.addObject("undList", undList);

		return modelAndView;
	}
}
	

