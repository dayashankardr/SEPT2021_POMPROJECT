package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class OrderPage {
	
	String order;
	
	By orderId = By.xpath("//input[@id='orderId'");
	
	public void OrderProducts() {
		System.out.println("Order is placed and order id = 1234");
	}

}
