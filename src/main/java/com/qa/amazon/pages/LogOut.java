package com.qa.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BaseClass;

public class LogOut extends BaseClass{
	
	
	Actions actions;
	
	
	 public LogOut () {
		
		PageFactory.initElements( driver,this);
		 actions = new Actions(driver);
		
	 }
	@FindBy(id = "nav-link-accountList") WebElement accountAndListsDropdown;
	 @FindBy(linkText = "Sign Out") WebElement signOutLink;
	
	public void hoverAndClickSignOut() throws InterruptedException {
        // Hover over the "Account & Lists" dropdown
        actions.moveToElement(accountAndListsDropdown).build().perform();
        Thread.sleep(2000);
        // Wait for the sign-in link to be visible and clickable
        signOutLink.click();
        Thread.sleep(1000);
        
    }
	
	
	
		
	}


