package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverFactory;
import utilities.ConfigReader;
import utilities.Utility_Methods;

public class LoginPage {
	
      WebDriver driver;
    
	String baseurl = ConfigReader.loginPage();
	//String baseurl ="https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/login";
	 Utility_Methods util=new Utility_Methods();	 


	@FindBy(id="username") WebElement usernametxtbox;
	@FindBy(id="password") WebElement passwordtxtbox;
	@FindBy(id="login") WebElement loginbtn;	

	//	@FindBy(xpath="//input[@id='username']") WebElement usernametxtbox;	
//	@FindBy(xpath="//input[@id='password']") WebElement passwordtxtbox;
//	@FindBy(xpath="//span[text()='Login']") WebElement loginbtn;

    public LoginPage(WebDriver driver) {
    	this.driver=driver;
		PageFactory.initElements(driver, this);		
	}   
    
//To get LOg in URL
	public void getbaseurl() {
		System.out.println("baseurl:"+baseurl);
		driver.get(baseurl);
	}
	
	public void enterUsername() {

		usernametxtbox.sendKeys("Sdet@gmail.com");

	}

	public void enterPassword() {
		passwordtxtbox.sendKeys("LmsHackathon@2024");
	}

	public void clickLogin() {
		loginbtn.click();
	}

	public void loginUsingValidDetails() throws InterruptedException {
		//usernametxtbox.clear();
		util.webSendKeys(usernametxtbox, "Sdet@gmail.com");
		//passwordtxtbox.clear();
		util.webSendKeys(passwordtxtbox,"LmsHackathon@2024");
		long startTime = System.currentTimeMillis();
		Thread.sleep(3000);
		util.webElement_Click(loginbtn);
		//loginbtn.click();
	}

	
	
    
}
