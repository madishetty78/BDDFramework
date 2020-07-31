package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Helper {
	
  public static void captureScreenshot(WebDriver driver)
  {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  
	  try
	  {
		  FileHandler.copy(src, new File("./Screenshots/" + getCurrentDateTime() +".png"));
	  }
	  catch(IOException e)
	  {
		  System.out.println("Unable to Capture Screenshot");
	  }
	  
  }
  
  public static String getCurrentDateTime()
  {
	  DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	  Date CurrentDate = new Date();
	  
	  return customFormat.format(CurrentDate);
  }
  
  

}
