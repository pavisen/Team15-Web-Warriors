package stepDefiniton;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage;
import pageFactory.ProgramNavModule;

public class ProgramNavSteps {

    public WebDriver driver;
    LoginPage lg = new LoginPage();
    ProgramNavModule pnv = new ProgramNavModule();

    @Given("Admin is on dashboard page after Login")
    public void admin_is_on_dashboard_page_after_login() {
        pnv.validateDashboardPage();

    }

    @Given("Admin is on program page")
    public void admin_is_on_program_page() {

    }

    @When("Admin clicks Program on the navigation bar")
    public void admin_clicks_program_on_the_navigation_bar() {
        pnv.clickProgram();

    }

    @Then("Admin should be navigated to Program module")
    public void admin_should_be_navigated_to_program_module() {

    }

    @Then("Admin should not have any broken links for Program module")
    public void admin_should_not_have_any_broken_links_for_program_module() throws Throwable {
        pnv.checkForBrokenLinks();

    }

    @Then("Admin should see the heading LMS - Learning Management System")
    public void admin_should_see_the_heading_lms_learning_management_system() {
        pnv.lmsHeading();

    }

    @Then("Admin should see the module names as in order Home Program Batch Class Admin Assignment Attendance")
    public void admin_should_see_the_module_names_as_in_order_home_program_batch_class_admin_assignment_attendance() {
        pnv.validateModuleNames("Home Program Batch Class Admin Assignment Attendance");

    }

    @Then("Admin should see Logout in menu bar")
    public void admin_should_see_logout_in_menu_bar() {
        pnv.getLogout();

    }

    @Then("Admin should see sub menu in menu bar as Add New Program")
    public void admin_should_see_sub_menu_in_menu_bar_as_add_new_program() {
        pnv.AddNewProgram();

    }

    @Then("Admin should see the heading Manage Program")
    public void admin_should_see_the_heading_manage_program() {
        pnv.getManageProgramHeading();

    }

    @Then("Admin should able to see Program name, description, and status for each program")
    public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
        pnv.validateColheaders();

    }

    @Then("Admin should see a Delete button in left top is disabled")
    public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
        pnv.validatemultipleDeleteIcon();

    }

    @Then("Admin should see Search bar with text as Search")
    public void admin_should_see_search_bar_with_text_as_search() {

        pnv.searchBar();

    }

    @Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
    public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {

        pnv.validateDataTableHead();

    }

    @Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
    public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
        pnv.validateheaderCheckBoxUnchecked();

    }

    @Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
    public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
        pnv.validateAllCheckBoxesUnchecked();

    }

    @Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
    public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
        pnv.validateSortIcons();

    }

    @Then("Admin should see the Edit and Delete buttons on each row of the data table")
    public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
        pnv.validateEditDelIcons();

    }

    @Then("Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.x- starting record number on that page y-ending record number on that page z-Total number of records")
    public void admin_should_see_the_text_as_showing_x_to_y_of_z_entries_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records() throws InterruptedException {

        pnv.validatePaginationTextandIcons();
    }

    @Then("Admin should see the footer as In total there are z programs.z- Total number of records")
    public void admin_should_see_the_footer_as_in_total_there_are_z_programs_z_total_number_of_records() {
        pnv.getTotalProgramCountFromFooter();

    }
}
