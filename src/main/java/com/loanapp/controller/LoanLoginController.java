package com.loanapp.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.loanapp.Authenticate;
import com.loanapp.Authorize;
import com.loanapp.LoginBean;

@Controller
@SessionAttributes({"username","role"})
public class LoanLoginController {
  @RequestMapping(value = "/")
  public String LoanLogin(Map<String, Object> model) {
  return "LoanLogin";
  }
  public void init(Model model) {
    model.addAttribute("msg", "Login");
  }

  @RequestMapping(method = RequestMethod.POST)
  public void submit(Model model, @ModelAttribute("loginBean") LoginBean bean, HttpServletRequest request, 
	        HttpServletResponse response) {
	  try {
			
			String username = request.getParameter("username");   
			String password = request.getParameter("password");
			bean = new LoginBean(username,password);
			boolean status = Authenticate.validate(bean);
			//System.out.println(status);
			if (!status){
			       System.out.println("Invaild Username or Password"); 
			       response.sendRedirect("/");
			}
			else {
        //Everything after this point Jassandip Wrote. 
        //I couldnt test it out because I couldnt get the springapp to run when I last pulled.  
        String role = Authorize.authorize(bean);
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
          case "Reviewer":
          redirect = "/reviewerDashboard";
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
