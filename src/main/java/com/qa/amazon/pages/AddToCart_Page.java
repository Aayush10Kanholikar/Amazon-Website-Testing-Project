package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BaseClass;

public class AddToCart_Page extends BaseClass{
	
	public AddToCart_Page() {
        PageFactory.initElements(driver, this);
    }

   @FindBy(id="a-autoid-58-announce") WebElement item1;
   @FindBy(id="a-autoid-60-announce") WebElement item2;
   @FindBy(linkText="Go to Cart") WebElement goToCartLink;
   @FindBy(xpath="//input[@value='Delete']") WebElement remove;

    public void Addtocart() throws InterruptedException {
    	item1.click();
    	item2.click();
    	Thread.sleep(2000);
    	goToCartLink.click();
  }
    public void Remove_product() throws InterruptedException {
    	remove.click();
    	Thread.sleep(2000);
    }

}
