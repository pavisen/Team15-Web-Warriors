package stepDefiniton;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Then;
import pageFactory.AddClassPage;
import pageFactory.LoginPage;
import pageFactory.ManageClassPage;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.Utility_Methods;

public class SD_ManageClass {

	AddClassPage addClasspage = new AddClassPage();
	ManageClassPage manageClasspage = new ManageClassPage();

	public WebDriver driver;
	WebDriverWait wait;
	LoginPage loginPage = new LoginPage();
	ExcelReader exelread = new ExcelReader();
	Utility_Methods util = new Utility_Methods();
	ConfigReader config = new ConfigReader();

	@Then("Admin should land on the Manage class page_CM")
	public void admin_should_land_on_the_manage_class_page_cm() {
		assertTrue(Utility_Methods.validator(manageClasspage.validatePage(), ConfigReader.dashboardclassurl()));
	}

	@Then("Admin should see the Title  {string} on top of the dashboard page_CM")
	public void admin_should_see_the_title_on_top_of_the_dashboard_page_cm(String String) {
		assertTrue(Utility_Methods.validator(manageClasspage.validateTitle(), "LMS-Learning Management System"));
	}

	@Then("Admin should see the {string} Header_CM")
	public void admin_should_see_the_header_cm(String string) throws InterruptedException {
		assertTrue(Utility_Methods.validator(manageClasspage.HeaderVaidation(), "Manage Class"));
	}

	@Then("Admin should see the datatable heading like  Batch Name ,class topic,class descrption,status,class Date,staff name,Edit\\/Delete_CM")
	public void admin_should_see_the_datatable_heading_like_batch_name_class_topic_class_descrption_status_class_date_staff_name_edit_delete_cm() {
		assertTrue(manageClasspage.headerTextValidation());
	}

	@Then("Admin should see the {string} and enabled pagination controls under the data table_CM")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table_cm(String string) {
		assertTrue(manageClasspage.paginationcontrol());
	}

	@Then("Admin should see the Sort icon of all the field in the datatable_CM")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable_cm() {
		manageClasspage.checkSortIcon();
	}

	@Then("Admin should see the Delete button under the Manage class page header_CM")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header_cm() {
		manageClasspage.deleteicon();
	}

	@Then("Admin should see Total no of classes in \\{int} below of the data table {string}_CM")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table__cm(String String) {
		util.isElementDisplayed(manageClasspage.PageFooter);
	}

}
