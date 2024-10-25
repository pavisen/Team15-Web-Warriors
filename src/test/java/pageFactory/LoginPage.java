package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.ConfigReader;

public class LoginPage {
	
    public   WebDriver driver= DriverFactory.getDriver();
    
	static String baseurl = ConfigReader.loginPage();
	@FindBy(id="username")
	 static WebElement username;
	@FindBy(id="password")
	 static WebElement password;
	@FindBy(id="login")
	 static WebElement loginbtn;
	
    public LoginPage() {

		PageFactory.initElements(driver, this);		

	}
    
    
    
//To get LOg in URL
	public  void getbaseurl() throws InterruptedException {
		driver.get(baseurl);
		
		username.sendKeys("Sdet@gmail.com");
		Thread.sleep(1000);
		password.sendKeys("LmsHackathon@2024");
		Thread.sleep(2000);
		loginbtn.click();
		Thread.sleep(2000);
	}
	
	
	
	public  void enterUsername(String userName) {

		username.sendKeys(userName);

	}

	public void enterPassword(String passWord) {
		password.sendKeys(passWord);
	}

	public void clickLogin() {
		loginbtn.click();
	}

	
	
    
}
