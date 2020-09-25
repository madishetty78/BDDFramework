package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "stepDefinition",
                 features = "src/test/java/features/",
                 plugin= {"pretty","html:test-output","json:target/json-cucumber-reports/cukejson.json","testng:target/testng-cucumber-reports/cuketestng.xml"},
                 dryRun = false, // true == just to run and see if stepDefinition steps are missed or not only
                 monochrome=true
		        )

public class TestRunner {

}







