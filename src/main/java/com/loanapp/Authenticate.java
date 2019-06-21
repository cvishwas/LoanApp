package com.loanapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.bank.app.LoginBean;

public class Authenticate {
																//replace with YOUR Database Info
		private static final String DB_DRIVER = "org.postgresql.Driver";
		private static final String DB_URL = "jdbc:postgresql://localhost/USERS?";
		private static final String DB_USER = "postgres";
		private static final String DB_PASS = "2377";
																//replace with YOUR Database Info
		public static boolean validate(LoginBean bean){  
		boolean status=false; 
		try{  
		Class.forName(DB_DRIVER); 
		//System.out.println("Driver Loaded");
		
		Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);								
		//System.out.println("DBConnected");
		PreparedStatement ps=con.prepareStatement(  
		    "select * from \"USERLIST\" where username=? and password=?");   
											//replace with YOUR loan table name
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