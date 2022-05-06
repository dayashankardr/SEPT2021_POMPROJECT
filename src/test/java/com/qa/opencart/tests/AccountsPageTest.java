package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.util.Constants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeClass
	public void accountsPageSetUp() {
		loginPage = homePage.doClickLoginPageLink();
		accountsPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String accPageTitle = accountsPage.getAccountsPageTitle();
		System.out.println("Accounts Page Title = "+accPageTitle);
		Assert.assertEquals(accPageTitle, Constants.ACCOUNT_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void accountPageHeaderTest() {
		String accPageHeader = accountsPage.getAccountsPageHeader();
		System.out.println("Accounts Page Header = "+accPageHeader);
		Assert.assertEquals(accPageHeader, Constants.OPEN_CART_WEBSITE_HEADER);
	}
	
	@Test(priority = 3)
	public void searchFieldDisplayedTest() {
		Assert.assertTrue(accountsPage.isSearchFieldExists()); 
	}
	
	@Test(priority = 4)
	public void logOutLinkDisplayedTest() {
		Assert.assertTrue(accountsPage.islogOutLinkExists()); 
	}
	
	@Test(priority = 5)
	public void accountSectionHearderListTest() {
		List<String> actAccSecList = accountsPage.getAccSectionHeaderList();
		Assert.assertEquals(actAccSecList, Constants.getExpectedAccSecList());
	}
	
	/**
	 * 2D Array to store multiple Product data to pass enterProductNameAndSearchTest function
	 * @return This return 2D object Array
	 * Object[0][1] = "Mac Book Pro"
	 * Object[0][1] = "Apple"
	 * Object[0][1] = "Samsumg"
	 */
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"Mac Book Pro"},
			{"Apple"},
			{"Samsung"}
		};
	}
	
	/**
	 * enterProductNameAndSearchTest with Product Name = Mac Book Pro
	 *  enterProductNameAndSearchTest with Product Name = Apple
	 *   enterProductNameAndSearchTest with Product Name = Samsung
	 *   
	 *   3 times enterProductNameAndSearchTest function will be executed with different set of Data
	 */
	
	@Test(priority = 6, dataProvider = "productData")
	public void enterProductNameAndSearchTest(String productName) {
		System.out.println("Searching for Product: "+productName);
		accountsPage.doSearchProduct(productName);
		
	}
	
}
