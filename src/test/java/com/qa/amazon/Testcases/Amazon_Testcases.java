package com.qa.amazon.Testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.amazon.base.BaseClass;
import com.qa.amazon.pages.AddToCart_Page;
import com.qa.amazon.pages.ChangeCountryAndLanguage_Page;
import com.qa.amazon.pages.CreateNewAccountPage;
import com.qa.amazon.pages.HomePage;
import com.qa.amazon.pages.LogOut;
import com.qa.amazon.pages.LoginPage;
import com.qa.amazon.pages.Payment_Page;
import com.qa.amazon.pages.Search_Filter_Page;
import com.qa.amazon.utils.Capture_Screenshots;

public class Amazon_Testcases extends BaseClass {
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	Capture_Screenshots ss;
	LogOut lo;
	CreateNewAccountPage newacc;
	Search_Filter_Page sfp;
	AddToCart_Page acp;
	Payment_Page pp;
	ChangeCountryAndLanguage_Page cclp;
	
	public Amazon_Testcases () {
		super();
	}
	
	@BeforeTest
	public void setup() throws Exception{
		intitialization();
		lp=new LoginPage();
		hp=new HomePage();
		ss = new Capture_Screenshots();
		lo = new LogOut();
		newacc = new CreateNewAccountPage();
		acp=new AddToCart_Page();
		pp=new Payment_Page();
		sfp=new Search_Filter_Page();
		cclp=new ChangeCountryAndLanguage_Page();
		
	}
	//set enabled to true or simply remove enabled attribute when you have an unregistered mobile number. Then only this test case will run.
	 @Test(priority=1, enabled = false)
	 public void createNewAccount() throws InterruptedException {
		 newacc.hoverAndClick_Start_Here();
		 newacc.enterAccountDetails(props.getProperty("name"),props.getProperty("phoneNumber"),props.getProperty("password"));
		 Thread.sleep(5000);
		 newacc.enterVerificationCodeManually();
		 newacc.clickSignUpButton();
		 Thread.sleep(2000);
		 ss.Capture("CreateNewAccount");
	 } 
	
	@Test(priority=2)
	public void loginTest() throws Exception{
		lp.login(props.getProperty("phoneNumber"),props.getProperty("password"));
		Thread.sleep(1000);
		ss.Capture("LoginTC");
		Thread.sleep(4000);
		ss.Capture("deafult_Dropdown_Value_TC");
		
	}
	
	@Test(priority=3)
	public void deafult_dropdown_Test() throws Exception{
		
		final String ExpectedValue =  "All" ;
		
		Thread.sleep(2000);
		
		
		String ActualValue = hp.dropdown_value();
		
//        if(ExpectedValue.equals(ActualValue)) {
//        	
//        	System.out.println("Test case is passed");
//		}
//		else {
//			System.out.println("Test case is failed");
//		}
        assertEquals(ActualValue, ExpectedValue);
        Thread.sleep(2000);
        
        Thread.sleep(1000);
       
		
	}
	
	@Test(priority=4)
	public void Invalid_category_search() throws Exception {
		 Thread.sleep(1000);
		hp.clickonElectronics("Shirt");
		deafult_dropdown_Test();
		System.out.println("The search automatically changed to default to the 'All' category since 'shirt' is not a valid item in the 'Electronics' category. ");
		Thread.sleep(1000);
		 ss.Capture("Invalid_category_search_TC");
		
	}
	
	@Test(priority=5) //negative/ failed test case
	public void Verify_Dropdown_Change_Test() throws Exception {
		Thread.sleep(1000);
		String ActualValue = hp.verify_dropdown_change("Laptop");	
		final String ExpectedValue =  "Electronics";
		
		
		
		assertEquals(ActualValue, ExpectedValue, "TestCase is Failed. The Dropdown value did not changed to \"Electronics\" remains to \"All\" after searching for Laptop ");
		Thread.sleep(2000);
		ss.Capture("Verify_Dropdown_Change_TC");
		
	}
	
	@Test(priority=6)
	public void Verify_All_Dropdown_Options_Test() throws Exception {
		
		hp.verify_All_dropdown_Options();
		System.out.println("All Dropdown Options are functioning properly.");
		
		ss.Capture("Verify_All_Dropdown_Options_TC");
		
		
	}
	@Test(priority=7)
	public void Search_testcase() throws Exception {
		sfp.Search();
		Thread.sleep(2000);
		ss.Capture("Search_item");
	}
	@Test(priority=8)
	public void Filter_testcase() throws Exception {
		sfp.Filter();
		Thread.sleep(2000);
		ss.Capture("Filter");
	}
	@Test(priority=9)
	public void AddtoCart() throws Exception {
		acp.Addtocart();
		Thread.sleep(2000);
		ss.Capture("Addtocart");
		acp.Remove_product();
		Thread.sleep(2000);
		ss.Capture("Remove_product");
	}
	@Test(priority=10)
	public void Payment_testcase() throws Exception {
		pp.Buy_Product();
		Thread.sleep(2000);
		ss.Capture("Checkout");
		pp.BacktoCart();	
	}
	@Test(priority=11)
	public void learn_more() throws Exception {
		cclp.Learn_more();
		Thread.sleep(2000);
		ss.Capture("settings");
	}
	@Test(priority=12)
	public void Change_country_Language() throws Exception {
		cclp.Changecountry_language();
		Thread.sleep(2000);
		ss.Capture("ChangeCountryandLanguage");		
	}
	@Test(priority=13)
	public void validate_country_language_change() throws InterruptedException {
		cclp.validate_Language_country_change();
		Thread.sleep(2000);
	}
	@Test(priority=14)
	public void LogOut_TC() throws InterruptedException {
		hp.LogoClick();
		lo.hoverAndClickSignOut();
		Thread.sleep(2000);
		ss.Capture("Logout");
	}
    @AfterSuite
	public void tearDown() {
		close();
	}
	

}
