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
String dbName = "/";
//UserID 
String userid = "root";
//UserPassword
String password = "root";

try {
	Class.forName(driverName);
}catch (ClassNotFoundException ex){
	ex.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align = "center"><front><strong>Retriving Data from Database</strong></front></h2>
<table align = "center" cellpadding = "3" cellspacing="3" border = "1">
<tr>
</tr>
<%
try{
	connection = DriverManager.getConnection(connectionurl+dbName, userid, password);
	statement = connection.createStatement();
	//Insert the Query here to retrive the data
	String sql = "Select * from ";
	//ResultSet
	resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
}
%>

<tr>
	<td>First Name</td>
	<td><%= resultSet.getString("FirstName") %></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><%= resultSet.getString("LastName") %></td>
</tr>

<%

}catch (Exception ex){
	ex.printStackTrace();
}
%>

</table>