package stepDefiniton;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AddClassPage;
import pageFactory.LoginPage;
import pageFactory.ManageClassPage;
import utilities.ExcelReader;
import utilities.LoggerLoad;
import utilities.Utility_Methods;

public class SD_AddClass {

	AddClassPage addClasspage = new AddClassPage();
	ManageClassPage manageClassPage = new ManageClassPage();

	public WebDriver driver;
	WebDriverWait wait;
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginPage = new LoginPage();
	ExcelReader exelread = new ExcelReader();
	Utility_Methods util = new Utility_Methods();

	@When("Admin clicks {string} on the navigation bar_CM")
	public void admin_clicks_on_the_navigation_bar_cm(String string) throws InterruptedException {
		addClasspage.click_class();

	}

	@When("Admin clicks {string} button_CM")
	public void admin_clicks_button_cm(String string) throws InterruptedException {
		addClasspage.click_addclass();

	}

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window_CM")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window_cm()
			throws InterruptedException {
		addClasspage.getClassDetailsWindow();

	}

	@Then("Admin should be able to see the {string} for Add Batch as {string}_CM")
	public void admin_should_be_able_to_see_the_for_add_batch_as__cm(String string, String string2) {
		if (string.equalsIgnoreCase("batchName")) {
			addClasspage.StaffName.isDisplayed();
			Assert.assertTrue(util.getattribute(addClasspage.StaffName, "class").contains("dropdown"));
		} else if (string.equalsIgnoreCase("ClassDescription")) {
			addClasspage.ClassDescription.isDisplayed();
			Assert.assertEquals(util.getattribute(addClasspage.ClassDescription, "type"), "text");
		} else if (string.equalsIgnoreCase("StaffName")) {
			addClasspage.BatchName.isDisplayed();
			Assert.assertTrue(util.getattribute(addClasspage.BatchName, "class").contains("dropdown"));
		} else if (string.equalsIgnoreCase("Status")) {
			addClasspage.Active.isDisplayed();
			Assert.assertEquals(util.getElementTagName(addClasspage.Active), "p-radiobutton");
		} else if (string.equalsIgnoreCase("ClassTopic")) {
			addClasspage.classTopic.isDisplayed();
			Assert.assertEquals(util.getElementTagName(addClasspage.Active), "text");
		} else {
			addClasspage.class_NumberOfClasses.isDisplayed();
			Assert.assertEquals(util.getElementTagName(addClasspage.class_NumberOfClasses), "input");
		}
	}

	@When("Admin enters mandatory fields in the form_CM")
	public void admin_enters_mandatory_fields_in_the_form_cm() throws InterruptedException {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
		addClasspage.create_ValidClass();

	}

	@When("Admin clicks save button_CM")
	public void admin_clicks_save_button_cm() throws InterruptedException {

	}

	@Then("Admin can see the class details popup closed and adding new class message Class added Successfully_CM")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class_message_class_added_successfully_cm()
			throws InterruptedException {
		String ExpectedMsg1 = "Successful";
		String ExpectedMsg2 = "Class Created";
		String ExpectedMessage = ExpectedMsg1 + " " + ExpectedMsg2;
		softAssert.assertEquals(addClasspage.getSuccessMessageText(), ExpectedMessage);
	}

	@When("Admin selects class date in date picker_CM")
	public void admin_selects_class_date_in_date_picker_cm() throws InterruptedException {
		

	}

	@Then("Admin should see no of class value is added automatically_CM")
	public void admin_should_see_no_of_class_value_is_added_automatically_cm() throws InterruptedException {
		String expectedValue = "2";
		String actualValue = addClasspage.get_NoOfClass();
		Assert.assertEquals(actualValue, expectedValue);
	}

	@When("Admin clicks date picker_CM")
	public void admin_clicks_date_picker_cm() {
		addClasspage.classdate_picker();
	}

	@Then("Admin should see weekends dates are disabled to select_CM")
	public void admin_should_see_weekends_dates_are_disabled_to_select_cm() {

	}

	@When("Admin skips to add value in mandatory field and enter only the optional field_CM")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field_cm()
			throws InterruptedException {
		addClasspage.createClass_Optionalfield();
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color_CM")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color_cm() {
		String error_message = addClasspage.getEmptyfieldError();
		// softAssert.assertTrue(addClasspage.getEmptyfieldError().contains("reqired"));
		Assert.assertTrue(error_message.contains("required"));
	}

	@When("Admin enters invalid data {string} in all of the  fields in the form and clicks on save button_CM")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button_cm(String invalidValues)
			throws InterruptedException {
		addClasspage.createClass_sendkeys(invalidValues);
	}

	@Then("Admin gets error message and class is not created_CM")
	public void admin_gets_error_message_and_class_is_not_created_cm() {
		
	}

	@When("Admin clicks on save button without entering data_CM")
	public void admin_clicks_on_save_button_without_entering_data_cm() {
		addClasspage.Save_Class.click();
	}

	@Then("class wont be created and Admin gets error message_CM")
	public void class_wont_be_created_and_admin_gets_error_message_cm() {
		String error_message = addClasspage.getEmptyfieldError();
		assertTrue(error_message.contains("required"));
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Admin Details form_CM")
	public void admin_clicks_cancel_close_x_icon_on_admin_details_form_cm() {

	}

	@Then("Class Details popup window should be closed without saving_CM")
	public void class_details_popup_window_should_be_closed_without_saving_cm() {
		assertTrue(addClasspage.onClick());
	}

}
