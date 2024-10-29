package runner;
import org.testng.annotations.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ConfigReader;
import utilities.LoggerLoad;
import drivers.*;

@CucumberOptions(plugin = { "pretty", "html:target/LMSPhase2_Reports.html",
		"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, // reporting purpose
		monochrome = true, // console output
		tags = " ", // tags from feature file
		features = "src/test/resources/features" , // location of feature files
		glue =  "stepDefiniton" )

// location of step definition files

public class TestRunner extends AbstractTestNGCucumberTests {

	//DriverFactory driverFactory;  // Declare an instance of DriverFactory

	static {
		try {
			LoggerLoad.info("Loading Config file");
			ConfigReader.readConfig();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	
}
