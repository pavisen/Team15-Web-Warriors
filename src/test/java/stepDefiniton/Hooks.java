package stepDefiniton;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class Hooks {
	
	public WebDriver driver;
	
	
	@Before
	public void defineBrowser(Scenario scenario) throws Throwable {
		DriverFactory driverFactory = new DriverFactory();
		ConfigReader.readConfig();		
		driverFactory.initializeWebDriver(ConfigReader.browserType());

	}

	@AfterStep
	public void afterstep(Scenario scenario) {
		if (scenario.isFailed()) {
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "My screenshot");
			Allure.attachment("Myscreenshot", new ByteArrayInputStream(
					((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
		}
	}

	
	  
	  @After 
	  public void afterScenario(Scenario scenario) {
		  DriverFactory driverFactory = new DriverFactory();
	  driverFactory.closeDriver();
	  
	  }
	 

	// @AfterAll
	// public static void after() throws InterruptedException {
	// Thread.sleep(6000);
	// driverFactory.closeDriver();
	// }

}