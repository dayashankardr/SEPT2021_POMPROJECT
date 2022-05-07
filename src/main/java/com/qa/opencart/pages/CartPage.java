package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class CartPage {
	
	String cartItems;
	
	By cartItemsNumber = By.xpath("//input[@id='orderId'");
	
	public void OrderProducts() {
		System.out.println("Cart has 2 products");
	}

}

