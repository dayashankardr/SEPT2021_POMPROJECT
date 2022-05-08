package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ExcelUtil;

import com.qa.opencart.util.RandomGenerator;

public class RegisterAccountTest extends BaseTest{
	
	@BeforeClass
	public void loginPageSetup() {
		registerAccountPage = homePage.doClickRegisterLink();
	}
	
	@Test(priority = 1)
	public void registerPageTitleTest() {
		String actualregisterAccountPageTitle = registerAccountPage.getRegisterAccountTitle();
		System.out.println("Login Page title: " +actualregisterAccountPageTitle);
		Assert.assertEquals(actualregisterAccountPageTitle, Constants.REGISTER_ACCOUNT_TITLE);	
	}
	
	@Test(priority = 2)
	public void RegisterAccountLabelTest() {
		Assert.assertEquals(registerAccountPage.registerAccountLbl(), Constants.REGISTER_ACCOUNT_LABEL);	
	}
	
	@Test(priority = 3)
	public void RegisterAccountMsgTest() {
		Assert.assertEquals(registerAccountPage.alreadyAccExistsMsgLabel(), Constants.REGISTER_ACCOUNT_MESSAGE_LABEL);	
	}
	
	@Test(priority = 4)
	public void loginPageLinkTest() {
		Assert.assertTrue(registerAccountPage.isloginPageLinkExists());
	}
	
	@Test(priority = 5)
	public void yourPersonalDetailsLblTest() {
		Assert.assertEquals(registerAccountPage.yourPersonalDetailsLbl(), Constants.YOUR_PERSONAL_DETAILS_LABEL);	
	}
	
	@Test(priority = 6)
	public void yourPasswordLblTest() {
		Assert.assertEquals(registerAccountPage.yourPasswordLbl(), Constants.YOUR_PASSWORD_LABEL);	
	}
	
	@Test(priority = 7)
	public void newsLetterLblTest() {
		Assert.assertEquals(registerAccountPage.newsLetterLbl(), Constants.NEWS_LETTER_LABEL);	
	}
	
	  @DataProvider public Object[][] getRegisterTestDateFromExcel() { return
	  ExcelUtil.getExcelTestData(Constants.EXCEL_REGISTER_TEST_DATE); }
	  
	  @Test(priority = 8, dataProvider = "getRegisterTestDateFromExcel") public
	  void registerAccountTest(String firstName, String lastName, String telephone,
	  String password, String subscribe) throws InterruptedException {
	  Assert.assertTrue(registerAccountPage.doRegisterAccount(firstName, lastName,
	  RandomGenerator.getEmailId(), telephone, password, subscribe)); }
	 
	
	@Test(priority = 9, enabled=true)
	public void registerAccountSuccessUrlTest() {
		Assert.assertTrue(registerAccountPage.doRegisterAccountSuccessUrl());
				
	}

}
