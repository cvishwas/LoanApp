<<<<<<< HEAD:src/main/java/com/loanapp/controller/ManagerController.java
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
=======
package com.loanapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.dao.ManagerRepo;

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
>>>>>>> cd6883a0d26c3c7e2f2d5f9b2a34a661a847ea59:src/main/java/com/loanapp/controller/ManagerDashBoardController.java
