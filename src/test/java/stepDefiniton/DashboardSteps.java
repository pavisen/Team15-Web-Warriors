package stepDefiniton;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.DashBoardPage;
import pageFactory.HomePage;

public class DashboardSteps {
	public  WebDriver driver= DriverFactory.getDriver();
	DashBoardPage dashboard= new DashBoardPage();
	HomePage homepage= new HomePage();
	
	//  Verify the response time
	
	@Then("Maximum navigation time in milliseconds defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer Exptime) {
		    Exptime=3000;
			Assert.assertEquals(dashboard.responseTimeValidation(Exptime), true);			
	
}
	// Verify broken link in Dashboard page
	
	@Then("Admin Verifying the broken links in dashboard page")
	public void admin_verifying_the_broken_links_in_dashboard_page() throws MalformedURLException, IOException {
	    homepage.BrokenLinkValidation();
	   
	    }
	
	
	// Verify LMS title
	 
	 @Then("Admin should see correct spelling and space in LMS title")
	 public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		 Assert.assertEquals(dashboard.getTitle(), "LMS");
		 
	 }
	 
	 // Validate LMS title has correct spelling and space
	 
	 @Then("Admin should see LMS -Learning management system as title")
	 public void admin_should_see_lms_learning_management_system_as_title() {
	   Assert.assertEquals(dashboard.LMStextValidation(), true);
		 
	 }
	 
	 //Validate navigation bar text
	 
	 @Then("Admin should see correct spelling in navigation bar text")
	 public void admin_should_see_correct_spelling_in_navigation_bar_text() {		 
		 Assert.assertEquals(dashboard.navigationTextValidation(), true);		 
		 
	 }
	 
	 //Validate navigation bar order 
	 
	 @Then("Admin should see {string} in their respective {string}")
	 public void admin_should_see_in_their_respective(String position, String header) {
		 int headerposition=Integer.parseInt(position)-1;
		 Assert.assertEquals(dashboard.homepagePosition(headerposition), header);
		 
	     
	 }
	 
	 // Validate alignment for navigation bar on the top right side	 
	 
	 @Then("Admin should see the navigation bar text {string} on the top right side")
	 public void admin_should_see_the_navigation_bar_text_on_the_top_right_side(String Headertext) {		 
		 Assert.assertEquals(dashboard.headerTextallignment(Headertext), true);
		
	 }
	 
	 
	 // Validate navigation bar text
	 
	 @Then("LMS title should be on the top left corner of page")
	 public void lms_title_should_be_on_the_top_left_corner_of_page() {
		 Assert.assertEquals(dashboard.LMS_Allignmentvalidation(), true);
		
	 }
	 
	 
	
	 
}