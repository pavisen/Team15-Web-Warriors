@Delete_Class_Module
Feature: Delete Class Feature Validation

  Background: The Admin is logged on to the LMS portal
    Given Admin Gives the valid LMS portal URL
    When Admin enter valid credentials  and clicks login button 
    When Admin clicks "Class" on the navigation bar_CM
    When Admin clicks Deleteclass button_CM 
    
  @DeleteClass01
  Scenario: Validate row level delete icon_CM
  Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion_CM
  
  @DeleteClass02
  Scenario: Validate Close(X) icon on Confirm Deletion alert_CM
  When Admin clicks on close button_CM
  Then Admin can see the deletion alert disappears without any changes_CM
  
  
  @DeleteClass03
  Scenario: Click No on deletion window_CM
  When Admin clicks No option_CM 
  Then Admin can see the deletion alert disappears without deleting_CM
  
  @DeleteClass04
  Scenario: Click Yes on deletion window_CM
  Given Admin is on Confirm Deletion alert_CM
  When Admin clicks yes option_CM
  Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table_CM
 
  