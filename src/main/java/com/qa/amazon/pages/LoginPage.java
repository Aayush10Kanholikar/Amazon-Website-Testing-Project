package com.qa.amazon.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import com.qa.amazon.pages.HomePage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BaseClass;

public class LoginPage extends BaseClass{
	
	
	Actions actions;
	HomePage hp;
	
	
	
	 public LoginPage () throws IOException {
		
		PageFactory.initElements( driver,this);
		 actions = new Actions(driver);
		 hp=new HomePage();
		
	 }
	@FindBy(id = "nav-link-accountList") WebElement accountAndListsDropdown;
	 @FindBy(linkText = "Sign in") WebElement signInLink;
	@FindBy(id="ap_email") WebElement username;
	@FindBy(id="ap_password") WebElement password;
	@FindBy(id="continue") WebElement cont_btn;
	@FindBy(id="signInSubmit") WebElement signin_btn;

	public void hoverAndClickSignIn() throws InterruptedException {
        // Hover over the "Account & Lists" dropdown
		hp.LogoClick();
		 Thread.sleep(1000);
        actions.moveToElement(accountAndListsDropdown).build().perform();
        Thread.sleep(2000);
        // Wait for the sign-in link to be visible and clickable
        signInLink.click();
        Thread.sleep(1000);
        
    }
	
	
	public void login(String un,String pass) throws InterruptedException {
		hoverAndClickSignIn();
		Thread.sleep(1000);
		username.sendKeys(un);
		cont_btn.click();
		Thread.sleep(3000);
		password.sendKeys(pass);
		signin_btn.click();
		
	}
}
