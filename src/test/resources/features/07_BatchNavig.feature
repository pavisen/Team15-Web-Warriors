
Feature: Batch page navigation and its fields validation
  @Batch_tag1
   Scenario: Verify Admin Navigate to Batch page successfully
   Given Admin launches the browser
		When Admin gives the correct LMS portal URL
		When Admin enter valid credentials  and clicks login button
		Then Admin should land on dashboard page
    Given Admin is on the Dashboard Page
    When Admin Clicks on the Batch menu from the header
    Then Admin should see the "LMS" Title
    Then Admin should see the "Manage Batch" Heading
    Then Admin should see the disabled <Delete Icon> under the header
    Then Admin should see the enabled pagination controls under the data table
    Then Admin should see the edit icons in each row
   	Then Admin should see the delete icons in each row
    Then Admin should the checkbox in each row
    Then Admin should see the datatable headers "Batch Name Batch Description Batch Status No Of Classes Program Name Edit / Delete"
		Then Admin should see the checkbox in the datatable header row
 		Then Admin should see the sort icon next to all Datatable headers
 		Then Admin should see sub menu bar as <Add New Batch> after clicking Batch in menu 		
 #		Then Admin should see the text with total no of batches in footer text
     #Then Admin should see the Batch Details pop up window
 
  #@tag2
 #	Scenario Outline: Admin verifies all fields existence in Batch 
 #		Then Admin verifies all the "<Fields>" existence
 #		
 #	Examples:
 #		|Fields|
 #		|Batch Name|
 #		|Batch Description|
 #		|Batch Status|
 #		|No Of Classes|
 #		|Program Name|
 #		|Edit/Delete|
 


    
