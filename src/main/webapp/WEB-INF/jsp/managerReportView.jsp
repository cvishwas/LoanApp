<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.loanapp.temp.sampleLoan" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Report View</title>
<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
-->
</head>
<body>

<table>
<tr>
	<td><b>Loan ID</b></td>
	<td><b>Approval Status</b></td>
</tr>
<% 
	ArrayList<sampleLoan> loanList = (ArrayList<sampleLoan>)request.getAttribute("loanList");
for(int i = 0; i < loanList.size(); i+=1) { %>
        <tr>      
            <td><%=loanList.get(i).getLoanID()%></td>
            <td><%=loanList.get(i).getLoanStatus()%></td>
        </tr>
    <% } %>
</table>
</body>
</html>