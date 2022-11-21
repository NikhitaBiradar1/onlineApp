package com.rmgyantra.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;
import com.rmgyantra.pomrepositorylib.HomePage;
import com.rmgyantra.pomrepositorylib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassforENDtoENDTest {
	WebDriverUtility wLib = new WebDriverUtility();
	ExcelUtility eLib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	DataBaseUtility dLib = new DataBaseUtility();
	public WebDriver driver = null;
	public Connection con = null;

	// Connect to the database
	@BeforeSuite
	public void configBS() throws SQLException {
		System.out.println(".....Connect to the Database.....");

		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
		con = DriverManager.getConnection(IConstants.JDBC_URL_String, IConstants.JDBC_USERNAME, IConstants.JDBC_PASSWORD);
	}

	// Launch the browser
	@BeforeClass
	public void configBC() throws Throwable {
		System.out.println("Launch the browser");
		String browser = fLib.getPropertyKeyValue("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		wLib.waitForElementInDOM(driver);
	}

	// Login to the application
	@BeforeMethod
	public void configBM() throws Throwable {
		System.out.println("Open the application welcome page");
		driver.get(fLib.getPropertyKeyValue("url"));
		System.out.println("Login to the application");
		LoginPage lP = new LoginPage(driver);
		lP.Login(fLib.getPropertyKeyValue("userUsername"), fLib.getPropertyKeyValue("userPassword"));
	}

	// Logout of the application
	@AfterMethod
	public void configAM() throws Throwable {
		HomePage hPage = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,0)");
		hPage.logoutOfApplication();
		System.out.println("Logout of the application");
	}

	// Close the Browser
	@AfterClass
	public void configAC() {
		System.out.println("Close the Browser");
		driver.close();
	}

	// Close the database connection
	@AfterSuite
	public void configAS() throws SQLException {
		System.out.println(".....Close the database connection.....");
		con.close();
	}
}
