package com.onlineApp.pomuitility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

	WebDriver driver;
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
}
