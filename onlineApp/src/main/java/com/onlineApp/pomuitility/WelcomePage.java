package com.onlineApp.pomuitility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM is for Welcome Page
 * @author Nikhita Biradar
 */

public class WelcomePage {
	@FindBy(xpath = "//span[@class='caret']")
	private WebElement myAccontDropdown;
	
	@FindBy (xpath = "//li[.='Register']")
	private WebElement registerBtn;
	
	@FindBy (xpath = "//li[.='Login']")
	private WebElement loginBtn;
	
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void registrationClick()
	{
		myAccontDropdown.click();
		registerBtn.click();
	}
	
	public void loginClick()
	{
		myAccontDropdown.click();
		loginClick();
	}

}
