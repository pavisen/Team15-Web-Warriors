package stepDefiniton;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import pageFactory.ProgramAddModule;

public class ProgramAddSteps {
	public WebDriver driver;
	LoginPage lp = new LoginPage();
	ProgramAddModule pam = new ProgramAddModule();

	@When("Admin click on Program Module Link on Dashboard_{int}")
	public void admin_click_on_program_module_link_on_dashboard(Integer int1) {
		pam.admin_click_program_module_link_Dashboard_1();
	}



	@When("Admin clicks on New Program under the Program menu bar")
	public void admin_clicks_on_new_program_under_the_program_menu_bar() throws InterruptedException {

		pam.addNewProgram();

	}

	@Then("Admin should see pop up window with title as Program Details")
	public void admin_should_see_pop_up_window_with_title_as_program_details() {
		pam.assertProgramDetailsTitle();
	}

	@Then("Admin should see pop up window for program")
	public void admin_should_see_pop_up_window_for_program() {

	}

	@Given("Admin is on program details form")
	public void admin_is_on_program_details_form() {

	}

	@Then("Admin should see red * mark beside mandatory field Name1")
	public void admin_should_see_red_mark_beside_mandatory_field_name() {

		pam.assertAstriskMandatoryFields();

	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		pam.clickSaveButton();

	}

	@Then("Admin gets the error message {string}")
	public void admin_gets_the_error_message(String string) {
		pam.assertErrorMessage();
	}

	@Then("Admin can see Program Details form disappears11")
	public void admin_can_see_program_details_form_disappears11() {
		pam.isAddProgramDisappeared();
	}

	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
		pam.enterInputName();

	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		pam.getinputName();

	}

	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
		pam.enterInputDescription();

	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		pam.getInputDescription();

	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String active) {
		pam.getActiveStatus();

	}

	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button() {
		pam.enterInputDescription();
		pam.clickSaveButton();

	}

	@Then("Program details saved successfully")
	public void admin_gets_message( ) {
		pam.getSuccessMessage();
	}

	@When("Admin clicks on cancel button")
	public void admin_click_on_cancel_button() throws InterruptedException {
		pam.clickCancelButton();
		   Thread.sleep(500);
	}


	@When("Admin Clicks on X button")
	public void admin_clicks_on_x_button() {
		pam.clickXButton();
     
	}

	@When("Admin enters the program name, the description in the form")
	public void admin_enters_the_program_name_in_the_form() {
		pam.enterInputName();
		pam.enterInputDescription();
	}

	@When("Select the inactive and active options")
	public void select_the_active_and_inactive_option() {
		pam.selectInactiveStatus();
		Assert.assertEquals(pam.getInactiveStatus(),"Inactive");
		pam.selectActiveStatus();
		Assert.assertEquals(pam.getActiveStatus(),"Active");
	}

	@Then("Admin can see the text for name, description, active button and click save")
	public void admin_can_see_the_text_as_entered_for_name_and_description() {
		pam.validateInput();
		pam.clickSaveButton();
	}
	

	
}
