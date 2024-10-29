Feature: Add new Batch popup validaion
  @BatchPopuptag1
 	Scenario: Admin Verifies the popup window to Add details in Batch
 #	Given Admin launches the browser
#	When Admin gives the correct LMS portal URL
#	When Admin enter valid credentials  and clicks login button
#	Then Admin should land on dashboard page
    #When Admin Clicks on the Batch menu from the header
 	Given Admin is on the Batch page
 	When Admin clicks on <Add Details> submenu in Batch
  Then Admin should see the Batch Details pop up window
  Then The pop up should include the fields Batch Name,Number of classes and Description as text box,Program Name as drop down Status as radio button
  When Admin enters alphabets "abcd" in batch name suffix text box
  Then Admin should get error message below the text box of respective field as "This field accept only numbers and max 5 count."
  When Admin enters alphabets "abcd" in batch name prefix box
  Then Admin should see empty text box
  When Admin leaves blank one of the mandatory fields
  Then Admin should get a error message on the respective mandatory field
  When Admin clicks on the close icon
  Then batch details pop up closes navigates back sees heading "Manage Batch"
  
  Scenario:Validate input data only for mandatory fields
Given Admin is on the Batch page
 	When Admin clicks on <Add Details> submenu in Batch
 	When Admin enters the data only to the mandatory fiields and clicks save button
 	Then Admin should get a successful message
      #	Scenario Outline: Admin verifies all fields existence in Batch 
 #		Then Admin verifies all the "<Fields>" existence and its "<FieldType>"
 #		Examples:
 #		 		|Fields           |FieldType|
 #		 		|Program Name     |dropdown|
 #		 		|Batch Name       |textbox|
 #		 		|Description      |textbox|
 #		 		|Status           |radiobutton|
 #		 		|Number of Classes|textbox|
 #				|Save|  					|button|
 #		 			|Cancel|					|button|
    