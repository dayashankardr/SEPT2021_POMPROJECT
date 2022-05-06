package com.qa.opencart.tests;

import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterAccountPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	Properties prop;
	
	HomePage homePage;
	LoginPage loginPage;
	RegisterAccountPage registerAccountPage;
	AccountsPage accountsPage;
	
	@BeforeTest
	public void setUp() throws FileNotFoundException	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		homePage = new HomePage(driver);
		//loginPage = new LoginPage(driver);
	//	registerAccountPage = new RegisterAccountPage(driver);
		 
	}
	
	@AfterTest
	public void tearDown()	{
		driver.quit();
	}
}
