package pageFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Utility_Methods;

public class LoginPage {
	
	
    public  WebDriver driver= DriverFactory.getDriver();
    String dashboardURL=ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();
	 Utility_Methods util=new Utility_Methods();	 
	 Actions actions = new Actions(DriverFactory.getDriver());
	 
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;	
	
	@FindBy(css = ".mat-error")
	WebElement errorMessage;
	
    @FindBy(id="program")
	WebElement ProgramBtn;
	
    public LoginPage() {

		PageFactory.initElements(driver, this);		

	}
        
    
//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseurl);
	}
	
	 public void readDataFromSheet(String sheetName, Integer rowNumber) throws IOException, InvalidFormatException {
		    String userNameExcelValue;
		    String passwordExcelValue;
	        ExcelReader reader = new ExcelReader();
	        List<Map<String, String>> testdata = reader.getData("src/test/resources/TestData/Team15-TestData.xlsx", sheetName);
	        userNameExcelValue = testdata.get(rowNumber).get("username");
	        passwordExcelValue = testdata.get(rowNumber).get("password");
	        username.sendKeys(userNameExcelValue);
	        password.sendKeys(passwordExcelValue);
	        loginbtn.click();
	        
	    }

	public void enterUsername(String userName) {
		username.sendKeys(userName);

	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		util.webElement_Click(loginbtn);
		
	}
	
	 public String loginErrormessage()
	    {		
		 util.waitForElement(errorMessage);
	     String message = errorMessage.getText();	      
	     return message;
	    }
	
	 public String DashboardValidation()
	 {	 
		    util.waitForElement(ProgramBtn);
	   	    String title2 = DriverFactory.getDriver().getCurrentUrl(); 
		    return title2;
		 
	 }
	 
	 
	 public void login_usingKeyBoardAction()	 {	 
		 
		     Actions actions = new Actions(DriverFactory.getDriver());
		    actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.userName()).perform();	
		    actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.passWord()).perform();	    	
	    	actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();	
	    	    	
	 }

	 public void login_UsingmouseActions()
	 
	 { 	
		 
		 actions.moveToElement(username).click()
	       .sendKeys(ConfigReader.userName())
	       .moveToElement(password).click()
	       .sendKeys(ConfigReader.passWord())
	       .moveToElement(loginbtn)
	       .click()
	       .build()
	       .perform();;

	 }
	 
	 
	 public String LMSportalURLValidation()
	 {
		    util.waitForElement(loginbtn);
	   	    String title2 = DriverFactory.getDriver().getCurrentUrl(); 
		     return title2;
	 }
}
