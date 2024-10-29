package stepDefiniton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.AddNewBatchPopupPage;
import pageFactory.Batch_navigationPage;
import utilities.Utility_Methods;

public class AddNewBatchPopupSteps
{
	AddNewBatchPopupPage AddNewBatch_PopupPageObj = new AddNewBatchPopupPage(DriverFactory.getDriver());
	Batch_navigationPage batch_naviObject = new Batch_navigationPage(DriverFactory.getDriver());

	 Utility_Methods util=new Utility_Methods();	 
	String actualErrorMsg;
	Boolean isPresent;
	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page()
	{
	}
	@When("Admin clicks on <Add Details> submenu in Batch")
	public void admin_clicks_on_add_details_submenu_in_batch()
	{
		AddNewBatch_PopupPageObj.clickaddNewSubMenu();
	}
	@Then("Admin should see the Batch Details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window()
	{
		assertTrue(AddNewBatch_PopupPageObj.verifyAddNewBatchPopup());
	}
	@Then("The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
		assertTrue(AddNewBatch_PopupPageObj.verifyAllFieldsInPopupDetails());
	}
	@When("Admin enters alphabets {string} in batch name suffix text box")
	public void admin_enters_alphabets_in_batch_name_suffix_text_box(String alphabets) 	
	{
		AddNewBatch_PopupPageObj.verifyBatchsuffixTxtBox(alphabets);
		actualErrorMsg=AddNewBatch_PopupPageObj.errorMsg();
	}
	@Then("Admin should get error message below the text box of respective field as {string}")
	public void admin_should_get_error_message_below_the_text_box_of_respective_field_as(String expectedErrorMsg) 
	{
		assertEquals(actualErrorMsg,expectedErrorMsg);
	}
	@When("Admin enters alphabets {string} in batch name prefix box")
	public void admin_enters_alphabets_in_batch_name_prefix_box(String alphabets) 
	{
		 isPresent = AddNewBatch_PopupPageObj.verifyBatchPrefixTxtBox(alphabets);
	}
	@Then("Admin should see empty text box")
	public void admin_should_see_empty_text_box() 
	{
		assertFalse(isPresent);
	}
	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields()  
	{
		AddNewBatch_PopupPageObj.verifyProgNameOnlyBlank();
	}
	@Then("Admin should get a error message on the respective mandatory field")
	public void admin_should_get_a_error_message_on_the_respective_mandatory_field() 
	{
	   assertEquals(AddNewBatch_PopupPageObj.verifyPrgmNmTxtBoxErrorMsg(),"Program Name is required.");
	}
	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() 
	{
		AddNewBatch_PopupPageObj.clickCloseButton();
	}
	@Then("batch details pop up closes navigates back sees heading {string}")
	public void batch_details_pop_up_closes_navigates_back_sees_heading(String batchHeading) 
	{
		assertEquals(batch_naviObject.getBatchPageHeadingText(),batchHeading);
	}
}