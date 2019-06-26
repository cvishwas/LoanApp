<%@page import= "java.sql.DriverManager" %>
<%@page import= "java.sql.ResultSet" %>
<%@page import= "java.sql.Statement" %>
<%@page import= "java.sql.PreparedStatement" %>
<%@page import= "java.sql.Connection" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%
//Driver
String driverName = "com.sql.jdbc.Driver";
//Connection
String connectionurl = "jdbc:mysql://localhost:3306";
//Database Name
String dbName = "/loanappdb";
//UserID 
String userid = "root";
//UserPassword
String password = "admin";

try {
	Class.forName(driverName);
}catch (ClassNotFoundException ex){
	ex.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align = "center"><front><strong>Data Retrieval</strong></front></h2>
<table align = "center" cellpadding = "3" cellspacing="3" border = "1">
<tr>
</tr>
<%
try{
	connection = DriverManager.getConnection(connectionurl+dbName, userid, password);
	statement = connection.createStatement();
	//Insert the Query here to retrive the data
	String sql = "Select * from loan_app_customer_info; ";
	//ResultSet
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
}
%>

<tr>
	<td>ID</td>
	<td><%= resultSet.getString("customer_id") %></td>
</tr>
<tr>
	<td>SSN</td>
	<td><%= resultSet.getString("customer_ssn") %></td>
</tr>
<tr>
	<td>Address</td>
	<td><%= resultSet.getString("customer_address") %></td>
</tr>
<tr>
	<td>City</td>
	<td><%= resultSet.getString("customer_city") %></td>
</tr>
<tr>
	<td>State</td>
	<td><%= resultSet.getString("customer_state") %></td>
</tr>
<tr>
	<td>Country</td>
	<td><%= resultSet.getString("customer_country") %></td>
</tr>
<tr>
	<td>Date of Birth</td>
	<td><%= resultSet.getString("customer_date_of_birth") %></td>
</tr>
<tr>
	<td>Phone No</td>
	<td><%= resultSet.getString("customer_phone_number") %></td>
</tr>
<tr>
	<td>Salary</td>
	<td><%= resultSet.getString("customer_salary") %></td>
</tr>
<tr>
	<td>Credit Score</td>
	<td><%= resultSet.getString("customer_credit_score") %></td>
</tr>
<tr>
	<td>Relationship Status</td>
	<td><%= resultSet.getString("customer_relationship_status") %></td>
</tr>


<%

}catch (Exception ex){
	ex.printStackTrace();
}
%>

</table>