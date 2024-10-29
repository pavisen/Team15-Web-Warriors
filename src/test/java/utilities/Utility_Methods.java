package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverFactory;

public class Utility_Methods {


    //Utility for methods
    public static  WebDriver driver = DriverFactory.getDriver();
    public  String ExcelPath = ConfigReader.getexcelfilepath();
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    
    public  void waitForElement(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }         
    
    
    
    public static boolean webSendKeys(WebElement element, String text) {
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
    
    
    
    public static boolean webElement_Click(WebElement element) {
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
    public static String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
    public static String getElementText(WebElement element) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getText();
	}
    
    public static String getElementAttribute(WebElement element,String attribute) {
		WebElement textElement = new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.visibilityOf(element));
		return textElement.getAttribute(attribute);
	}

	public static void assertText(WebElement element, String expected,String msg) {
		Assert.assertTrue(getElementText(element).equals(expected),msg);
	}
	

	public static String random5LetterWord(){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int index = (int)(100 * Math.random()) % 25;
			sb.append(alphabet.charAt(index));
		}
		return sb.toString();
		 
	}
	 
   
    

    public String getResultfromExcel(String sheetname, int rownumber) throws InvalidFormatException, IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData(ExcelPath, sheetname);
        String result = testdata.get(rownumber).get("Output");
        LoggerLoad.info("Expected result from Excel sheetname " + sheetname + " and " + rownumber + " : " + result);
        return result;
    }
 

    
    
   
}