package com.onlineApp.genericutility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseUtility {
	static Driver driver;
	Statement state;
	Connection con;

	public void ConnectToDataBase() throws SQLException
	{
         driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
	 con = DriverManager.getConnection("IConstants.Jdbc_Url,IConstants.JDBC_USERNAME,IConstants.JDBC_Password");
		//Statement state = con.createStatement();
	}
	
    public  ResultSet Execute(String query) throws SQLException
		{
	 query="Select * from emp";
		ResultSet result = state.executeQuery(query);
		return result;
				
		}
        public void closeDb() throws SQLException
        {
        	con.close();
        }
	
}


