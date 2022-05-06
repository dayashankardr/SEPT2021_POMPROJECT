package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.util.Constants;
import com.qa.opencart.util.ElementUtil;
import com.qa.opencart.util.RandomGenerator;

public class RegisterAccountPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public RegisterAccountPage(WebDriver driver)	{
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	By registerAccountLbl = By.xpath("//h1[contains(text(),'Register Account')]");
	By alreadyAccExistsMsgLabel = By.xpath("//p[contains(text(), 'If you already have an account with us, please login at the ')]");
	By loginPageLink = By.xpath("//p/a[contains(text(), 'login page')]");
	
	By yourPersonalDetailsLbl = By.xpath("//fieldset[@id='account']/legend");
	By firstName = By.id("input-firstname");
	By lastName = By.id("input-lastname");
	By emailId = By.id("input-email");
	By telephone = By.id("input-telephone");
	
	By yourPasswordLbl = By.xpath("//legend[contains(text(),'Your Password')]");
	By password = By.id("input-password");
	By ConfirmPwd = By.id("input-confirm");
	
	By newsLetterLbl = By.xpath("//legend[contains(text(),'Newsletter')]");
	By newsLetterSubYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	By newsLetterSubNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	
	By privacyPolicyAgree = By.name("agree");
	
	By continueBtn = By.xpath("//input[@value='Continue']");
	
	By successMessage = By.cssSelector("div#content h1");
	
	By logOutLink = By.linkText("Logout");
	
	By registerLink = By.linkText("Register");
	
	public String getRegisterAccountTitle() {
		return eleUtil.doGetTitle(Constants.REGISTER_ACCOUNT_TITLE, Constants.DEFAULT_TIME_OUT);
	}
	
	public String registerAccountLbl() {
		return eleUtil.doGetText(registerAccountLbl);
	}
	
	public String alreadyAccExistsMsgLabel() {
		return eleUtil.doGetText(alreadyAccExistsMsgLabel);
	}
	
	public boolean isloginPageLinkExists() {
		return eleUtil.doIsDisplayed(loginPageLink);
	}
	
	public String yourPersonalDetailsLbl() {
		return eleUtil.doGetText(yourPersonalDetailsLbl);
	}
	
	public String yourPasswordLbl() {
		return eleUtil.doGetText(yourPasswordLbl);
	}
	
	public String newsLetterLbl() {
		return eleUtil.doGetText(newsLetterLbl);
	}
	
	public boolean doRegisterAccount(String firstName, String lastName, String emailId, String telephone, String password, String subscribe) throws InterruptedException{
		eleUtil.doSendKeys(this.firstName, firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		
	//	eleUtil.doSendKeys(this.emailId, RandomEmailGenerator.generateEmailIdGenerator());
		
		eleUtil.doSendKeys(this.emailId, emailId);
		eleUtil.doSendKeys(this.telephone, telephone);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.ConfirmPwd, password);
		
		if(subscribe.equals("Yes")) {
			eleUtil.doClick(newsLetterSubYes);
		}
		else {
			eleUtil.doClick(newsLetterSubNo);
		}
		eleUtil.doClick(newsLetterSubYes);
		eleUtil.doClick(privacyPolicyAgree);
		eleUtil.doClick(continueBtn);
		eleUtil.isElementExist(successMessage);
		String mesg = eleUtil.waitForElementToBeVisible(successMessage, 5, 1000).getText();
		if(mesg.equals(Constants.ACCOUNT_REGISTER_SUCCESS_MESSAGE)) {
			eleUtil.doClick(logOutLink);
			eleUtil.doClick(registerLink);
			return true;
		}
		
		return false;
	}
	
	public boolean doRegisterAccountSuccessUrl()	{
		return eleUtil.waitForURLToContain("route=account/success", Constants.DEFAULT_TIME_OUT);
	}
	
	

	
}
