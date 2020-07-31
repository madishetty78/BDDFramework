package com.learnautomation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitiLoginPage {
	
	WebDriver driver;
	
	public CitiLoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
   @FindBy(xpath="//*[@id=\"topMnu\"]") WebElement Homelink;
   @FindBy(xpath="//*[@id=\"container\"]/div[3]/div[2]/div/div[1]/div[1]/div[3]/p[1]/a") WebElement OnlineLink;
   @FindBy(name="username") WebElement UserId;
   @FindBy(name="password") WebElement Password;
   @FindBy(id="link_lkSignOn") WebElement SignOnButton;
   
   public void loginToCiti(String uname,String pswd)
   {
	   Homelink.click();
	   System.out.println("Homelink");
	   OnlineLink.click();
	   System.out.println("OnlineLink");
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   UserId.sendKeys(uname);
	   System.out.println("UserId");
	   Password.sendKeys(pswd);
	   System.out.println("Password");
	   SignOnButton.click();
   }
   
}


