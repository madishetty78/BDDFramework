package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Library {

    public String jsonPath = "testdata.json";
    public String docPath = "sample.png";



    public Select selectOptions(WebElement element) {
        return new Select(element);
    }

    public void waitUntilCondition(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void waitUntilElementInvisibleCondition(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitUntilTobClickable(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickButton(WebDriver driver, WebElement element)
    {
        waitUntilTobClickable(driver,element);
        element.click();
    }

    public void clickButtonWithText(WebDriver driver, String buttonText)
    {
        driver.findElement(By.xpath("//button[text()=\""+buttonText+"\"]")).click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public String getDate(String input)
    {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        Calendar c = Calendar.getInstance();
        if (input.equalsIgnoreCase("now")) {
            c.add(Calendar.DATE, 0);
        } else {
            c.add(Calendar.DATE, Integer.parseInt(input));
        }

        return dateFormat.format(c.getTime());
    }

    public String getDataFromJson(String input) throws IOException, ParseException {
        return (String) jcreateObject().get(input);
    }

	@SuppressWarnings("unchecked")
	public List<String> getAllJsonValues() throws IOException, ParseException {
		List<String> listOfvalues = new ArrayList<>();
		JSONObject jo = jcreateObject();
		jo.keySet().forEach(keyStr -> {
			listOfvalues.add(jo.get(keyStr).toString());
		});
		return listOfvalues;
	}

    public JSONObject jcreateObject() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(jsonPath));
        return (JSONObject) obj;

    }

    public String getDetailsFromProperty(String param) throws IOException {
        InputStream input = new FileInputStream("config.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(param);
    }

    public String getAbsolutePath(String path)
    {
        File file = new File(path);
        return file.getAbsolutePath();
    }

}
