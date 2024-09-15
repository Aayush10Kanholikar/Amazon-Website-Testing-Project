package com.qa.amazon.pages;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.amazon.base.BaseClass;

public class CreateNewAccountPage extends BaseClass {
	
	Actions actions;
	
	
	 public CreateNewAccountPage () {
		
		PageFactory.initElements( driver,this);
		 actions = new Actions(driver);
		
	 }
	 
	 
	 @FindBy(id = "nav-link-accountList") WebElement accountAndListsDropdown;
	 @FindBy(linkText = "Start here.") WebElement Start_Here_Link;
	 @FindBy( id= "ap_customer_name") WebElement Name;
	 @FindBy(id="ap_phone_number") WebElement mobile;
	 @FindBy(id="ap_password") WebElement passwordfield;
	 @FindBy(id="continue") WebElement verifymobile;
	 @FindBy(id="auth-pv-enter-code") WebElement verifycode;
	 
		@FindBy(id="auth-verify-button") WebElement SignUp;
	 
	 
	 
	 
	 public void hoverAndClick_Start_Here() throws InterruptedException {
	        // Hover over the "Account & Lists" dropdown
	        actions.moveToElement(accountAndListsDropdown).build().perform();
	        Thread.sleep(2000);
	        // Wait for the sign-in link to be visible and clickable
	        Start_Here_Link.click();
	        Thread.sleep(2000);
	        
	    }
	 
	 public void enterAccountDetails(String name, String  phoneNumber, String password) throws InterruptedException {
	        Name.sendKeys(name);
	        Thread.sleep(2000);
	        mobile.sendKeys(phoneNumber);
	        Thread.sleep(2000);
	        passwordfield.sendKeys(password);
	        verifymobile.click();
	        Thread.sleep(10000);
	    }
	 
	 
	 public void enterVerificationCodeManually() throws InterruptedException {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Please enter the verification code sent to your phone: ");
	        String code = scanner.nextLine(); // Read the verification code from the console
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	        verifycode.sendKeys(code); // Enter the code into the field
	        
	    }

	    
	    public void clickSignUpButton() {
	        SignUp.click();
	       
	    }

}
