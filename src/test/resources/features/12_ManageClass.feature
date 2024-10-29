@Manage_Class_Module @all
Feature: Add New Class Feature Validation

  Background: The Admin is logged on to the LMS portal
    Given Admin Gives the valid LMS portal URL
    When Admin enter valid credentials  and clicks login button 
    When Admin clicks "Class" on the navigation bar_CM
    
  @ManageClass01
  Scenario: Validate the URL of the Manage Class Page_CM
  Then Admin should land on the Manage class page_CM 
    
  @ManageClass02
  Scenario: Validate the Title in the Manage class page_CM
   Then Admin should see the Title  "LMS-Learning Management System" on top of the dashboard page_CM
  
  @ManageClass03
  Scenario: Validating the Header in the Manage class page_CM
    Then Admin should see the "Manage Class" Header_CM

  @ManageClass04
  Scenario: Validating the data table headers in the class page_CM
    Then Admin should see the datatable heading like  Batch Name ,class topic,class descrption,status,class Date,staff name,Edit/Delete_CM

  @ManageClass05
  Scenario: Validating the text and pagination icon in the classpage_CM
    Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table_CM

  @ManageClass06
  Scenario: Validate the sort icon of all the field in datatable_CM
    Then Admin should see the Sort icon of all the field in the datatable_CM
    
    @ManageClass07
  Scenario: Validating the Delete button under the Manage class_CM
    Then Admin should see the Delete button under the Manage class page header_CM
  
    @ManageClass08
  Scenario: Validate the total no of classes in manage class page_CM
    Then Admin should see Total no of classes in {int} below of the data table "In total there are z programs"_CM

 