package com.qa.amazon.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BaseClass;

public class Search_Filter_Page extends BaseClass{
	
	
	public Search_Filter_Page() throws IOException {
		
		PageFactory.initElements( driver,this);
	}
	Actions act=new Actions(driver);
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") WebElement search;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") WebElement item_search;
	@FindBy(xpath="//span[@class='a-expander-prompt']") WebElement see_more;
	@FindBy(xpath="//span[@class='a-size-base a-color-base' and text()='Samsung']") WebElement Brand;
	@FindBy(xpath="//div[@class='a-section s-range-input-container s-upper-bound']") WebElement Price;
	@FindBy(xpath="//input[@class='a-button-input']") WebElement go;
	@FindBy(xpath="//a[.//span[text()=\"Today's Deals\"]]") WebElement Deals;
	@FindBy(xpath="//a[.//span[text()='New']]") WebElement item_condition;
	
	
	
	public void Search() throws InterruptedException {
		act.moveToElement(search).click().sendKeys(props.getProperty("item")).build().perform();
		Thread.sleep(2000);
		item_search.click();
		
		
	}
	public void Filter() throws InterruptedException {
		see_more.click();
		Brand.click();
		Thread.sleep(2000);
		act.clickAndHold(Price).moveByOffset(80, 0).release().build().perform();
		go.click();
		Deals.click();
		item_condition.click();	
		Thread.sleep(2000);
		
	}

}
