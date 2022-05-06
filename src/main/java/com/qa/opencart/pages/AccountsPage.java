package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.cssSelector("div#logo a");
	private By AccSectionHeaderList = By.cssSelector("div#content h2");
	private By logOutLink = By.xpath("//a[contains(text(), 'Logout')]");
	private By searchField = By.name("search");
	private By searchBtn = By.cssSelector("div#search button");
	
	
	public AccountsPage(WebDriver driver){
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		return eleUtil.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String getAccountsPageHeader() {
		return eleUtil.doGetText(header);
	}
	
	public List<String> getAccSectionHeaderList() {
		List<WebElement> accSecWebElementList = eleUtil.getElements(AccSectionHeaderList);
		List<String> accSecStringList = new ArrayList<String>();
		for(WebElement e : accSecWebElementList) {
			String text = e.getText();
			accSecStringList.add(text);
		}
		
		return accSecStringList;
	}
	
	public boolean islogOutLinkExists() {
		return eleUtil.isElementExist(logOutLink);
	}
	
	public boolean isSearchFieldExists() {
		return eleUtil.isElementExist(searchField);
	}
	
	public SearchResultsPage doSearchProduct(String productName) {
		eleUtil.doSendKeys(searchField, productName);
	//	System.out.println("Searching Product Name is: "+productName);
		eleUtil.doClick(searchBtn);
		
		return new SearchResultsPage(driver);
	}


}
