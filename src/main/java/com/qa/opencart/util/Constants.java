package com.qa.opencart.util;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	/**
	 * GLOBAL CONSTANTS
	 */
	public static final int DEFAULT_TIME_OUT = 5;
	public static final String OPEN_CART_WEBSITE_HEADER = "Your Store";
	
	/**
	 * LOGIN PAGE CONSTANTS
	 */
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String LOGIN_PAGE_URl_FRACTION = "route=account/login";
	
	public static final Object LOGIN_ERROR_MESSAGE = "Warning: No match for E-Mail Address and/or Password.";

	
	/**
	 * REGISTER ACCOUNT PAGE CONSTANTS
	 */
	public static final String REGISTER_ACCOUNT_TITLE = "Register Account";
	public static final String REGISTER_ACCOUNT_LABEL = "Register Account";
	public static final String REGISTER_ACCOUNT_MESSAGE_LABEL = "If you already have an account with us, please login at the login page.";
	public static final String YOUR_PERSONAL_DETAILS_LABEL = "Your Personal Details";
	public static final String YOUR_PASSWORD_LABEL = "Your Password";
	public static final String NEWS_LETTER_LABEL = "Newsletter";
	
	public static final String EXCEL_REGISTER_TEST_DATE = "AccountRegistration";

	/**
	 * HOME PAGE CONSTANTS
	 */
	public static final String HOME_PAGE_TITLE = "Your Store";

	
	/**
	 * MY ACCOUNT PAGE CONSTANTS
	 */
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	public static final String ACCOUNT_REGISTER_SUCCESS_MESSAGE = "Your Account Has Been Created!";


	
	public static List<String> getExpectedAccSecList() {
		List<String> expAccSecList = new ArrayList<String>();
		expAccSecList.add("My Account");
		expAccSecList.add("My Orders");
		expAccSecList.add("My Affiliate Account");
		expAccSecList.add("Newsletter");
		
		return expAccSecList;
	}

	

}
