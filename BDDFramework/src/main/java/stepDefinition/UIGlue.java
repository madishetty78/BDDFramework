package stepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import org.apache.log4j.Logger;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

// BaseClass where all Global variables are declared - Java Encapsulation feature
import base.BaseClass;
import utility.BrowserFactory;

import pageObject.ContactsPage;
import pageObject.FreecrmLoginPage;
import pageObject.HomePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class UIGlue extends BaseClass
{
	// All pages declaration
	private FreecrmLoginPage loginpage;
	private ContactsPage newcontact;
	private HomePage hp;

	private static final Logger logger = Logger.getLogger(UIGlue.class);

	/*
	@Test
	public void TestFlow() throws InterruptedException
	{
		LoginApp();
		NavigateMenu();
		//ContactScenarios(DataTable dataTable);
		LogoutApp();
	}
	
	// Constructor
	public UIGlue( FreecrmLoginPage loginpage,ContactsPage newcontact,HomePage hp)
	{
		this.hp = hp;
		this.loginpage = loginpage;
		this.newcontact = newcontact;
	}
	*/

	@Test
	@Given("^Login into CRM Application$")
	public void LoginApp() throws InterruptedException
	{    
		driver = BrowserFactory.startApplication(cdp.getDataFromConfig("Browser"), cdp.getDataFromConfig("URL"));
		//driver = BrowserFactory.startApplication(driver, "Chrome", "https://freecrm.com/index.html");
		System.out.println(driver.getTitle() + " >> Yes");
		
	    // creating instance to the LoginPage using above driver instance
	    loginpage = PageFactory.initElements(driver, FreecrmLoginPage.class);
	    
	    loginpage.loginTofreecrm("anils78@yahoo.com", "Anil4freecrm");
	    
	    // Yet to be developed 
	    //System.out.println(edp.getStringData("Login", 2, 1) + " Yes" + edp.getStringData("Login", 2,2));
	   //loginpage.loginTofreecrm(edp.getStringData("Login", 2, 1), edp.getStringData("Login", 2,2));	 
	}
	
	@When("^Navigate the Menu$")
	public void NavigateMenu() throws InterruptedException
	{     // creating instance to the HomePage using above driver instance of LoginApp()
		  hp = PageFactory.initElements(driver, HomePage.class);
		  hp.NavigateMenuItems();
	}
	
	@Then("^Find all the Broken links in the Home Page$")
	public void findBrokenLinks() throws MalformedURLException, IOException, InterruptedException
	{
		  hp = PageFactory.initElements(driver, HomePage.class);
		  hp.findBrokenLinks();;
	}
	
	@Then("^Create new Contacts based on below details$")
	public void ContactScenarios(DataTable dataTable) throws Throwable
	{
		// creating instance to the ContactsPage using above driver instance of LoginApp()
		newcontact = PageFactory.initElements(driver, ContactsPage.class);
		
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		//newcontact.exploreNewContact();
		newcontact.createNewContact(data, driver);
		
	}
    
	
	@Then("^Logout the Application$")
	public void LogoutApp() 
	{
		BrowserFactory.quitBrowser(driver);
	}
}
