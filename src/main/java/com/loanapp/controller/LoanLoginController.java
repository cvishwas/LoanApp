package com.loanapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.loanapp.beans.LoginBean;
import com.loanapp.services.LoginServices;

@Controller
@SessionAttributes({"username","role"})
@RequestMapping("/Loans")
public class LoanLoginController {
	
@Autowired
LoginServices loginServciesImpl;
	
  @RequestMapping(value = "/")
  public ModelAndView LoanLogin(Map<String, LoginBean> model) {
	  LoginBean lb = new LoginBean();
	  return new ModelAndView("LoanLogin", "command", new LoginBean());
  }
  public void init(Model model) {
    model.addAttribute("msg", "Login");
  }

  @RequestMapping(value= "/login" , method = RequestMethod.POST)
  public void submit(Model model, @ModelAttribute("loginBean") LoginBean bean, HttpServletRequest request, 
	        HttpServletResponse response) {
	  try {
			
			String username = request.getParameter("username");   
			String password = request.getParameter("password");
			bean = new LoginBean(username,password);
			
			boolean status = loginServciesImpl.authenticateUser(bean);
			//System.out.println(status);
			if (!status){
			       System.out.println("Invaild Username or Password"); 
			       response.sendRedirect("/");
			}
			else {
        //Everything after this point Jassandip Wrote. 
        //I couldnt test it out because I couldnt get the springapp to run when I last pulled.  
        String role = loginServciesImpl.authorize(bean);
        String redirect = "/LoanLogin";
        switch(role) {
          case "Manager":
          redirect = "/managerDash";
          break;
          case "Customer":
          redirect = "/customerDashboard";
          break;
          case "Underwriter":
          redirect = "/underwriterDashboard";
          break;
          case "ReviewersView":
          redirect = "/ReviewersView";
          break;
        }
        response.sendRedirect(redirect);		
          //send redirect
      }
		}
	   catch(Exception e){       
         System.out.println("Something went wrong");    
	   } 
	}	
}
