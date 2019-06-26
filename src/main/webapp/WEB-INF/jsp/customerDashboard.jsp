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
	
	 <style type="text/css">
   		tr, td {
 			 border: 1px solid black;
		}
		table {
		  border-collapse: collapse;
		  border-spacing: 5px;
		  width: 50%;
		}
		td {
			text-align: center;
			padding: 4px;
		}
		th {
			text-align: center;
			padding: 3px;
		}
    </style>
</head>
<body>
<h2>Welcome, ${customerName}</h2>

<table>
<tr><td colspan="8";><b>Loans for ${customerName}</b></td></tr>
<tr>
	<td><b>Type</b></td>
	<td><b>Amount</b></td>
	<td><b>Start Date</b></td>
	<td><b>Duration (Months)</b></td>
	<td><b>Interest Rate</b></td>
	<td><b>Down Payment</b></td>
	<td><b>Status</b></td>
	<td><b>Action</b></td>
</tr>
<c:forEach items="${loans}" var="loan" varStatus="loopStatus">
	<tr>
		<td>${types[loan.loanType-1]}</td>
		<td>${loan.amount}</td>
		<td>${loan.startDate}</td>
		<td>${loan.loanDuration}</td>
		<td>${loan.interestRate}%</td>
		<td>${loan.downPayment}</td>
		<td>${loan.loanStatus}</td>
		<td><a href="#">View</a>&nbsp;|&nbsp;<a href="#">Edit</a></td>
	</tr>
</c:forEach>
</table>
<br>
<a href="/Loans/">Log Out</a>
</body>
</html>