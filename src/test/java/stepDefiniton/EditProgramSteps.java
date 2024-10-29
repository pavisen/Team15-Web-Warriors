package stepDefiniton;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.EditProgramPage;
import pageFactory.LoginPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Utility_Methods;

public class EditProgramSteps {
	public WebDriver driver; 
	WebDriverWait wait;
   LoginPage lg=new LoginPage();
   EditProgramPage ep=new EditProgramPage();
   ExcelReader exelread= new ExcelReader();
   Utility_Methods um=new Utility_Methods();
   
	@Given("Admin click on Program Module Link on Dashboard")
	public void admin_click_on_program_module_link_on_dashboard() {
	     ep.admin_click_program_module_link_Dashboard();
	     
	}
	
	@Given("Admin is on Program module_1")
	public void admin_is_on_program_module_1() {
		ep.cancel_click();
	     ep.Verify_Manage_Program_Title();
	     
	}

	@Given("Admin is on Program module home page")
	public void admin_is_on_program_module_home_page() {
		ep.cancel_click();
	     ep.Verify_Manage_Program_Title();
	     
	}
	@Given("Admin is on Program module form for editing program name")
	public void admin_is_on_Program_module_form_for_editing_program_name() {
		ep.OpenEditProgramForm();
	     
	}
	@Given("Admin is on Program module to search program description")
	public void admin_is_on_Program_module_to_search_program_description() {
		ep.Verify_Manage_Program_Title();  
	}
	
	@Given("Admin is on Program module to search non exist program name")
	public void admin_is_on_Program_module_to_search_non_exist_program_name() {
		ep.Verify_Manage_Program_Title();  
	}
	
	@Given("Admin is on Program page to search program name for searchresult")
	public void admin_is_on_Program_page_to_search_program_name_for_searchresult() {
		ep.Verify_Manage_Program_Title();  
	}
	
	@Given("Admin enter particular programname in Searchbar to edit the name")
	public void admin_enter_particular_programname_in_Searchbar_to_edit_the_name() {
		ep.clear_searchfield();
		//ep.Search_Program_Description(); 
		ep.SearchBar_Write();
	}
	@Given("Admin enter partial program name in searchbar")
	public void admin_enter_partial_program_name_in_searchbar() {
		ep.clear_searchfield();
		ep.Search_Program_Description();   
	}
	
	@Given("Admin is on Program module form for editing program description")
	public void admin_is_on_Program_module_form_for_editing_program_description() throws Exception {
		//ep.cancel_click();
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click();
		//ep.OpenEditProgramForm();
	     
	}
	@Given("Admin is on Program module form for editing program status")
	public void admin_is_on_Program_module_form_for_editing_program_status() {
		//ep.cancel_click();
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     ep.EditButton_Click();
//		ep.OpenEditProgramForm();
	}
	@Given("Admin is on Program module form for verifying save and cancel close button")
	public void admin_is_on_Program_module_form_for_verifying_save_and_cancel_close_button() throws Exception {
		//ep.cancel_click();
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click();
		//ep.OpenEditProgramForm();
	}
	
	@Given("Admin is on Program module for searching deleted program name")
	public void admin_is_on_Program_module_for_searching_deleted_program_name() throws Exception {
		//ep.cancel_click();
		ep.clear_searchfield();
	     ep.SearchBar_Write();
		//ep.OpenEditProgramForm();
	}
	
	@Given("Admin is on Program module to search program name")
	public void admin_is_on_Program_module_to_search_program_name() {
	     ep.Verify_Manage_Program_Title();
	}
	@Given("Admin is on Program Details Form for editing program name_1")
	public void admin_is_on_program_details_form_for_editing_program_name_1() {
		ep.cancel_click();
	     ep.Verify_Manage_Program_Title();
	}
	

	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() throws Exception {
		ep.clear_searchfield();
		//ep.Search_Program_Description(); 
		ep.SearchBar_Write();
	     ep.admin_clicks_on_edit_option_for_particular_program(ConfigReader.SearchProgName());
	     
	}
	@When("Admin clicks on Edit option for particular program_1")
	public void admin_clicks_on_edit_option_for_particular_program_1() throws Exception {
	    ep.clear_searchfield(); 
	    ep.SearchBar_Write();
	    Thread.sleep(200);
	    ep.EditButton_Click();
	}
	@When("Admin clicks on Edit option for particular program_2")
	public void admin_clicks_on_edit_option_for_particular_program_2() throws Exception {
	    ep.clear_searchfield(); 
	    //driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
	    ep.SearchBar_Write();
	    Thread.sleep(200);
	    ep.EditButton_Click();
//		ep.admin_clicks_on_edit_option_for_particular_program();

	}
	@When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() throws Exception {
		ep.OpenEditProgramForm();
		ep.Edit_Prog_Name_Textbox();
		ep.Save_Button_Click();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() throws Exception {
//		ep.SearchBar_Write();
//		ep.SingleCheckBox_Click();
//		ep.EditButton_Click();
	     ep.admin_lands_on_program_details_form();
//	     WebElement Cancel=driver.findElement(By.xpath("//div//div[3]//button//span[@class='p-button-icon p-button-icon-left pi pi-times']"));
//	     Cancel.click();
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String string) {
	     
	     
	}

	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String string, String string2) {
	     
	     
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
	     ep.get_updatedProgName();
	     
	     
	}

