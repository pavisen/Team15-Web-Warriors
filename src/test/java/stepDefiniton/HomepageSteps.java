package stepDefiniton;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.sourceforge.tess4j.TesseractException;
import pageFactory.HomePage;
import pageFactory.LoginPage;
import utilities.ConfigReader;

public class HomepageSteps {
	LoginPage loginPage = new LoginPage();
	HomePage homepage= new HomePage();
	
	
	public  WebDriver driver;
	
	@Given("Admin launches the browser")
	public void admin_launches_the_browser() {
	  // Browser already initiated in hooks
	}

	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		homepage.getInvalidbaseurl();
	}

	@Then("Admin should recieve page not found error")
	public void admin_should_recieve_page_not_found_error() throws MalformedURLException, IOException {	
		     
         Assert.assertEquals(homepage.InvalidURLValidation(), 404);
         
        }	
	
	
	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		loginPage.getbaseurl();
	}
	
	@Then("Admin Verifying the broken links in this page")
	public void admin_verifying_the_broken_links_in_this_page() throws MalformedURLException, IOException {		
		
		Assert.assertEquals(homepage.BrokenLinkValidation(),1);
	   
	}
	
	// Verify the text spelling in the page
	
	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
		
		Assert.assertEquals(homepage.homePageTextValidation(), true);
		
		
	}
	
	// Verify the company logo
	
	@Then("Admin should see logo on the left side")
	public void admin_should_see_logo_on_the_left_side() throws IOException, TesseractException {
		Assert.assertEquals(homepage.companyLogoValidation(), true);
			
}
	//Verify application name
	
	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() throws IOException, TesseractException {	
		String ExpText="LMS - Learning Management System";
	   Assert.assertEquals(homepage.appicationNameValidation(ExpText,false), true);
	}
	
	
	// Verify company name below the application name
	
	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() throws TesseractException, IOException {
		String ExpText="NumpyNinja";
		Assert.assertEquals(homepage.appicationNameValidation(ExpText,true), true);
		
	}
	
	//Validate sign in content
	
	@Then("Admin should see Please login to LMS application")
	public void admin_should_see_please_login_to_lms_application() {
	    Assert.assertEquals(homepage.signIncontentValidation(), true);
	}
	
	//Verify text field is present
	
	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	    
		Assert.assertEquals(homepage.VerifyingTextfieldCount(),2);
	}
	
	
	// Verify text on the first text field
	
	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String User) {
		User = "User";		
		Assert.assertEquals(homepage.verifyingTextField(User), true);
	}	

	
	// Verify text on the second text field
	
 @Then("Admin should {string} in the second text field")
 public void admin_should_in_the_second_text_field(String Password) {
	 Password = "Password";		
	Assert.assertEquals(homepage.verifyingTextField(Password), true);
 }
 
 
 // Verify Asterik next to User text
 
 @Then("Admin should see {string} field mandatory symbol next to user text")
 public void admin_should_see_field_mandatory_symbol_next_to_user_text(String Username) {
	 Username = "User *";		
		Assert.assertEquals(homepage.verifyingTextField(Username), true);
 }
 
 // Verify asterik next to password text
 
 @Then("Admin should see {string} field mandatory symbol next to password text")
 public void admin_should_see_field_mandatory_symbol_next_to_password_text(String password) {
	    password = "Password *";		
		Assert.assertEquals(homepage.verifyingTextField(password), true);
 }
 
 // verify Login button is present
 
 @Then("Admin should see login button")
 public void admin_should_see_login_button() {
	 
     Assert.assertEquals(homepage.loginBtnEnable(), true);
 }
 
   // Verify the alignment of the login button
 
 @Then("Admin should see login button on the centre of the page")
 public void admin_should_see_login_button_on_the_centre_of_the_page() {
     
	 Assert.assertEquals(homepage.loginBtnAllignment(), true);
 }
 
 @Then("Admin should see {string} in gray color")
 public void admin_should_see_in_gray_color(String TextField) {	
	 Assert.assertEquals(homepage.adminTextColorValidation(TextField), true);
 }
 
 
 
 
 
}
