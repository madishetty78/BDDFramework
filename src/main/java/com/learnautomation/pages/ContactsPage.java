package com.learnautomation.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.learnautomation.utility.BrowserFactory;

import cucumber.api.DataTable;

public class ContactsPage extends HomePage
{

	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > a > button > i") WebElement ContactsNewlink;
	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(3)") WebElement ContactsExportlink;
	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(2)") WebElement ContactsShowFilterlink;
	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(2)") WebElement ContactsHideFilterlink;
	
	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button:nth-child(1)") WebElement CancelButton;
	@FindBy(css="#dashboard-toolbar > div.ui.right.secondary.pointing.menu.toolbar-container > div > button.ui.linkedin.button") WebElement SaveButton;
	
	@FindBy(css="body > div.ui.page.modals.dimmer.transition.visible.active > div > div.actions > button.ui.primary.button") WebElement ExportPopupOKButton;
	@FindBy(css="body > div.ui.page.modals.dimmer.transition.visible.active > div > div.actions > button:nth-child(1)") WebElement ExportPopupCancelButton;
	
	// New Contact WebElements
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(1) > div:nth-child(1) > div > div > input[type=text]") 
	WebElement FirstName;
	
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(1) > div:nth-child(2) > div > div > input[type=text]")
	WebElement LastName;
	
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(2) > div:nth-child(1) > div > div > input[type=text]")
	WebElement MiddleName;
	
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(2) > div:nth-child(2) > div > div > input")
	WebElement Company;
	
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(4) > div:nth-child(1) > div > div > div > div.ui.right.corner.labeled.input > input[type=text]")
	WebElement Email;
	
	@FindBy(xpath="//div[@name='category']//div[@class='visible menu transition']//div/span") 
	//WebElement Category;
	List<WebElement> Category;
	
	@FindBy(xpath="//div[@name='category']//i[@class='dropdown icon']")
	WebElement Categorydropdownicon;
	
	@FindBy(xpath="//div[@name='status']//div[@class='visible menu transition']//div/span") 
	List<WebElement> Status;
	
	@FindBy(xpath="//div[@name='status']//i[@class='dropdown icon']")
	WebElement Statusdropdownicon;
	
	@FindBy(css="#ui > div > div.ui.fluid.container > div.ui.fluid.container > div > div.ui.fluid.container.main-content > form > div:nth-child(6) > div > div > textarea")
	WebElement Description;

	// Xpath selection for Label format syntax with name
    @FindBy(xpath="//div//div[@class='ui toggle checkbox']/label[.='Do not Call']")   
    // label[text()='Do not Call']") OR div[label[contains(text(),'Do not Call']] - this syntax also can be used    
    WebElement do_not_Call;
    
    @FindBy(xpath="//div//div[@class='ui toggle checkbox']/label[.='Do not Text']")       
    WebElement do_not_Text;
    
    @FindBy(xpath="//div//div[@class='ui toggle checkbox']/label[.='Do not Email']")       
    WebElement do_not_Email;
	    
	
	public void createNewContact(Map<String,String> map,WebDriver ldriver) throws Throwable
	{
		
		Thread.sleep(3000);
		ContactsMenulink.click();
		Thread.sleep(3000);
		ContactsNewlink.click();
		Thread.sleep(3000);
		
		if (map.containsKey("FirstName")) {
			setContactField("FirstName", map.get("FirstName").trim());
		}
		
		if (map.containsKey("LastName")) {
			setContactField("LastName", map.get("LastName").trim());
		}
		
		if (map.containsKey("MiddleName")) {
			setContactField("MiddleName", map.get("MiddleName").trim());
		}
		
		if (map.containsKey("Company")) {
			setContactField("Company", map.get("Company").trim());
		}
		
		if (map.containsKey("Email")) {
			setContactField("Email", map.get("Email").trim());
		}
		
		if (map.containsKey("Category")) {
			setContactField("Category", map.get("Category").trim());
		}
		if (map.containsKey("Status")) {
			setContactField("Status", map.get("Status").trim());
		}
		if (map.containsKey("Description")) {
			setContactField("Description", map.get("Description").trim());
		}
		
		BrowserFactory.scrollDownBrowser(ldriver);
		Thread.sleep(3000);
		
		//if (! do_not_call.isSelected())
		System.out.println("Do not call object Enable status " + do_not_Call.isEnabled());
		System.out.println("Do not call object display status " + do_not_Call.isDisplayed());
		
		if (do_not_Call.isEnabled())
			do_not_Call.click();
		
		if (do_not_Text.isEnabled())
			do_not_Text.click();
		
		if (do_not_Email.isEnabled())
			do_not_Email.click();
		//--------------------------------------------
							
		BrowserFactory.scrollUpBrowser(ldriver);
		
			SaveButton.click();                                                                                         
	}
	
	private void setContactField(String FieldName, String value) {
		
		switch (FieldName)
		{
		case "FirstName":
			FirstName.clear();
			FirstName.sendKeys(value);
			break;
			
		case "LastName":
			LastName.clear();
			LastName.sendKeys(value);
			break;
		
		case "MiddleName":
			MiddleName.clear();
			MiddleName.sendKeys(value);
			break;
			
		case "Company":
			Company.clear();
			Company.sendKeys(value);
			break;
			
		case "Email":
			Email.clear();
			Email.sendKeys(value);
			break;
			
		case "Category":
			Categorydropdownicon.click();
			
			for (WebElement ele :Category )
			{
				String innerhtml = ele.getAttribute("innerHTML");			
									
				if(innerhtml.contentEquals(value))	
				{							
					ele.click();
					break;
				}
			}
			break;
		
		case "Status":
			Statusdropdownicon.click();
		
			for (WebElement ele :Status )
			{
				String innerhtml = ele.getAttribute("innerHTML");			
								
				if(innerhtml.contentEquals(value))	
				{							
				ele.click();
				break;
				}
			}
			break;
			
		case "Description":
			Description.clear();
			Description.sendKeys(value);
			break;
		}
		
	}

	public void exploreNewContact()
	{
		try {
			Thread.sleep(3000);
			ContactsMenulink.click();
			Thread.sleep(3000);
			ContactsNewlink.click();
			Thread.sleep(3000);
			CancelButton.click();
			Thread.sleep(3000);
			ContactsExportlink.click();
			Thread.sleep(3000);
			ExportPopupOKButton.click();
			Thread.sleep(3000);
			ContactsShowFilterlink.click();
			Thread.sleep(3000);
			ContactsHideFilterlink.click();
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
