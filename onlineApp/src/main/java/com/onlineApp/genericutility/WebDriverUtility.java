package com.onlineApp.genericutility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;



public class WebDriverUtility {

	/**
	 * This method to take screenshot when test script is failure
	 * @param string 
	 * @param sdriver 
	 * @return 
	 */
	public static String takeScreenShot(WebDriver sdriver, String string) {
		String screenshotpath="./Screenshot/"+new JavaUtility().getSystemDateTime()+".png";
		EventFiringWebDriver eDriver= new EventFiringWebDriver(sdriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		try {
			File dst = new File(screenshotpath);
			FileUtils.copyFile(src, dst);	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return screenshotpath;
		
	}
}
