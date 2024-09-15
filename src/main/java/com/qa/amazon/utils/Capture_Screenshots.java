package com.qa.amazon.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import com.google.common.io.Files;
import com.qa.amazon.base.BaseClass;

public class Capture_Screenshots extends BaseClass {
	
	public Capture_Screenshots() throws IOException{
		PageFactory.initElements(driver, this);
	}
	public void Capture(String location) {
		
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File loc = new File("./Screenshots/"+location+".png");
		{

	try {
		Files.copy(screenshot, loc);
	}
	catch (IOException e) {
		e.printStackTrace();
	}

	}
		}
}
	


