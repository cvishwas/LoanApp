<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.loanapp.temp.sampleLoan" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Report View</title>
<style type="text/css">

	html {
		height: 100%;
	}

	body {
  		background: linear-gradient(to top, #808080 0%, #3fada8 100%);
	}

	table, td, th {  
  		border: 1px solid #ddd;
  		text-align: left;
	}

	table {
  		border-collapse: collapse;
  		width: 100%;
	}

	th, td {
  		padding: 15px;
	}
	
	h1 {
		text-align: center;
		color: white;
		font-family: "Times New Roman", Times, serif;
	}
	
</style>

</head>
<body>
<h1> Current Loans in the time frame </h1>
<table>
<tr>
	<th>Loan ID</th>
	<th>Loan Type</th>
	<th>Approval Status</th>
	<th>Loan Start Date</th>
	<th><button type="button" name="disperse" onClick="">Disperse Funds</button></th>
</tr>
<c:forEach items="${loanData}" var="loan">
	<tr>
		<td>${loan.loanID}</td>
		<td>${loan.loanType}</td>
		<td>${loan.loanStatus}</td>
		<td>${loan.startDate}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>