package com.rmgyantra.genericutility;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClassWithReqSpec {
	public JavaUtility jLib = new JavaUtility();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public DataBaseUtility dLib = new DataBaseUtility();
	public RequestSpecification requestSpec;
	public ResponseSpecification responseSpec;
	/**
	 * RequestSpecBuilder and ResponseSpecBuilder are classes in restAssured Library
	 * with the help of which we can store some common actions in both request and response
	 * @throws Throwable
	 */
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		dLib.connectDB();
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost");
		builder.setPort(8084);
		builder.setContentType(ContentType.JSON);
		requestSpec = builder.build();
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		responseSpec = builder.expectContentType(ContentType.JSON).build();
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();		
	}
}
