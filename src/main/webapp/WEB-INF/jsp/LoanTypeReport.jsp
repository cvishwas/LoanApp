<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="ReportForm" name="ReportForm" action="/showReport" method="post">
    <p> Generate Loan Report</p>
    <p>
        Type of Loan
        <select id="SelectLoan" name="D1">
            <option>Mortgage</option>
            <option>Personal</option>
            <option>Auto</option>
            <option>Business</option>
        </select>
    </p>
    <p>
        Start Date:&nbsp;&nbsp; Month&nbsp;
        <input id="StartMonth" class="auto-style1" type="text" />&nbsp;&nbsp; Day
        <input id="StartDay" class="auto-style1" type="text" />&nbsp;&nbsp; Year
        <input id="StartYear" class="auto-style1" type="text" />
    </p>
    <p>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; To&nbsp;
    </p>
    <p>
        End Date:&nbsp;&nbsp;&nbsp; Month&nbsp; <input id="EndMonth" class="auto-style1" type="text" />&nbsp;&nbsp; Day
        <input id="EndDay" class="auto-style1" type="text" />&nbsp;&nbsp; Year
        <input id="EndYear" class="auto-style1" type="text" />&nbsp;&nbsp; 
    </p>
    <p>
        <input id="Button1" type="submit" value="Make Report" />
    </p>
    </form>
        
</body>
</html>