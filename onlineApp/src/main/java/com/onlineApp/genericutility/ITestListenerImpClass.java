package com.onlineApp.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerImpClass implements ITestListener{
	ExtentReports extentReporter ;
	ExtentTest test;

	public void onStart(ITestContext context) {

		ExtentSparkReporter extentSparkreports=new ExtentSparkReporter("./ExtentReports/"+new JavaUtility().getSystemDateTime()+".html");
		extentSparkreports.config().setDocumentTitle("TechMax-Reports");
		extentSparkreports.config().setTheme(Theme.DARK);
		extentSparkreports.config().setReportName("TechMax-SuiteExecution");
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(extentSparkreports);
		extentReporter.setSystemInfo("Reporter", "Praveen");
		extentReporter.setSystemInfo("OS", "Windows-11");
		extentReporter.setSystemInfo("Browser", "chrome");
		extentReporter.setSystemInfo("URL", "http://192.168.0.190/domain/Sales_And_Inventory_System/pages/pos.php");
	}
	
	public void onFinish(ITestContext context) {
		extentReporter.flush();
	}

	public void onTestStart(ITestResult result) {
		test = extentReporter.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,result.getMethod().getMethodName()+" is passed" );
	}
	
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed" );
		test.log(Status.FAIL, result.getThrowable());
		//test.fail(MediaEntityBuilder.createScreenCaptureFromPath(WebDriverUtility.takeScreenShot()).build());
		try {
			String path=WebDriverUtility.takeScreenShot(BaseClass.sdriver, result.getMethod().getMethodName());
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+"is skipped" );
		test.log(Status.SKIP, result.getThrowable());
		
	}

//	public void onTestFailure(ITestResult result) {
//		JavaUtility jLib = new JavaUtility();
//		String TestName = result.getMethod().getMethodName();
//		EventFiringWebDriver eDriver= new EventFiringWebDriver(BaseClass.sdriver);
//		File src = eDriver.getScreenshotAs(OutputType.FILE);
//		try {
//			File dst = new File("./Screenshot/"+TestName+jLib.getSystemDateTime()+".png");
//			FileUtils.copyFile(src, dst);	
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//	}





}
