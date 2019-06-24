package com.loanapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";
	@RequestMapping("/sample")
	public String sample(Map<String, Object> model) {
		model.put("message", this.message);
		return "sample";
	}
	@RequestMapping("/viewapp")
	public String view(Map<String, Object> model) {
		model.put("message", this.message);
		return "sample";
	}
	

}
