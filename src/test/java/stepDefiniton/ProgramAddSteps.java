package stepDefiniton;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import pageFactory.ProgramAddModule;


public class ProgramAddSteps {
	public WebDriver driver;
	LoginPage lp = new LoginPage();
	ProgramAddModule pam = new ProgramAddModule();
	
	@Given("Admin is on Program module11")
	public void admin_is_on_program_module11() {


	}

	@When("Admin clicks on New Program under the Program menu bar")
	public void admin_clicks_on_new_program_under_the_program_menu_bar() {
		pam.clickProgram();
        pam.addNewProgram();

	}

	@Then("Admin should see pop up window for program")
	public void admin_should_see_pop_up_window_for_program() {
		
		
	}

	@Then("Admin should see window title as Program Details")
	public void admin_should_see_window_title_as_program_details() {
		
		
	}

	@Then("Admin should see red * mark beside mandatory field Name")
	public void admin_should_see_red_mark_beside_mandatory_field_name() {
		
		
	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() {
		
		
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
        pam.clickSaveButton();
		
		
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
		
		
	}

	// @When("Admin Clicks on cancel button")
	// public void admin_clicks_on_cancel_button() {
    //     pam.cancelButton();
		
		
	// }

	@Then("Admin can see Program Details form disappears11")
	public void admin_can_see_program_details_form_disappears11() {
		
		
	}

	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() {
        pam.inputName();

		
		
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		
		
	}

	@When("Admin enters the Description in text box")
	public void admin_enters_the_description_in_text_box() {
        pam.inputDescription();
		
		
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {
		
		
	}

//	@When("Admin selects the status of the program by clicking on the radio button {string}")
//	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String string) {
//        pam.activeRadioButton();
//		
//		
//	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String active) {
		pam.selectStatus();
		
		
	}

	@When("Admin enter valid details for mandatory fields and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button() {
        pam.clickSaveButton();
		
		
	}

//	@When("Admin Click on cancel button")
//	public void admin_click_on_cancel_button() {
//        pam.cancelButton();
//		
//		
//	}

	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created(String string) {
		
		
	}

	@Then("Records of the newly created  {string} is displayed and match the data entered")
	public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String string) {
		
		
	}

	// @When("Admin Click on {string} button")
	// public void admin_click_on_button(String string) {
		
		
	// }

}
