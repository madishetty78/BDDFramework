package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {
	
	
	public WebDriver driver;
	
	// ExcelDataProvider Object to handle Excel Data
	public ExcelDataProvider edp = new ExcelDataProvider();
	
	// ConfigDataProvider Object to handle Config Properties Data
	public ConfigDataProvider cdp = new ConfigDataProvider();
	

	@BeforeClass
	public void setup()
	{
		
	}
	
	@AfterClass
	public void teardown(ITestResult result)
	{
		 if(result.getStatus()== ITestResult.FAILURE)
		 {
			 Helper.captureScreenshot(driver);
		 }
	}
	
	

}
