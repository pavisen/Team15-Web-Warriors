package stepDefiniton;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class Hooks {
	
	public static WebDriver driver;
	public static DriverFactory driverFactory;

	
	@BeforeAll
	public static void before_all() throws Throwable {
//		prop= ConfigReader.init_prop();
//		ApplicationData appData = new ApplicationData();
//		appData.setApplicationData(ExcelReader.loadExcelData());
//		LMSConstants.applicationData = appData;
		ConfigReader.readConfig();
	}
@Before
	public static void beforeScenario() throws Throwable 
	{
		if (driver== null)
		{
		 driverFactory = new DriverFactory();
		System.out.println("Inside the Hooks");
		driver = driverFactory.initializeWebDriver(ConfigReader.browserType());
		}
	}

	@AfterStep
//	public void afterstep(Scenario scenario) {
//		if (scenario.isFailed()) {
//			LoggerLoad.error("Steps Failed , Taking Screenshot");
//			final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", "My screenshot");
//			Allure.attachment("Myscreenshot", new ByteArrayInputStream(
//					((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES)));
//		}
//	}
	 public void addScreenShot(Scenario scenario)
    {  	
    	if(scenario.isFailed())
    	{
    		String ScreenShotName = scenario.getName().replaceAll(" ", "_");
    		byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    		scenario.attach(sourcePath, "image/png", ScreenShotName);    		
    	}
    }
	  
	@AfterAll
	public static void quitBrowser() {
		  //DriverFactory driverFactory = new DriverFactory();
	 // driverFactory.closeDriver();
		driver.quit();
	  }
	 

	// @AfterAll
	// public static void after() throws InterruptedException {
	// Thread.sleep(6000);
	// driverFactory.closeDriver();
	// }

}