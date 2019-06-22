package com.loanapp.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.jdbc.core.JdbcTemplate;

import com.loanapp.beans.Loan;
import com.loanapp.beans.LoanDataReviewer;

@Controller
public class ReviewerDashboardController {
	
	@RequestMapping("/reviewerDashboard")
	public String reviewerDashboard(Model model, HttpServletRequest req) {
		
	
		
		return "ReviewersView";
		
	}

}
