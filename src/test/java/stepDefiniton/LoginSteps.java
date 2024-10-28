package stepDefiniton;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class LoginSteps {
	
	public  WebDriver driver;	
	WebDriverWait wait;
    LoginPage loginPage = new LoginPage();
    ExcelReader exelread= new ExcelReader();
    
    @Given("Admin Gives the valid LMS portal URL")
    public void admin_gives_the_valid_lms_portal_url() {    	
  	    loginPage.getbaseurl();
  	    
    }

    
    @Then("Admin should land on the LMS poral")
    public void admin_should_land_on_the_lms_poral() {
    	Assert.assertEquals(loginPage.LMSportalURLValidation(),ConfigReader.loginPage() ); 
    }
    
    @Given("Admin is in login Page")
    public void admin_is_in_login_page() {
    	
    	
    }

    @SuppressWarnings("deprecation")
	@When("Admin enter valid credentials  and clicks login button")
    public void admin_enter_valid_credentials_and_clicks_login_button() throws IOException, InterruptedException {  
    	
    	loginPage.enterUsername(ConfigReader.userName());
    	loginPage.enterPassword(ConfigReader.passWord());
    	loginPage.clickLogin();   	
    	
    }

    
    @Then("Admin should land on dashboard page")
    public void admin_should_land_on_dashboard_page() {    	    	 
    	Assert.assertEquals(loginPage.DashboardValidation(), ConfigReader.DashboardURL());  	
    }
    
    
    @When("Admin enter invalid {string} {string} credentials and clicks login button")
    public void admin_enter_invalid_credentials_and_clicks_login_button(String Sheet, String TestCase) throws IOException {
        
    	loginPage.enterUsername(exelread.getTestData(Sheet, TestCase, "username"));
    	loginPage.enterPassword(exelread.getTestData(Sheet, TestCase, "password"));    	
    	loginPage.clickLogin();    	
    }

   
    @Then("Error message please {string} {string} check Adminname\\/password")
    public void error_message_please_check_adminname_password(String Sheet, String TestCase) throws IOException {    	
    	assertEquals(loginPage.loginErrormessage(),exelread.getTestData(Sheet, TestCase, "ErrorMessage"));    	
    }
    
   
   // verify login button action through keyboard

    @When("Admin enter valid credentials  and clicks login button through keyboard")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
    	loginPage.login_usingKeyBoardAction();  	
    	
    }
    
    
// verify login button action through mouse
    
    @When("Admin enter valid credentials  and clicks login button through mouse")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
        
    	loginPage.login_UsingmouseActions();
    	
    }
  

    
}

