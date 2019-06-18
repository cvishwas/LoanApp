<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.loanapp.temp.sampleLoan" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/customerDashboard.css" var="cdashcss" />
	<link href="${cdashcss}" rel="stylesheet" />
</head>
<body>
<h2>Welcome, <%= request.getAttribute("customerName") %></h2>

<table>
<tr>
	<td><b>Type</b></td>
	<td><b>Amount</b></td>
	<td><b>Date</b></td>
	<td><b>Period</b></td>
	<td><b>Status</b></td>
	<td><b>Action</b></td>
</tr>
<% 
	ArrayList<sampleLoan> loanList = (ArrayList<sampleLoan>)request.getAttribute("loanList");
for(int i = 0; i < loanList.size(); i+=1) { %>
        <tr>      
            <td><%=loanList.get(i).getLoanType()%></td>
            <td><%=loanList.get(i).getLoanAmount()%></td>
            <td><%=loanList.get(i).getLoanDate()%></td>
            <td><%=loanList.get(i).getLoanPeriod()%></td>
            <td><%=loanList.get(i).getLoanStatus()%></td>
            <td><a href="#">View</a>&nbsp;|&nbsp;<a href="#">Edit</a></td>
        </tr>
    <% } %>
</table>
</body>
</html>