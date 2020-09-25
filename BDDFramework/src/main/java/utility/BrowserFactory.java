package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import stepDefinition.UIGlue;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;


public class BrowserFactory {

	// Original Main Driver instance created
	public static WebDriver driver = null;
	
	private static final Logger logger = Logger.getLogger(BrowserFactory.class);
	
	public static WebDriver getDriver(String browserName) {
				
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
		  logger.info("Initializing the browser instance as : " + browserName);
		return driver;
	}
	
	
	
	public static WebDriver startApplication( String browserName, String appURL)
	{ 
		getDriver(browserName);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(appURL);
		driver.manage().deleteAllCookies();

		// Implicit Wait 
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		return driver;
	}
	
	//to perform Scroll on application using Selenium
	public static void scrollDownBrowser(WebDriver driver)
	{ 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void scrollUpBrowser(WebDriver driver)
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)", "");
	}
	
	public static void scrollDownBottomBrowser(WebDriver driver)
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	 //This will scroll the page Horizontally till the element is found
	public static void ScrollHorizontallyBrowser(WebDriver driver, WebElement element)
	{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	
	public  static void quitBrowser(WebDriver driver)
	{
		System.out.println("Closing the Browser"); 
		driver.quit();
	}
}

