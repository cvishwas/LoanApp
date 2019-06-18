package com.loanapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.bank.app.LoginBean;


public class Authenticate {

		public static boolean validate(LoginBean bean){  
		boolean status=false; 
		try{  
		Class.forName("org.postgresql.Driver");  //replace with oracle stuff
		//System.out.println("Driver Loaded");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/USERS?user=postgres&password=2377"); //replace with oracle stuff
		//System.out.println("DBConnected");
		System.out.println(status);
		PreparedStatement ps=con.prepareStatement(  
		    "select COUNT(*) from \"USERLIST\" where username=? and password=?");   
										//replace with loan table name
		ps.setString(1,bean.getUsername());  
		ps.setString(2,bean.getPassword()); 
		ResultSet rs=ps.executeQuery(); 
		status=rs.next(); 
		return status;
		}catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		return status;

	}
}