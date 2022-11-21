package com.onlineApp.pomuitility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	@FindBy(xpath="//input[@name='search']")
	public WebElement searchTextField;
	
	@FindBy(xpath="//i[@class='fa fa-search']")
	public WebElement searchButton;
	
	
}
