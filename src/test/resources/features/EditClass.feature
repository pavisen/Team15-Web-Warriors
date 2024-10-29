@Edit_Class_Module
Feature: Edit Class Feature Validation

  Background: The Admin is logged on to the LMS portal
    Given Admin Gives the valid LMS portal URL
    When Admin enter valid credentials  and clicks login button 
    When Admin clicks "Class" on the navigation bar_CM
    When Admin clicks "+ Edit Class" button_CM in the dahboard
  
   # Then Admin should be able to see a new pop up with Class details
         
  @EditClass01
  Scenario: Validate the URL of the Manage Class Page_CM
  Then Admin should land on the Manage class page_CM 
  
  @EditClass02
  Scenario: Check disabled fields_CM
  Then new pop up with class details appears_CM
  Then Admin should see batch name field is disabled_CM
  Then Admin should see class topic field is disabled_CM
  
  @EditClass03
  Scenario:Check if the fields are updated with valid data_CM
  When Update the fields with valid data and click save_CM
  Then Admin gets message "class details updated Successfully " and see the updated values in data table_CM
  
  @EditClass04
  Scenario: Check if the fields are updated with invalid values_CM
  When Update the fields with invalid values and click save_CM
  Then Admin should get Error message_CM
  
  @EditClass05
  Scenario: Check if the mandatory fields are updated with valid data_CM
  When Update the mandatory fields with valid values and click save_CM
  Then Admin gets message "Class details updated Successfully " and see the updated values in data table_CM
  
   @EditClass06
   Scenario: Check if the optional fields are updated with valid data_CM
  When Update the optional fields with valid values and click save_CM
  Then Admin gets message "Class details updated Successfully " and see the updated values in data table_CM
  
   @EditClass07
   Scenario:Validate invalid values in the text fields_CM
  When Admin enters only numbers or special char in the text fields_CM
  Then Admin should get Error message_CM
  
  @EditClass08
  Scenario: Validate invalid values in the text fields_CM
  When Admin clicks Cancel button on edit popup_CM
  Then Admin can see the class details popup disappears and can see nothing changed for particular Class_CM
  
  
  
  
  
  
  
  