package com.loanapp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.loanapp.Authenticate;
import com.loanapp.LoginBean;

@Controller
public class LoanLoginController {
  @RequestMapping(value = "/login")
  public String LoanLogin(Map<String, Object> model) {
  return "LoanLogin";
  }
  public void init(Model model) {
    model.addAttribute("msg", "Login");
  }

  @RequestMapping(method = RequestMethod.POST)
  public void submit(Model model, @ModelAttribute("loginBean") LoginBean bean) {
	  Authenticate.validate(bean);
    }
  }
