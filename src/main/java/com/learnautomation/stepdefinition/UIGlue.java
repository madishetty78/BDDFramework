package com.learnautomation.stepdefinition;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

// BaseClass where all Global variables are declared - Java Encapsulation feature
import com.learnautomation.pages.BaseClass;

import com.learnautomation.utility.BrowserFactory;

import com.learnautomation.pages.ContactsPage;
import com.learnautomation.pages.FreecrmLoginPage;
import com.learnautomation.pages.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class UIGlue extends BaseClass
{
	@Test
	public void TestFlow() throws InterruptedException
	{
		LoginApp();
		NavigateMenu();
		ContactScenarios();
		LogoutApp();
	}
	
	
	@Given("^Login into CRM Application$")
	public void LoginApp() throws InterruptedException
	{    
		driver = BrowserFactory.startApplication(driver, cdp.getDataFromConfig("Browser"), cdp.getDataFromConfig("URL"));
		//driver = BrowserFactory.startApplication(driver, "Chrome", "https://freecrm.com/index.html");
		System.out.println(driver.getTitle() + " >> Yes");
		
	    // creating instance to the LoginPage
	    FreecrmLoginPage loginpage = PageFactory.initElements(driver, FreecrmLoginPage.class);
	    
	    loginpage.loginTofreecrm("anils78@yahoo.com", "Anil4freecrm");
	    //System.out.println(edp.getStringData("Login", 2, 1) + " Yes" + edp.getStringData("Login", 2,2));
	   //loginpage.loginTofreecrm(edp.getStringData("Login", 2, 1), edp.getStringData("Login", 2,2));	 
	}
	
	@When("^Navigate the Menu$")
	public void NavigateMenu() throws InterruptedException
	{
		  HomePage hp = PageFactory.initElements(driver, HomePage.class);
		  hp.NavigateMenuItems();
	}
	
	@Then("^Create new Contacts$")
	public void ContactScenarios() throws InterruptedException
	{
		ContactsPage newcontact = PageFactory.initElements(driver, ContactsPage.class);
		
		//newcontact.exploreNewContact();
		newcontact.createNewContact();
	}
    
	@Then("^Logout the Application$")
	public void LogoutApp() 
	{
		BrowserFactory.quitBrowser(driver);
	}
}
