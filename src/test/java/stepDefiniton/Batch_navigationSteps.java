package stepDefiniton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageFactory.Batch_navigationPage;
import utilities.Utility_Methods;

public class Batch_navigationSteps 
{ 
	//WebDriver driver;
	Batch_navigationPage batch_naviObject = new Batch_navigationPage(DriverFactory.getDriver());
	 Utility_Methods util=new Utility_Methods();	 
	@Given("Admin is on the Dashboard Page")
	public void admin_is_on_the_dashboard_page()
	{
	}
	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() throws InterruptedException 
	{
		batch_naviObject.clickBatchInMenuBar();
	}
	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String title)
	{
		assertEquals(title, util.getPageTitle());
	}
	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String managebatchHeading)
	{
		assertEquals(managebatchHeading, batch_naviObject.getBatchPageHeadingText());
	}
	@Then("Admin should see the disabled <Delete Icon> under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() 
	{
		assertEquals(batch_naviObject.validateDeleteIcon(), false);
	}
	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() 
	{
		assertEquals(batch_naviObject.validatePagination(), true);
	}
	@Then("Admin should see the edit icons in each row")
	public void admin_should_see_the_edit_icons_in_each_row() 
	{
		boolean allEditIconsEnabled = batch_naviObject.ValidateEditIconsEnabled();
        assertTrue(allEditIconsEnabled);
	}
	@Then("Admin should see the delete icons in each row")
	public void admin_should_see_the_delete_icons_in_each_row() 
	{
		boolean allDeleteIconsEnabled = batch_naviObject.ValidateDeleteIconsEnabled();
        assertTrue(allDeleteIconsEnabled);
	}
	@Then("Admin should the checkbox in each row")
	public void admin_should_the_checkbox_in_each_row() 
	{
		 assertTrue(batch_naviObject.verifycheckBoxes());
	}
	@Then("Admin should see the datatable headers {string}")
	public void admin_should_see_the_datatable_headers(String ExpectedHeader) 
	{
		String actualheader = batch_naviObject.getTableHead();
		//System.out.print("actual ***" +actualheader);
		assertEquals(actualheader,ExpectedHeader);
	}
	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() 
	{
		 assertTrue(batch_naviObject.verifycheckBoxInHeader());

	}
	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() 
	{
		assertTrue(batch_naviObject.verifyAllSortIcons());
	}
	@Then("Admin should see sub menu bar as <Add New Batch> after clicking Batch in menu")
	public void admin_should_see_sub_menu_bar_as_add_new_batch_after_clicking_batch_in_menu() throws InterruptedException 
	{
		assertTrue(batch_naviObject.verifyaddNewBatchAsSubMenu());
	}
	@Then("Admin should see the text with total no of batches in footer text")
	public void admin_should_see_the_text_with_total_no_of_batches_in_footer_text()
	{
		String count = batch_naviObject.getTotalProgramCountFromFooter();
		assertEquals(count,"49");
	}
	
}
