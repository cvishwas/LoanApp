<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manager Report Choice</title>
<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
-->
</head>
<body>

   <form method="POST" action="chooseTime" >

   <input type="radio" name="time" value="15"/>Last 15 days<br>
   <input type="radio" name="time" value="7"/>Last 7 days <br>
   <input type="radio" name="time" value="1"/>Last 24 hours<br>
   <input type="submit" value="Next"  >

   </form>
   
</body>
</html>