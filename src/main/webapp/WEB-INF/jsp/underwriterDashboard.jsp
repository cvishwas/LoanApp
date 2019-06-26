<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.io.*,java.lang.*,java.util.*,java.net.*,java.util.*,java.text.*"%>
<%@ page import="javax.activation.*,javax.mail.*,org.apache.commons.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import java.sql.*%>
<%@ page import java.sql.Connection%>
<%@ page import java.sql.DriverManager%>
<%!
public String Status(String AnD) {
String res = AnD;
Connection con;

try
{
String query = " INSERT INTO `Loans`(`Status`) VALUES(?,)";
con = DriverManager.getConnection("jdbc:mysql://" + "user=&password=");
pst = con.prepareStatement(query);
if(res == "Approve" || res == "approve")
{
pst.setString(1,Status.getText());
res.setLoanStatus();
}

if(res == "Deny" || res == "deny")
{
pst.setString(Status.getText());
res.setLoanStatus();
}
}
catch(SQLException ex)
{
System.out.println(ex);
}

return res;
}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UnderWriter Dashboard</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body style="background-color:powderblue;">
<br><center> <font size=6 color="Brown"><b> UNDERWRITER DASHBOARD</b> </font> </center>
<br>
<div class="container">
<div class="mt-7">
<div class="row form-group">
<div class="col-sm-1 font-weight-bold ">
Loan Id
</div>
<div class="col-sm-2 font-weight-bold ">
Loan Type
</div>
<div class="col-sm-2 font-weight-bold">
Customer Id
</div>

<div class="col-sm-2 font-weight-bold">
Loan Status
</div>
<div class="col-sm-2 font-weight-bold">
Review Status
</div>

<div class="col-sm-1 font-weight-bold">
</div>
<div class="col-sm-1 font-weight-bold">
</div>
</div>
<hr>

<c:if test="${not empty undList}">

<c:forEach var="item" items="${undList}">
<div class="row form-group">
<div class="col-sm-1 ">
${item.loan_Id}
</div>

<div class="col-sm-2 ">
${item.loan_Type}
</div>

<div class="col-sm-2 ">
${item.customer_Id}
</div>

<div class="col-sm-2 ">
${item.loan_Status}
</div>
<div class="col-sm-2">
${item.review_Status}
</div>

<form>
<label>Approve or Deny</label><br/>
<input type="text" name="AnD"><br/>
<input type="submit" onClick="Status(AnD)"/>
</form>
</div>
</c:forEach>

</c:if>

</div>
</div>
</body>
</html>