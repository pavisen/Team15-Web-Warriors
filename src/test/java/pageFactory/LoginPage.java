package pageFactory;

import java.time.Duration;

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
import utilities.Utility_Methods;

public class LoginPage {
	
    public  WebDriver driver= DriverFactory.getDriver();
    String dashboardURL=ConfigReader.DashboardURL();
	String baseurl = ConfigReader.loginPage();
	 Utility_Methods util=new Utility_Methods();
	 WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
	 
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginbtn;	
	
	@FindBy(css = ".mat-error")
	WebElement errorMessage;
	
	
    public LoginPage() {

		PageFactory.initElements(driver, this);		

	}
    
    
    
//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseurl);
	}
	
	public void enterUsername(String userName) {

		username.sendKeys(userName);

	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		loginbtn.click();
	}
	
	 public String loginErrormessage()
	    {		
		 util.waitForElement(errorMessage);
	     String message = errorMessage.getText();	      
	     return message;
	    }
	
	 public void login_usingKeyBoardAction()
	 {
		    Actions actions = new Actions(DriverFactory.getDriver());
	    	actions.sendKeys(Keys.TAB);
	    	actions.moveToElement(username).sendKeys(ConfigReader.userName()).perform();
	    	actions.sendKeys(Keys.TAB);
	    	actions.moveToElement(password).sendKeys(ConfigReader.passWord()).perform();
	    	actions.sendKeys(Keys.TAB);
	    	actions.moveToElement(loginbtn).click().perform();	    	
	 }

    
	 
	 
}
