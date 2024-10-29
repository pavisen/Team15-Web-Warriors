package stepDefiniton;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.apache.xmlbeans.impl.repackage.EditBuildScript;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AddClassPage;
import pageFactory.EditClassPage;
import pageFactory.LoginPage;
import pageFactory.ManageClassPage;
import utilities.ExcelReader;
import utilities.Utility_Methods;

public class SD_EditClass {

	AddClassPage addClasspage = new AddClassPage();
	ManageClassPage manageClassPage = new ManageClassPage();
	EditClassPage editClassPage = new EditClassPage();

    WebDriver driver = DriverFactory.getDriver();
	WebDriverWait wait;
	SoftAssert softAssert = new SoftAssert();
    ExcelReader exelread= new ExcelReader();
    Utility_Methods util = new Utility_Methods();
	
    @When("Admin clicks {string} button_CM in the dahboard")
    public void admin_clicks_button_cm_in_the_dahboard(String string) throws InterruptedException {
    	//driver.get("https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/session");
    	WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	editClassPage.editClassDetailsWindow();    
	}

	@Then("new pop up with class details appears_CM")
	public void new_pop_up_with_class_details_appears_cm() throws InterruptedException {
		addClasspage.getClassDetailsWindow();
	}

	@Then("Admin should see batch name field is disabled_CM")
	public void admin_should_see_batch_name_field_is_disabled_cm() {
		//WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		editClassPage.check_Disabled_fields();
	}

	@Then("Admin should see class topic field is disabled_CM")
	public void admin_should_see_class_topic_field_is_disabled_cm() {
		
	}

	@When("Update the fields with valid data and click save_CM")
	public void update_the_fields_with_valid_data_and_click_save_cm() throws InterruptedException {
		editClassPage.editClassDetailsWindow();
		editClassPage.update_validClass();
	}

	@Then("Admin gets message {string} and see the updated values in data table_CM")
	public void admin_gets_message_and_see_the_updated_values_in_data_table_cm(String string) throws InterruptedException {
		String ExpectedMsg1 = "Successful";
		String ExpectedMsg2 = "Class Created";
		String ExpectedMessage = ExpectedMsg1 + " " + ExpectedMsg2;
		softAssert.assertEquals(editClassPage.getUpdateMessageText(), ExpectedMessage);
	}

	@When("Update the fields with invalid values and click save_CM")
	public void update_the_fields_with_invalid_values_and_click_save_cm() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	editClassPage.editClassDetailsWindow(); 
    	editClassPage.EditClass_invalid();
	}

	@Then("Admin should get Error message_CM")
	public void admin_should_get_error_message_cm() throws InterruptedException {
		String exp_error_message ="Invalid Values ,Class not created";
		softAssert.assertEquals(editClassPage.getUpdateMessageText(), exp_error_message);
	}
	

	@When("Update the mandatory fields with valid values and click save_CM")
	public void update_the_mandatory_fields_with_valid_values_and_click_save_cm() {
	}

	@When("Update the optional fields with valid values and click save_CM")
	public void update_the_optional_fields_with_valid_values_and_click_save_cm() throws InterruptedException {
		editClassPage.editClassDetailsWindow(); 
		addClasspage.createClass_Optionalfield();
	}

	@When("Admin enters only numbers or special char in the text fields_CM")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields_cm() {
		
	}

	@When("Admin clicks Cancel button on edit popup_CM")
	public void admin_clicks_cancel_button_on_edit_popup_cm() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addClasspage.Cancel_class);
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class_CM")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class_cm() {

		assertTrue(addClasspage.onClick());
	}


}
