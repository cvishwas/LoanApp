package com.loanapp.controller;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanapp.beans.LoanDataReviewer;

@Controller
public class ReviewerDashboardController {
	
	@RequestMapping("/reviewerDashboard")
	public String reviewerDashboard(HttpServletRequest req) {
		
		ArrayList<LoanDataReviewer> review = new ArrayList<>(Arrays.asList(
								new LoanDataReviewer(1, "Mortgage", "Fidel Mohabir" , 150000 , "Not Reviewed"),
								new LoanDataReviewer(2, "Mortgage", "Fidel Mohabir" , 100003 , "Not Reviewed"),
								new LoanDataReviewer(3, "Personal", "Random Name" , 100000 , "Reviewed"),
								new LoanDataReviewer(4, "Auto", " " , 10000 , "Not Reviewed")));
		
		req.setAttribute("loanlist", review);
		return "ReviewersView";
		
	}

}
