package com.learnautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage
{

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
	
}
