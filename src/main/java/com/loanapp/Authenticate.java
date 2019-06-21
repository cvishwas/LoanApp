
3package com.loanapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.loanapp.configuration.DatabaseConfig;

//import com.bank.app.LoginBean;

public class Authenticate {
		
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		//replace with YOUR Database Info

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