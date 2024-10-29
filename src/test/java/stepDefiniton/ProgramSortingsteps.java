package stepDefiniton;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageFactory.ProgramSortingPage;

public class ProgramSortingsteps {
	
	ProgramSortingPage programpage= new ProgramSortingPage();
	
	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
		programpage.programclick();
	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() throws InterruptedException {
	  programpage.ProgramNameSortClick();
	}

	@Then("Admin See the Program Name is sorted in {string} Ascending or Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_or_descending_order(String SortingOrder) {
		Assert.assertEquals(programpage.verifyingProgrameNameSorting(SortingOrder), true);
	}
	
	
	// Verify sorting of  Program Description in  Descending order
	
	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() throws InterruptedException {
		programpage.ProgramDescriptionSortClick();
	}	
	
	
	@Then("Admin See the program Description {string} Ascending or Descending order")
	public void admin_see_the_program_description_ascending_or_descending_order(String SortingOrder) {
		Assert.assertEquals(programpage.verifyingProgramDescriptionSorting(SortingOrder),true);
	}
	

	
	// Verify sorting of   Program status in Ascending order/Descending order
	
	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() throws InterruptedException {
		programpage.ProgramStatusSortClick();
	}

	@Then("Use See the  Program Status is sorted in {string} Ascending order or Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_or_descending_order(String SortingOrder) {
		Assert.assertEquals(programpage.verifyingProgramDescriptionSorting(SortingOrder),true);
	}

}
