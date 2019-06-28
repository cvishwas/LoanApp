<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.loanapp.beans.Loan"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Report</title>
</head>
<body>
<%List<Loan> loans = (List<Loan>)session.getAttribute("LoanList");
String type = (String)session.getAttribute("loanType");
String start = (String)session.getAttribute("startDate");
String end = (String)session.getAttribute("endDate");
if(loans.isEmpty()){
%>
	<p>There are no new <%=type.toLowerCase()%> loan applications started between <%=start%> & <%=end%></p>
<% 
}else{%>
<p><%=type%> Report </p>
<table BORDER="1">
	<TR>
		<TH>Loan Id</TH>
		<TH>Customer Id</TH>
		<TH>Amount</TH>
		<TH>Start Date</TH>
		<TH>Loan Duration</TH>
		<TH>Interest Rate</TH>
		<TH>Down Payment</TH>
		<TH>Loan Status</TH>
	</TR>
<%String status;
for(Loan l : loans){
	if(l.getLoanStatus().equals("")){
		status = "pending";
	}
	else{
		status = l.getLoanStatus();
	}%>

	<TR>
		<TD> <%= l.getLoanID() %> </TD>
		<TD> <%= l.getCustomerID() %> </TD>
		<TD> <%= l.getAmount() %> </TD>
		<TD> <%= l.getStartDate() %> </TD>
		<TD> <%= l.getLoanDuration() %> </TD>
		<TD> <%= l.getInterestRate() %> </TD>
		<TD> <%= l.getDownPayment() %> </TD>
		<TD> <%= status %> </TD>
	</TR>
<% 
	}
%>
</TABLE>
<%
}
%>
</body>
</html>