package stepDefiniton;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;


import static org.junit.Assert.assertTrue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageFactory.BatchDeletePage;
import pageFactory.BatchEditPage;
import pageFactory.LoginPage;


public class BatchEditSteps {

	 LoginPage lp = new LoginPage();
	 BatchEditPage bep= new BatchEditPage();
	 BatchDeletePage bdp= new BatchDeletePage();
	
	
	@Given("Admin is on the Batch page")
	public void admin_is_on_the_batch_page() throws InterruptedException {
		lp.getbaseurl();
		lp.login_usingKeyBoardAction();
		Thread.sleep(1000);
	    bep.Clickbatch();
	    Thread.sleep(1000);
	  
	  
	 	}

	
	@When("Admin clicks the edit icon")
	public void admin_clicks_the_edit_icon() throws InterruptedException {
	     bep.ClickbatchEditIcon();
		
	}

	
	@Then("Admin should see the Batch details pop up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
	     
      assertEquals(bep.checkingpopupwindow(),"Batch Details");
	  
	}

	
	@Then("Admin should see Program name value field is disabled for editing")
	public void admin_should_see_program_name_value_field_is_disabled_for_editing() {
	 
		assertFalse(bep.ProgNameDisable());
	}

	
	@Then("Admin should see batch name value field is disabled for editing")
	public void admin_should_see_batch_name_value_field_is_disabled_for_editing() {
	   
		assertFalse(bep.BatchNameDisable());
	}
	
	
	@Given("Admin is on the Batch Details Page")
	public void admin_is_on_the_batch_details_page() throws InterruptedException {
		admin_is_on_the_batch_page();
		admin_clicks_the_edit_icon();
	  
	}

	@When("Admin Updates any fields with invalid data and click save button")
	public void admin_updates_any_fields_with_invalid_data_and_click_save_button() throws InterruptedException {
	   bep.enterinvalidvalues();
	   bep.clicksavebutton();
	 
	}

	@Then("Admin should get a error message under the respective field")
	public void admin_should_get_a_error_message_under_the_respective_field() {
		 assertTrue(bep.errormessage().contains("This field should start with an alphabet"));
	   
	}

	@When("Admin enters the valid data to all the mandatory fields and click save button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_save_button() throws InterruptedException {
	   bep.enterallmandatoryfields();
	   bep.clicksavebutton();
	}

	@Then("Admin should get a succesesful message for editing the batch")
	public void admin_should_get_a_succesesful_message_for_editing_the_batch() throws InterruptedException {
		String[] results=bep.sucessmessgetext();
		assertEquals(results[0],"Successful");
		assertEquals(results[1],"batch Updated");
	}

	@When("Admin enters the valid data to all the mandatory fields and click cancel button")
	public void admin_enters_the_valid_data_to_all_the_mandatory_fields_and_click_cancel_button() throws InterruptedException {
		bep.enterallmandatoryfields();
		bep.clickcancelbutton();
		
	}

	@Then("Admin can see the batch details popup closes without editing the batch")
	public void admin_can_see_the_batch_details_popup_closes_without_editing_the_batch() {
		  assertEquals(bep.Managebatchpage(),"Manage Batch");
	}

	
	
	
	
	
	
}
