package pageObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class HomePage
{
	WebDriver driver;
	 @FindBy(linkText="Home") WebElement Homelink;
	 @FindBy(linkText="Calendar") WebElement CalendarMenulink;
	 @FindBy(linkText="Contacts") WebElement ContactsMenulink;
	 @FindBy(linkText="Companies") WebElement CompaniesMenulink;
	 @FindBy(linkText="Deals") WebElement DealsMenulink;
	 @FindBy(linkText="Tasks") WebElement TasksMenulink;
	 @FindBy(linkText="Cases") WebElement CasesMenulink;
	 @FindBy(linkText="Calls") WebElement CallsMenulink;
	 @FindBy(linkText="Documents") WebElement DocumentsMenulink;
	 @FindBy(linkText="Email") WebElement EmailMenulink;
	 @FindBy(linkText="Campaigns") WebElement CampaignsMenulink;
	 @FindBy(linkText="Forms") WebElement FormsMenulink;
	 

	 
	 public void NavigateMenuItems() throws InterruptedException
	 {
		  Thread.sleep(2000);
		  Homelink.click();
		  Thread.sleep(2000);
		  CalendarMenulink.click();
		  Thread.sleep(2000);
		  ContactsMenulink.click();
		  Thread.sleep(2000);
		  CompaniesMenulink.click();
		  Thread.sleep(2000);
		  DealsMenulink.click();
		  Thread.sleep(2000);
		  TasksMenulink.click();
		  Thread.sleep(2000);
		  CasesMenulink.click();
		  Thread.sleep(2000);
		  CallsMenulink.click();
		  Thread.sleep(2000);
		  DocumentsMenulink.click();
		  Thread.sleep(2000);
		  EmailMenulink.click();
		  Thread.sleep(2000);
		  CampaignsMenulink.click();
		  Thread.sleep(2000);
		  FormsMenulink.click();	  
	 }
	 
	 public void findBrokenLinks() throws MalformedURLException, IOException, InterruptedException
	 {
		
		 //1. get the list of all links and images  
		 driver.get("http://www.freecrm.com/");
		List<WebElement> linksList = driver.findElements(By.tagName("a")); 
						
		linksList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("size of full links and images --->"+ linksList.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2. iterate linksList : exclude all the links/images - doesn't have any href attribute
		
		for( int i=0; i < linksList.size();i++)
		{
            System.out.println(linksList.get(i).getAttribute("href"));			
			if(linksList.get(i).getAttribute("href") !=  null)
			{
				activeLinks.add(linksList.get(i));
			}
		}
		
		//get the size of active links List:
		System.out.println("size of active links and images--->"+activeLinks.size());
		
		//3. check the href url, with httpconnection api:
		//200 -- Ok
		//404 -- not found
		//500 -- internal error
		//400 -- bad request
		for(int j=0; j<activeLinks.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			
			connection.connect();
			String response = connection.getResponseMessage(); //ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href") + "--->" + response);
		}
		
	 }
	
}
