package com.loanapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.loanapp.beans.DBProperties;
import com.loanapp.configuration.DatabaseConfig;

//import com.bank.app.LoginBean;

public class Authenticate {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String DB_DRIVER = DBProperties.getDriverclassname();
	private static final String DB_URL = DBProperties.getUrl();
	private final static String DB_USER = DBProperties.getUsername();
	private static final String DB_PASS = DBProperties.getPassword();

		public static boolean validate(LoginBean bean){  
				boolean status=false; 
				
				try{         
				Class.forName(DB_DRIVER); 				
				Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);								
				PreparedStatement ps=con.prepareStatement(  
				    "select * from " + DBProperties.getTableName() + " where username=? and password=?"); 
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