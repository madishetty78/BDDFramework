package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider()
	{	
		pro = new Properties();
	    File src = new File ("./Config.properties");
					
		try {
				FileInputStream fis = new FileInputStream(src);
				pro.load(fis);
		} 
		catch (Exception e) {
					System.out.println("Unable to read Config File " + e.getMessage());
		}
	}
	
	public String getDataFromConfig(String KeyToSearch)
	{
		return pro.getProperty(KeyToSearch);
	}
	

}
