package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class LoginTest extends BaseTest {

	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.doClickLoginPageLink();
	}
		
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page title: " +actualLoginPageTitle);
		Assert.assertEquals(actualLoginPageTitle, Constants.LOGIN_PAGE_TITLE);	
	}
	
	@Test(priority = 2)
	public void loginPageUrlTest() {
		Assert.assertTrue(loginPage.getLoginPageUrl());
	}
	
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExists());
	}
	
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginPage.isRegisterLinkExists());
	}
	
	@Test(priority = 5)
	public void loginTest() {
		accountsPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accountsPage.getAccountsPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
	}
	

}
