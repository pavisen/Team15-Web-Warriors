package stepDefiniton;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.BatchDeletePage;

public class BatchDeleteSteps {

	BatchDeletePage bdp= new BatchDeletePage();
	
	
	@When("Admin clicks the delete Icon on any row in BM")
	public void admin_clicks_the_delete_icon_on_any_row_in_bm() throws InterruptedException {
    	
	  bdp.ClickbatchDeleteIcon();
	}

	@Then("Admin should see the confirm alert box with yes and no button in BM")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button_in_bm() throws InterruptedException {
	
	 assertEquals(bdp.confirmalerttext(),"Confirm");
	 assertTrue(bdp.Nobutton.isDisplayed());
	 assertTrue(bdp.yesbutton.isDisplayed());
		 
	}

	@When("Admin clicks on the delete icon and click yes buttton in BM")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton_in_bm() throws InterruptedException {
		bdp.clickDelandYes();
		
	}

	@Then("Admin should see the successfull message and the batch should be deleted in BM")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted_in_bm() {
		
		
		 String[] results=bdp.sucessmessgetext();
		 assertEquals(results[0],"Successful");
		 assertEquals(results[1],"batch Deleted");
		 
		 bdp.IsbatchNamedeleted();
			 
	}

	@When("Admin clicks on the delete icon and click no buttton in BM")
	public void admin_clicks_on_the_delete_icon_and_click_no_buttton_in_bm() throws InterruptedException {
	
	      bdp.clickDelandNo();
	
	}


    @Then("Admin should see the alert box closed and the batch is not deleted in BM")
      public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted_in_bm() {
         bdp.IsbatchNamedeleted();
		
	}


     @When("Admin clicks on the delete icon and click on the close button in BM")
     public void admin_clicks_on_the_delete_icon_and_click_on_the_close_button_in_bm() throws InterruptedException {
	   bdp.ClickbatchDeleteIcon();
	   bdp.clickClosebutton();
	}



     @Then("Admin should see the alert box closed in BM")
     public void admin_should_see_the_alert_box_closed_in_bm() {
		assertEquals(bdp.Managebatchpage(),"Manage Batch");
	}
	
	
     @When("Admin Admin clicks on the delete icon under the Manage batch header in BM")
     public void admin_admin_clicks_on_the_delete_icon_under_the_manage_batch_header_in_bm() {
		bdp.clicksinglecheckbox();
		bdp.clickdeleteiconmanagebatch();
	    
	}
	

     @When("Admin Admin clicks on the delete icon by selecting multiple rows under in BM")
     public void admin_admin_clicks_on_the_delete_icon_by_selecting_multiple_rows_under_in_bm() {
         bdp.clickmultiplecheckbox();
         bdp.clickdeleteiconmanagebatch();
       }


     @Then("The respective row in the table should be deleted in BM")
     public void the_respective_row_in_the_table_should_be_deleted_in_bm() {
		}
	
	
     @When("Admin enters the batch name in the serach text box in BM")
     public void admin_enters_the_batch_name_in_the_serach_text_box_in_bm() {
	  // bdp.entertextinsearchbox();
	}

	
     @Then("Admin should see the filtered batches in the data table in BM")
     public void admin_should_see_the_filtered_batches_in_the_data_table_in_bm() {
		 assertTrue(bdp.searchlist().contains("micro"));
	  
	}

	
	
	
	
	
	
	
	
	
}