	@When("Admin edits the description text and click on save button_EP1")
	public void admin_edits_the_description_text_and_click_on_save_button_EP1() throws Exception {
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click();	
		ep.Edit_ProDescription();
			ep.Save_Button_Click();
	     
	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
	     ep.get_updatedProgDescription();
	     
	}

	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() {
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     ep.EditButton_Click(); 
		ep.StatusChangeRadioButton();
	     ep.Save_Button_Click();
	     
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
	     
	     
	}

	@When("Admin click on save button")
	public void admin_click_on_save_button() throws Exception {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click(); 
		ep.Save_Button_Click();
	     
	}

	@Then("Admin Admin can see the updated program details")
	public void admin_admin_can_see_the_updated_program_details() {
	     
	     
	}

	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() throws Exception {
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click(); 
		ep.cancel_click();
	     
	}

	@Then("Admin can see the Program details form disappears")
	public void admin_can_see_the_program_details_form_disappears() {
	     
	     
	}

	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String string) {
	     
	     
	}

	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {
	     
	     
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
	     
	     
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
	     
	     
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		 ep.SearchBar_Write(); 
		ep.DeleteButton_Click();
	     
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
	     
	     
	}

	@Given("Admin is on Confirm deletion form")
	public void admin_is_on_confirm_deletion_form() {
	     ep.delete_Confirm_No();
	     ep.clear_searchfield();
	     ep.SearchBar_Write();
	     ep.DeleteButton_Click();
	     
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
	     
	     
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
	     
	     
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
	     
	     
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
	     
	     
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() {
	    ep.delete_Confirm_No(); 
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     ep.DeleteButton_Click();
	     
	}
	@Given("Admin is on Program module Home Page")
	public void admin_is_on_Program_module_Home_Page() {
		ep.Verify_Manage_Program_Title();
	     
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
	     
	     
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
	     
	     
	}

	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
	     ep.SearchBar_Write();
	     
	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	     
	     
	}

	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
	     ep.clear_searchfield();
	     ep.Search_Program_Description();
	     
	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() {
	     
	     
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
	     ep.clear_searchfield();
	     ep.non_exist_prog();
	     
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
	     ep.clear_searchfield();
	     ep.SearchBar_Write();   
	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
	     
	     
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
	     
	     
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
	     
	     
	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
	     
	     
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
	     
	     
	}

	@Then("Admin See the Program Status is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
	     
	     
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	     
	     
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
	     
	     
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
	     
	     
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	     
	     
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
	     
	     
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
	     
	     
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	     
	     
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
	     
	     
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	     
	     
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	     
	     
	}
	@Then("Admin should see window title as Program Details")
	public void admin_should_see_window_title_as_program_details() {
	     
	     
	}

	@Then("Admin should see red * mark beside mandatory field Name")
	public void admin_should_see_red_mark_beside_mandatory_field_name() {
	     
	     
	}

	@When("Admin searches with newly updated Program Name")
	public void admin_searches_with_newly_updated_program_name() {
	     ep.clear_searchfield();
	     ep.SearchBar_Write();
	     
	}

	@When("Admin Click on X button")
	public void admin_click_on_x_button() throws Exception {
		ep.clear_searchfield();
	     ep.SearchBar_Write();
	     Thread.sleep(3000);
	     ep.EditButton_Click(); 
		ep.CloseProgForm();
	     
	}

	@When("Admin clicks on Yes button")
	public void admin_clicks_on_yes_button() {
		ep.SearchBar_Write();
	     ep.DeleteButton_Click(); 
		ep.delete_Confirm_Yes();
	     
	}
	
	@When("Admin Click on X button on Delete Popup")
	public void admin_Click_on_X_button_on_Delete_Popup() {
		 ep.SearchBar_Write();
	     ep.DeleteButton_Click(); 
		ep.delete_Confirm_Close();
	     
	}

	@Then("Admin can see Successful Program Deleted message")
	public void admin_can_see_successful_program_deleted_message() {
	     
	     
	}

	@When("Admin Searches for Deleted Program name")
	public void admin_searches_for_deleted_program_name() {
		ep.SearchBar_Write();
	     
	}

	@When("Admin clicks on No button")
	public void admin_clicks_on_no_button() {
	     ep.SearchBar_Write();
	     ep.DeleteButton_Click(); 
		ep.delete_Confirm_No();
	     
	}

	@Then("Admin should see the Pagination has Next active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
	     
	     
	}

}
