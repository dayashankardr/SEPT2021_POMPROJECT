package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class LoginPage {
	
	//1. Declare private WebDriver
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//2. By Locators
		private By emailId = By.id("input-email");
		private By password = By.id("input-password");
		private By loginBtn = By.xpath("//input[@value='Login']");
		private By registerLink = By.linkText("Register");
		private By forgotpawdLink = By.linkText("Forgotten Password");
		
		// Login with Wrong Credentials Locators
		private By loginErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//3. Login Page constructor
	public LoginPage(WebDriver driver)	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
		
	//4. Page Actions
	public String getLoginPageTitle()	{
		return eleUtil.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean getLoginPageUrl()	{
		return eleUtil.waitForURLToContain(Constants.LOGIN_PAGE_URl_FRACTION, Constants.DEFAULT_TIME_OUT);
	}
	
	public boolean isForgotPwdLinkExists() {
		return eleUtil.doIsDisplayed(forgotpawdLink);
	}
	public boolean isRegisterLinkExists() {
		return eleUtil.doIsDisplayed(registerLink);
	}

	public AccountsPage doLogin(String username, String pwd)
	{
		System.out.println("Login with : " +username + " : "+ pwd);
		eleUtil.doSendKeys(emailId, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		return new AccountsPage(driver);
	}
	
	public boolean doLoginWithWrongCredentials(String username, String pwd)
	{
		System.out.println("Login with : " +username + " : "+ pwd);
		eleUtil.doSendKeys(emailId, username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		
		String errorMessage = eleUtil.doGetText(loginErrorMessage);
		if(errorMessage.equals(Constants.LOGIN_ERROR_MESSAGE)) {
			return false;
		}
		return true;
	}
}
