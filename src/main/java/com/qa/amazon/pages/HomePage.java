package com.qa.amazon.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.amazon.base.BaseClass;


public class HomePage extends BaseClass {
	
	
	public HomePage()throws IOException {
		PageFactory.initElements(driver, this);;
		
		
		
	}
	
	@FindBy(xpath="//*[@id=\"nav-search-label-id\"]")  WebElement defaultdropdownvalue;
	@FindBy(id="searchDropdownBox") public WebElement dropdown;
	@FindBy(id="twotabsearchtextbox") public WebElement SearchBox;
	@FindBy(id="nav-search-submit-button") public WebElement SearchBtn;
	@FindBy(id="nav-logo-sprites") public WebElement Logo;
	
	public String dropdown_value() throws InterruptedException {
		
		return defaultdropdownvalue.getText();
	}
	
	public void clickonElectronics(String Search) throws InterruptedException {
		Select se = new Select(dropdown);
		se.selectByVisibleText("Electronics");
		Thread.sleep(2000);
		SearchBox.sendKeys(Search);
		
		Thread.sleep(2000);
		SearchBtn.click();
		
		
	}
	
	public void LogoClick() {
		Logo.click();
	}
	
	
	public String verify_dropdown_change(String Search) throws InterruptedException {
		LogoClick();
		Thread.sleep(2000);
		SearchBox.sendKeys(Search);
		SearchBtn.click();
		Thread.sleep(2000);
		Select se = new Select(dropdown);
		WebElement ans = se.getFirstSelectedOption();
		String res = ans.getText();
		return res;
		
		
	}
	public void  verify_All_dropdown_Options() throws InterruptedException {
		Logo.click();
		Thread.sleep(2000);
		Select se = new Select(dropdown);
		
		 List <WebElement> op = se.getOptions();
	      int size = op.size();
	      for(int i =1; i<size ; i++){
	    	  
	    	  se.selectByIndex(i);
	    	  
	         String ExpectedValue = op.get(i).getText();
	         String ActualValue = dropdown_value();
	         
	         assertEquals(ActualValue, ExpectedValue);
	    
	 		
	         
	         
	         
	        
	         
	         Thread.sleep(500);
	      }
	  
	}
	
	
	
	
	
	

}
