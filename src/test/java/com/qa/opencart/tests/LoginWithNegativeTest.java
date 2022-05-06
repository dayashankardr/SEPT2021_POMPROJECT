package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithNegativeTest extends BaseTest{
	
	@BeforeClass
	public void loginPageSetup() {
		loginPage = homePage.doClickLoginPageLink();
	}
	
	@DataProvider
	public Object[][] loginTestDate() {
		return new Object[][] {
			{"test@gmail.co.in","test1234"}, //Invalid EmailId and Password
			{"",""}, //EmailId and Password = NULL
			{"daya3001@gmail.com","test3434"}, //Valid EmailId and Invalid Password
			{"daya3001@gmail.co.in","Selenium@12345"}, //InValid EmailId and Valid Password
		};
	}
	
	@Test(dataProvider = "loginTestDate")
	public void LoginWithInvalidEmailIdAndPasswordTest(String username, String password) {
		Assert.assertFalse(loginPage.doLoginWithWrongCredentials(username, password));
		
	}
	
}
