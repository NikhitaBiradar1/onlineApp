package com.onlineApp.pomuitility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class cartPage {
	WebDriver driver;
	public cartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
}
