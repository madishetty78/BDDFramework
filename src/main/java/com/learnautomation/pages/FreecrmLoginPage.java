package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FreecrmLoginPage {
WebDriver driver;
	
	public FreecrmLoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
    @FindBy(linkText="Log In") WebElement Loginlink;
	@FindBy(name="email") WebElement UserId;
    @FindBy(name="password") WebElement Password;
    @FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]") WebElement Loginbutton;
   
   public void loginTofreecrm(String uname,String pswd) throws InterruptedException
   {
	   Thread.sleep(3000);
	   Loginlink.click();
	   //driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	   System.out.println("Loginlink - Done");
	   UserId.sendKeys(uname);
	   System.out.println("UserId");
	   Password.sendKeys(pswd);
	   System.out.println("Password");
	   Loginbutton.click();
   }
   

}
