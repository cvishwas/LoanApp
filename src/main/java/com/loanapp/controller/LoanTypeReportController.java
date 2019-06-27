package com.loanapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loanapp.beans.DBProperties;
import com.loanapp.beans.Loan;
import com.loanapp.dao.LoanDao;

@Controller
public class LoanTypeReportController extends HttpServlet {
	
	@Autowired
	DBProperties properties; //Creates DBProperties object and initializes its properties from the properties file
	JdbcTemplate template;
	
	@RequestMapping(value = "/loanReport")
	
	//Displays LoanTypeReport.jsp
	public String LoanReportPage(Map<String, Object> model) {
		  return "LoanTypeReport";
	}
	
	@RequestMapping(value = "/showReport")
	//Makes the loan report
	public void makeReport(HttpServletRequest req, HttpServletResponse response) {
		
		//Gets the loan type, start date and end date from LoanTypeReport.jsp
		String startDate = req.getParameter("StartYear") + "-" + req.getParameter("StartMonth") + "-" + 
				req.getParameter("StartDay");
		
		String endDate = req.getParameter("EndYear") + "-" + req.getParameter("EndMonth") + "-" + 
				req.getParameter("EndDay");
		
		String loanType = req.getParameter("LoanType");		
		
		String loanQuery = "(Select loan_id From loan_app_loan_types where loan_type = '" + loanType + "')";
		
		String sqlStatement = "Select * From loan_app_loans where (loan_type in " + loanQuery + ")";
		sqlStatement += "And start_date Between '" + startDate + "' And '" + endDate + "';";
		
		//Instantiates template to the DB connection in properties
		template = properties.jdbcTemplate(properties.datasource());
				
		LoanDao accesser = new LoanDao(template);
		
		//Runs the query and gets the results
		List<Loan> loans = accesser.queryLoans(sqlStatement);
		
		//Keeps information on database query
        HttpSession session = req.getSession();
        session.setAttribute("Query",loans);
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ReportController</title>");            
            out.println("<head>" + loanType + " Report </head>");
            out.println("<body>");
            
            //Checks if loans starts empty
            if(loans.isEmpty()) {
            	if(loanType.contentEquals("Mortgage")) {
            		out.println("<p>There are no new " + loanType.toLowerCase() + " applications started between " + startDate + " & " + endDate + "</p>");
            	}
            	else {
            		out.println("<p>There are no new " + loanType.toLowerCase() + " loan applications started between " + startDate + " & " + endDate + "</p>");
            	}
            }
            else {
	            out.println("<p>Loan Id | Customer Id | Amount | Start Date | Loan Duration | Interest Rate | Loan Status | Review Status | Down Payment</p>");
	            
	            //Prints the information of each loan in loans
	            while(!loans.isEmpty()) {
	            	Loan l = loans.get(0);
	            	loans.remove(0);
	            	String loanRow = "<p>" +l.getLoanID() + " | "+ l.getCustomerID() + " | " + l.getAmount() + " | " +
	            			l.getStartDate() + " | " + l.getLoanDuration() + " | " + l.getInterestRate() + " | ";
	            	if(l.getLoanStatus().equals("")) {
	            		loanRow += "pending | ";
	            	}
	            	else {
	            		loanRow += l.getLoanStatus()  + " | ";
	            	}
	            	loanRow +=  l.getDownPayment()  +"</p>";
	            	out.println(loanRow);
	            }
	           }
            out.println("</body>");
            out.println("</html>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
