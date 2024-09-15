package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payment_Page extends AddToCart_Page {
	public Payment_Page() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']") WebElement Buy_item;
	@FindBy(xpath="//div[@id='banner-image']") WebElement Image;
	@FindBy(linkText="Return to Cart")WebElement Backto_Cart;
			
	public void Buy_Product() throws InterruptedException {
		Buy_item.click();
		Thread.sleep(200);
	}
	public void BacktoCart() {
		Image.click();
		Backto_Cart.click();
		
	}

}
