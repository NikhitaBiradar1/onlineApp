package com.rmgyantra.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

public class BaseClass {
	
	public Connection con = null;

	// Connect to the database
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println(".....Connect to the Database.....");

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.JDBC_URL_String, 
										IConstants.JDBC_USERNAME,
										IConstants.JDBC_PASSWORD);
	}
	
	// Close the database connection
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println(".....Close the database connection.....");
		con.close();
	}
}
