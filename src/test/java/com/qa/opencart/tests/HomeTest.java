package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomeTest extends BaseTest{
	
	@Description("Home Page Title Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void HomePageTitleTest() {
		String actualHomePageTitle = homePage.getHomePageGetTitle();
		System.out.println("Home Page title: " +actualHomePageTitle);
		Assert.assertEquals(actualHomePageTitle, Constants.HOME_PAGE_TITLE);	
	}
	
	@Description("Home Page Header name Test")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 2)
	public void homePageHeaderTest() {
		String homePageHeader = homePage.getHomePageHeader();
		System.out.println("Home Page Header: " +homePageHeader);
		Assert.assertEquals(homePage.getHomePageHeader(), Constants.OPEN_CART_WEBSITE_HEADER);
	}
	
/*		
	@Test(priority = 3)
	public void searchProductTest() {
		homePage.searchProduct("mac book pro");
	}
	*/
	@Test(priority = 3)
	public void loginPageFromHomePageTest() {
		loginPage = homePage.doClickLoginPageLink();
		System.out.println("You are on Login Page Now");
		Assert.assertEquals(loginPage.getLoginPageTitle(), Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority = 4)
	public void accountRegisterFromHomePageTest() {
		registerAccountPage = homePage.doClickRegisterLink();
		System.out.println("You are on Account Register Page Now");
		Assert.assertEquals(registerAccountPage.getRegisterAccountTitle(), Constants.REGISTER_ACCOUNT_TITLE);
	}

}
