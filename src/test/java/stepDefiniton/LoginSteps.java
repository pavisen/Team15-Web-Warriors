package stepDefiniton;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import com.LMS.utility.CommonUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import drivers.DriverFactory;

public class LoginSteps {
	
   WebDriver driver =DriverFactory.getDriver();
    String username;
	String password;
	//String Excelpath=ConfigReader.getexcelfilepath();
	String userNameExcelValue;
    String passwordExcelValue;   
	 LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    
    
    @Given("Admin launch the browser")
    public void admin_launch_the_browser() {
    }
    @When("Admin gives the correct LMS portal URL")
    public void admin_gives_the_correct_lms_portal_url() {
  	  loginPage.getbaseurl();
    }
    @Then("Admin should land on the login page")
    public void admin_should_land_on_the_login_page() {
		Assert.assertEquals(driver.getTitle(),ConfigReader.getHomePageTitle());
    }
    @Given("Admin is in login Page")
    public void admin_is_in_login_page() {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("Admin enter valid credentials and clicks login button through keyboard")
    public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() throws InterruptedException 
    {  	  
	//loginPage.getbaseurl();//if we are running parallel we need to give this
	loginPage.loginUsingValidDetails();	
    }
    @Then("Admin should land on dashboard page")
    public void admin_should_land_on_dashboard_page() {
    	//Assert.assertEquals(,"LMS");
    }

}

