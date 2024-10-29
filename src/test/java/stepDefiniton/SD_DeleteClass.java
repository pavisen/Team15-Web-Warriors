package stepDefiniton;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AddClassPage;
import pageFactory.DeleteClassPage;
import pageFactory.EditClassPage;
import pageFactory.ManageClassPage;
import utilities.ExcelReader;
import utilities.Utility_Methods;

public class SD_DeleteClass {
	
	AddClassPage addClasspage = new AddClassPage();
	ManageClassPage manageClassPage = new ManageClassPage();
	EditClassPage editClassPage = new EditClassPage();
	DeleteClassPage deleteClassPage = new DeleteClassPage();

    WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;
	SoftAssert softAssert = new SoftAssert();
    ExcelReader exelread= new ExcelReader();
    Utility_Methods util = new Utility_Methods();
    
    @When("Admin clicks Deleteclass button_CM")
    public void admin_clicks_deleteclass_button_cm() throws InterruptedException {
    	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	deleteClassPage.deleteClassDetailsWindow();  
    }
	
	@Then("Admin should see a alert open with heading {string} along with  <YES> and <NO> button for deletion_CM")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion_cm(String string) {
		deleteClassPage.checkDelete_alertbox();
	}

	@Given("Admin is on Confirm Deletion alert_CM")
	public void admin_is_on_confirm_deletion_alert_cm() {
		
	}


	@When("Admin clicks No option_CM")
	public void admin_clicks_no_option_cm() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteClassPage.DeletionAlertNO);
		//deleteClassPage.DeletionAlertNO.click();
	}

	@Then("Admin can see the deletion alert disappears without deleting_CM")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting_cm() {
		deleteClassPage.checkDelete_alertbox();
	}

	@When("Admin clicks on close button_CM")
	public void admin_clicks_on_close_button_cm() {
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", deleteClassPage.DeletionAlertClose);
		//deleteClassPage.DeletionAlertClose.click();
	}

	@Then("Admin can see the deletion alert disappears without any changes_CM")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes_cm() {
		
	}

	@When("Admin clicks yes option_CM")
	public void admin_clicks_yes_option_cm() throws InterruptedException {
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", deleteClassPage.DeletionAlertYES);
		//deleteClassPage.DeletionAlertYES.click();
	}

	@Then("Admin gets a message {string} alert and do not see that Class in the data table_CM")
	public void admin_gets_a_message_alert_and_do_not_see_that_class_in_the_data_table_cm(String string) throws InterruptedException {
		String ExpectedMsg= "Class Deleted";
		softAssert.assertEquals(deleteClassPage.getDeleteMessageText(), ExpectedMsg);
	}


}
