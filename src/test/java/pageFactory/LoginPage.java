package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.ConfigReader;

public class LoginPage {
	
    public  WebDriver driver= DriverFactory.getDriver();
    
	String baseurl = ConfigReader.loginPage();
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="login")
	WebElement loginbtn;
	
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

	
	
    
}
