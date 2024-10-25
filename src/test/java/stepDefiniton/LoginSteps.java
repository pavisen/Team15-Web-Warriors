package stepDefiniton;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class LoginSteps {
	
   
    String username;
	String password;
	//String Excelpath=ConfigReader.getexcelfilepath();
	String userNameExcelValue;
    String passwordExcelValue;   
    
    
    
    @Given("Admin launch the browser")
    public void admin_launch_the_browser() throws InterruptedException {
    	 LoginPage loginPage = new LoginPage();
    	  loginPage.getbaseurl();
    	 
    	  
    }
    @When("Admin gives the correct LMS portal URL")
    public void admin_gives_the_correct_lms_portal_url() {
       
    }
    @Then("Admin should land on the login page")
    public void admin_should_land_on_the_login_page() {
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    


	/*
	 * @When("Admin enter valid credentials from {string} and {int} clicks login button through keyboard"
	 * ) public void
	 * admin_enter_valid_credentials_from_and_clicks_login_button_through_keyboard(
	 * String SheetName, Integer RowNumber) throws InvalidFormatException,
	 * IOException { ExcelReader reader = new ExcelReader();
	 * 
	 * List<Map<String, String>> testdata = reader.getData(Excelpath, SheetName);
	 * String userNameExcelValue = testdata.get(RowNumber).get("userName"); String
	 * passwordExcelValue = testdata.get(RowNumber).get("password");
	 * System.out.println(userNameExcelValue);
	 * System.out.println(passwordExcelValue); }
	 * 
	 * 
	 * 
	 * @Then("Admin should land on dashboard page") public void
	 * admin_should_land_on_dashboard_page() {
	 * 
	 * }
	 * 
	 */




    
}

