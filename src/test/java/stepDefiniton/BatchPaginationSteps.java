package stepDefiniton;

import static org.junit.Assert.assertFalse;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.BatchPaginationPage;

public class BatchPaginationSteps {

	BatchPaginationPage bpp= new BatchPaginationPage();
	
	@When("Admin clicks next page link on the data table")
	public void admin_clicks_next_page_link_on_the_data_table() throws InterruptedException {
	  
		 bpp.clicknextpagelink();
		}

	@Then("Admin should see the Next enabled link")
	public void admin_should_see_the_next_enabled_link() {
	   Assert.assertTrue(bpp.isNextLinkEnabled());
		
	 }

	
	@When("Admin clicks last page link on the data table")
	public void admin_clicks_last_page_link_on_the_data_table() throws InterruptedException {
	   bpp.clicklastpagelink();
		
	}

	@Then("Admin should see the last page link with next page link disabled on the table")
	public void admin_should_see_the_last_page_link_with_next_page_link_disabled_on_the_table() throws InterruptedException {
		 boolean[] results = bpp.nextandlastlinksdisabled();
            assertFalse("Double arrow right button should be disabled", results[0]);
	        assertFalse("Next button should be disabled", results[1]);
		}
	
	@When("Admin clicks backward page link on the data table")
	public void admin_clicks_backward_page_link_on_the_data_table() {
         bpp.clickbackwardpagelink();
	}

	@Then("Admin should see the previous page on the table")
	public void admin_should_see_the_previous_page_on_the_table() {
		Assert.assertTrue(bpp.isPreviousLinkEnabled());
	}
	
	
	@When("Admin clicks first page link on the data table")
	public void admin_clicks_first_page_link_on_the_data_table() throws InterruptedException {
	    bpp.clickfirstpagelink();
	}

	@Then("Admin should see the very first page on the data table")
	public void admin_should_see_the_very_first_page_on_the_data_table() throws InterruptedException {
	  
		 boolean[] results = bpp.backwardandpreviouslinksdisabled();
         assertFalse("Double arrow left button should be disabled", results[0]);
	     assertFalse("back button should be disabled", results[1]);
	}
	
	
	
	
	
	
	
	
	
}
