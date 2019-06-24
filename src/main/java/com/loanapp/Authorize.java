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

public class Authorize {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final String DB_DRIVER = DBProperties.getDriverclassname();
	private static final String DB_URL = DBProperties.getUrl();
	private final static String DB_USER = DBProperties.getUsername();
	private static final String DB_PASS = DBProperties.getPassword();
	private static final String DB_TABLE = DBProperties.getTableName();

	public static String authorize(LoginBean bean) {
		String role = "undetermined";
		try {
			Class.forName(DB_DRIVER);
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			PreparedStatement ps = con.prepareStatement("select * from " + DB_TABLE + " where username=?");
			ps.setString(1, bean.getUsername());
			ResultSet rs = ps.executeQuery();
			rs.next();
			role = rs.getString("role");
			rs.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			return role;
		}
	}
}