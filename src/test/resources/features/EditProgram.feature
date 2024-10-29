
@tag
Feature: Edit, Delete, Sort, Pagination Program Feature file
  I want to use this template for my feature file

##@launching_website
Background: Launching application
Given Admin launch the browser_1
When Admin gives the correct LMS portal URL_1
And Admin click on Program Module Link on Dashboard_1
Then Admin should land on dashboard page_1

#################SearchBar Test Scenarios####################		
@Verify_SearchResult_ProgramName
		Scenario: Verify Admin is able to search results found for program name  
		#Given Admin click on Program Module Link on Dashboard
		When Admin enter the program to search By program name
		Then Admin should able to see Program name, description, and status for searched program name	
		
@Verify_SearchResult_ProgramDescription
		Scenario: Verify Admin is able to search results found for program description  
		##Given Admin is on Program module to search program description
		When Admin enter the program to search By program description
		Then Admin should able to see Program name, description, and status for searched program description
		
@Verify_SearchResult_NotFound
		Scenario: Verify Admin is able to search results not found  
		#Given Admin is on Program module to search non exist program name
		When Admin enter the program to search By program name that does not exist
		Then There should be zero results.	
		
@Verify_SearchResult_Partial_ProgramName
		Scenario: Verify Admin is able to search with partial program name  
		#Given Admin is on Program page to search program name for searchresult
		When Admin enter the program to search By partial name of program
		Then Admin should able to see Program name, description, and status for searched program name


######Edit Program Test Scenarios#########################
@Verify_Click_Edit
Scenario: Verify Edit option

    #Given Admin enter particular programname in Searchbar to edit the name
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

@Verify_Title_Popup
Scenario: Verify title of the pop up window
    #Given Admin is on Program module_1
    When Admin clicks on Edit option for particular program_1
    Then Admin should see window title as Program Details
    
@Verify_Mandetory_Field
Scenario: Verify mandatory fields with red * mark 
    #Given Admin is on Program module home page
    When Admin clicks on Edit option for particular program_2
    Then Admin should see red * mark beside mandatory field Name 
    
@Verify_editProgram_Name
		Scenario: Verify edit Program Name
		#Given Admin is on Program module form for editing program name
		When Admin edits the program name and click on save button
		Then Updated program name is seen by the Admin 
    
@Verify_editDescription
		Scenario: Verify edit Description
		#Given Admin is on Program module form for editing program description
		When Admin edits the description text and click on save button_EP1
		Then Admin can see the description is updated 
    
@Verify_editStatus
		Scenario: Verify edit Status
		#Given Admin is on Program module form for editing program status
		When Admin can change the status of the program and click on save button
		Then Status updated can be viewed by the Admin
    
@Verify_Click_Save
		Scenario: Verify Admin is able to click Save
		#Given Admin is on Program module form for verifying save and cancel close button
		When Admin click on save button
		Then Admin Admin can see the updated program details 
    
@Verify_Click_Cancel
		Scenario: Verify Admin is able to click Cancel
		#Given Admin is on Program module form for verifying save and cancel close button
		When Admin click on cancel button
		Then Admin can see the Program details form disappears 
    
@Verify_Edited_ProgramDetails
		Scenario: Verify edited Program details
		#Given Admin is on Program module to search program name
		When Admin searches with newly updated Program Name
		Then Admin verifies that the details are correctly updated. 
    
@Verify_CloseWindow
		Scenario: Verify close the window with X 
		#Given Admin is on Program module form for verifying save and cancel close button
		When Admin Click on X button
		Then Admin can see program details form disappear 
			
	##################Delete Program###################
@Verify_Delete_Click_No
		Scenario: Verify Admin is able to click No 
		#Given Admin is on Program Confirm Deletion Page after selecting a program to delete
		When Admin clicks on No button
		Then Admin can see Confirmation form disappears		
		
		
@Verify_Delete_Popup
		Scenario: Verify delete feature 
		#Given Admin is on Program module for searching deleted program name
		When Admin clicks on delete button for a program
		Then Admin will get confirm deletion popup
		
@Verify_Delete_Click_Close
		Scenario: Verify Admin is able to close the window with X  
		#Given Admin is on Program Confirm Deletion Page after selecting a program to delete
		When Admin Click on X button on Delete Popup
		Then Admin can see Confirm Deletion form disappear		
		
@Verify_Delete_Click_Yes
		Scenario: Verify Admin is able to click Yes 
		#Given Admin is on Confirm deletion form
		When Admin clicks on Yes button
		Then Admin can see Successful Program Deleted message

@Verify_search_Deleted_Program
		Scenario: Verify Admin is able to search deleted program 
		#Given Admin is on Program module for searching deleted program name
		When Admin Searches for Deleted Program name
		Then There should be zero results.
	
##############Sorting Test Scenarios#################################
#@Verify_Sorting_ProgramName
#		Scenario: Verify sorting of  Program name in Ascending order/Descending order  
#		Given Admin is on Program module Home Page
#		When Admin clicks on Arrow next to program Name
#		Then Admin See the Program Name is sorted in Ascending order/Descending order
#		
#@Verify_Sorting_ProgramDescription
#		Scenario: Verify sorting of  Program Description in Ascending order/Descending order  
#		Given Admin is on Program module
#		When Admin clicks on Arrow next to Program Description
#		Then Admin See the program Description is sorted in Ascending order/Descending order														 		
#
#@Verify_Sorting_ProgramStatus
#		Scenario: Verify sorting of Program status in Ascending order/Descending order  
#		Given Admin is on Program module
#		When Admin clicks on Arrow next to Program status
#		Then Admin See the Program Status is sorted in Ascending order/Descending order
#
#############Pagination######################
#@Verify_Click_NextPage_Link
#		Scenario: Verify Admin is able to click Next page link 
#		Given Admin is on Program module
#		When Admin clicks Next page link on the program table
#		Then Admin should see the Pagination has Next active link
#		
#@Verify_Click_LastPage_Link
#		Scenario: Verify Admin is able to click  Last page link
#		Given Admin is on Program module
#		When Admin clicks Last page link
#		Then Admin should see the last page record on the table with Next page link are disabled
#		
#@Verify_Click_PreviousPage_Link
#		Scenario: Verify Admin is able to click Previous page link
#		Given Admin is on last page of Program module table
#		When Admin clicks Previous page link
#		Then Admin should see the previous page record on the table with pagination has previous page link
#
#@Verify_Click_FirstPage_Link
#		Scenario: Verify Admin is able to click  First page link
#		Given Admin is on Previous Program page
#		When Admin clicks First page link
#		Then Admin should see the very first page record on the table with Previous page link are disabled
#		

