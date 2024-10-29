package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;

public class Utility_Methods {

    //Utility for methods
    public static WebDriver driver = DriverFactory.getDriver();
    public  String ExcelPath = ConfigReader.getexcelfilepath();
     WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));

        public void waitForElement(WebElement element) {

        try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

  
    public boolean webSendKeys(WebElement element, String text) {
		try {
			WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
		
				if(ele.isEnabled()) {
					try {
						ele.clear();
						ele.sendKeys(text);	
						return true;
					}
					catch(Exception e) {
						e.printStackTrace();
						return false;
					}	
				}
				else {
					throw new Exception("Element is not enabled");
				}
			}
			
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    public boolean webElement_Click(WebElement element) {
		try {
			WebElement ele_toclick = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
				
				if(ele_toclick.isEnabled() && ele_toclick.isDisplayed()) {
					try {
						ele_toclick.click();
						return true;
					}
					catch(Exception e) {
						e.printStackTrace();
						return false;
					}	
				}
				else {
					throw new Exception(element+" Element is not enabled or clickable or displayed");
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
    public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
    public String getElementText(WebElement element) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getText();
	}
    public String getCodefromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData(ExcelPath, sheetname);
        String code = testdata.get(rownumber).get("PythonCode");
        return code;
    }

}