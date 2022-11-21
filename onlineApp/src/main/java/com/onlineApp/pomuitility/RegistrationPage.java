package com.onlineApp.pomuitility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This POM is for New user registration
 * @author Nikhita Biradar
 */

public class RegistrationPage {
	
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement eMail;
	
	@FindBy(xpath = "//input[@name='telephone']")
	private WebElement telephone;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='confirm']")
	private WebElement confirmPassword;
	
	@FindBy(xpath = "//label[contains(.,'Yes')]")
	private WebElement subscribeYes;
	
	@FindBy(xpath = "//label[contains(.,'No')]")
	private WebElement subscribeNo;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement privacyPolicyCheck;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement confirmBtn;
	
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void registerNewUser(String fName ,String lName ,String email ,String telno, String pwd, String cPwd)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		eMail.sendKeys(email);
		telephone.sendKeys(telno);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cPwd);
		subscribeNo.click();
		confirmBtn.click();
	}

}
