package stepDefiniton;

import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageFactory.LoginPage;
import pageFactory.LogoutPage;
import utilities.ConfigReader;

public class LogoutSteps {
	
LoginPage loginpage= new LoginPage();
	LogoutPage logoutpage= new LogoutPage();
	
	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
	    loginpage.getbaseurl();
	    loginpage.enterUsername(ConfigReader.userName());
	    loginpage.enterPassword(ConfigReader.passWord());
	    loginpage.clickLogin();   	
    	
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
	    
		logoutpage.clickLogout();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	   Assert.assertEquals(logoutpage.logoutvalidation(), true);
	}
	
	// Verify back button
	
	@Given("Admin is logged out of the application")
	public void admin_is_logged_out_of_the_application() {
		loginpage.getbaseurl();
	    loginpage.enterUsername(ConfigReader.userName());
	    loginpage.enterPassword(ConfigReader.passWord());
	    loginpage.clickLogin();
	    logoutpage.clickLogout();
	}	
	
	@When("Admin is in login page and clicks the back button")
	public void admin_is_in_login_page_and_clicks_the_back_button() {
		Assert.assertEquals(logoutpage.logoutvalidation(), true);
		DriverFactory.getDriver().navigate().back();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertEquals(null, "ErrorMessage");
	}

}
