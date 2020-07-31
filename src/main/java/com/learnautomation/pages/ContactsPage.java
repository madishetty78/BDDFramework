package com.learnautomation.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
	
	
	public void createNewContact()
	{
		try {
			Thread.sleep(3000);
			ContactsMenulink.click();
			Thread.sleep(3000);
			ContactsNewlink.click();
			Thread.sleep(3000);
			FirstName.sendKeys("Anil");
			LastName.sendKeys("Madishetty");
			MiddleName.sendKeys("Kumar");
			Company.sendKeys("SCB");
			Email.sendKeys("anils78@yahoo.com");
			Categorydropdownicon.click();
			//Select selectCategory = new Select(Category);
			//selectCategory.selectByVisibleText("Customer");

			for (WebElement ele :Category )
			{
				String innerhtml = ele.getAttribute("innerHTML");			
				if(innerhtml.contentEquals("Customer"))
				{
				//	System.out.println(ele.isDisplayed() + " Anu");									
					ele.click();
					break;
				}
			}
							
			SaveButton.click();                                                                                         
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
