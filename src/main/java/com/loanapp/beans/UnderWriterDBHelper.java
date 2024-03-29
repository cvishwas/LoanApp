package com.loanapp.beans;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties("db")
public class UnderWriterDBHelper {
	 static String driverclassname;
	 static String username;
	 static String password;
	 static String url;
	
	public  static String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public static  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public static String getDriverclassname() {
		return driverclassname;
	}
	public void setDriverclassname(String driverclassname) {
		this.driverclassname = driverclassname;
	}
	
	@Override
	public String toString() {
		System.out.println("In DataBase Properties "+ username + ", password=" + password + ", url=" + url );
		return "DBProperties =  [username=" + username + ", password=" + password + ", url=" + url + "]";
	}
	
	@Bean
	public DataSource datasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(this.driverclassname);
        dataSource.setUrl(this.getUrl());
        dataSource.setUsername(this.getUsername());
        dataSource.setPassword(this.getPassword());
        return dataSource;
	}
	
	@Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        return jdbcTemplate;
	}
}
