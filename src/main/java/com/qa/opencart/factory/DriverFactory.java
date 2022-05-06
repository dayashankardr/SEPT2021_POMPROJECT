package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static String highlight;
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>(); //Threadlocal driver to avoid issues in Parallel test
	
	/**
	 * This method is used to initialize the WebDriver
	 * @param browserName
	 * @return this will return the driver
	 */
	
	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser").trim();
		System.out.println("Browser Name is = " + browserName);
		
		highlight = prop.getProperty("highlight");
		
		optionsManager = new OptionsManager(prop);
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tldriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equals("fireforx"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equals("internetExplorer"))
		{
			WebDriverManager.iedriver().setup();
			//driver = new FirefoxDriver();
			tldriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else if(browserName.equals("safari"))
		{
			WebDriverManager.safaridriver().setup();
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver(optionsManager.getFirefoxOptions()));
		}
		else
		{
			System.out.println("Please pass the correct browser = " + browserName );
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		//driver.get(prop.getProperty("loginpageurl").trim());
		//driver.get(prop.getProperty("registrationpageurl").trim());
		getDriver().get(prop.getProperty("homepageurl").trim());
		
		return getDriver();
	}
	
	/**
	 * getDriver(): It will return a thread local copy of the WebDriver
	 */
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
	
	/**
	 * This method is used to intialize the properties of Config file data
	 * @return 
	 * This will return properties prop reference
	 * @throws FileNotFoundException 
	 */
	public Properties init_prop() throws FileNotFoundException {
		prop = new Properties();
		FileInputStream ip = null;
		
		String envName = System.getProperty("env");
		
		if(envName == null) {
			System.out.println("Automation Test cases are running on Production Environment");
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Automation Test cases are running on:" +envName);
			switch(envName) {
			case "qa":
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "integration":
				ip = new FileInputStream("./src/test/resources/config/int.config.properties");
				break;
			case "uat":
				ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "stage":
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
				
			default:
				System.out.println("Please pass the correct environment");
			}
			
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * getting Screenshots for Test Cases
	 */
	
	public String getScreenshot() {
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"\\screenshots\\"+System.currentTimeMillis()+".png";
		System.out.println(path);
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}

}
