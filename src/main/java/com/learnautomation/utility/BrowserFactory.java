package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver startApplication( WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "C:/Users/User/workspace/Framework/Drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("Firefox"))	
		{
			System.setProperty("webdriver.gecko.driver", "C:/Users/User/Downloads/Compressed/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equals("IE"))	
		{
			System.setProperty("webdriver.ie.driver", "C:/Users/User/Downloads/Compressed/chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We do not support this browser");
		}
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(appURL);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public  static void quitBrowser(WebDriver driver)
	{
		System.out.println("Closing the Browser"); 
		driver.quit();
	}
}

