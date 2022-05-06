package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	//Create By locators to validate Home page fields
	By headerLabel = By.cssSelector("div#logo h1");
	By searchTextBox = By.name("search");
	By searchBtn = By.cssSelector("div#search button");
	By myAccountLink = By.xpath("//div[@id='top-links']//a[@title='My Account']/i");
	By myAccountLoginLink = By.xpath("(//div[@id='top-links']//a[@title='My Account']/../ul//li)[2]/a");
	By myAccountRegisterLink = By.xpath("(//div[@id='top-links']//a[@title='My Account']/../ul//li)[1]/a");
	
	
	//Class Constructor to get driver
	public HomePage(WebDriver driver){
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getHomePageGetTitle(){
		return eleUtil.doGetTitle(Constants.HOME_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
		
	public String getHomePageHeader() {
		return eleUtil.doGetText(headerLabel);
	}
	
	
	public LoginPage doClickLoginPageLink(){
		eleUtil.doClick(myAccountLink);
		eleUtil.doClick(myAccountLoginLink);
		return new LoginPage(driver);
	}

	public RegisterAccountPage doClickRegisterLink() {
		eleUtil.doClick(myAccountLink);
		eleUtil.doClick(myAccountRegisterLink);
		return new RegisterAccountPage(driver);
	}
	

}
