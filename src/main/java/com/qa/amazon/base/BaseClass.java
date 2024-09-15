package com.qa.amazon.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static Properties props;
	public static WebDriver driver;
	
	public BaseClass() {
		props=new Properties();
		
			try {
				FileInputStream fis = new FileInputStream("C:/Users/Aayush Kanholikar/eclipse-workspace/Amazon_Website_Testing//src/main/java/com/qa/amazon/config/config.properties");
				props.load(fis);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
	public static void intitialization() {
		String browserName=props.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(props.getProperty("url"));
		
	}
	public static void close() {
		driver.quit();
	}

}
