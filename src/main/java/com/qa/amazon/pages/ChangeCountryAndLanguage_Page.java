package com.qa.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.amazon.base.BaseClass;

public class ChangeCountryAndLanguage_Page extends BaseClass {
	
	public ChangeCountryAndLanguage_Page() {
		PageFactory.initElements(driver, this);
		
	}
	Actions act=new Actions(driver);
	@FindBy(xpath="//*[@id=\"icp-nav-flyout\"]") WebElement languageSelector;
	@FindBy(xpath="//*[@id=\"icp-flyout-mkt-change\"]") WebElement countryDropdown;
	@FindBy(xpath="//*[@id=\"icp-dropdown\"]/span/span") WebElement dropdown;
	@FindBy(xpath="//a[contains(text(), 'Canada')]") WebElement selectCountry;
	@FindBy(xpath="//*[@id=\"icp-save-button\"]/span/input") WebElement Go_to_website;
	@FindBy(xpath="//*[@id=\"icp-language-settings\"]/div[3]/div/label/span/span") WebElement languageRadio;
	@FindBy(xpath="//*[@id=\"icp-save-button\"]/span/input") WebElement saveChangesButton;
	@FindBy(xpath="//span[contains(text(), 'Your changes have been saved')]")  WebElement confirmationMessage;
	@FindBy(xpath="//span[contains(text(), 'Bonjour')]") WebElement frenchText;
	@FindBy(xpath="//*[@id=\"nav-flyout-icp\"]/div[2]/a[9]/span/div")WebElement Learnmore;
	String originalWindow = driver.getWindowHandle();
	public void Learn_more() throws InterruptedException {
		act.moveToElement(languageSelector).perform();
        Thread.sleep(2000);
        Learnmore.click();
	}
	public void Changecountry_language() throws InterruptedException {
		act.moveToElement(languageSelector).perform();
        Thread.sleep(2000);
        countryDropdown.click();
        Thread.sleep(2000);
        dropdown.click();
        Thread.sleep(2000);
        selectCountry.click();
        Thread.sleep(2000);
        Go_to_website.click();
        Thread.sleep(2000);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
               driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]")).click();
               languageRadio.click();
               Thread.sleep(2000);
               saveChangesButton.click();
               Thread.sleep(2000);
            }
        }
        
       
        
	}
	public void validate_Language_country_change() {
		// Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message is displayed");
		 Assert.assertTrue(driver.getCurrentUrl().contains("www.amazon.ca"), "URL contains the expected country domain");
		 Assert.assertTrue(frenchText.isDisplayed(), "Language changed to French");
		 driver.switchTo().window(originalWindow);
	        
	}

}
