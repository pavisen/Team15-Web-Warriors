
@tag
Feature: Title of your feature
  

 @BatchDeleteIconValidation
  Scenario: validate delete Icon on any row
    Given Admin is on the Batch page
    When  Admin clicks the delete Icon on any row in BM
    Then  Admin should see the confirm alert box with yes and no button in BM

   Scenario: Validate yes button on the confirm alert box
    Given Admin is on the Batch page
    When  Admin clicks on the delete icon and click yes buttton in BM
    Then  Admin should see the successfull message and the batch should be deleted in BM
  
    Scenario: validate no button on the confirm alert box
    Given Admin is on the Batch page
    When  Admin clicks on the delete icon and click no buttton in BM
    Then  Admin should see the alert box closed and the batch is not deleted in BM
    
    Scenario: validate close Icon on the alert box
    Given Admin is on the Batch page
    When Admin clicks on the delete icon and click on the close button in BM
    Then  Admin should see the alert box closed in BM
    
    Scenario: Validate single row delete with checkbox
    Given Admin is on the Batch page
    When Admin Admin clicks on the delete icon under the Manage batch header in BM
    Then  The respective row in the table should be deleted in BM
    
    Scenario: Validate multiple row delete with checkbox
    Given Admin is on the Batch page
     When Admin Admin clicks on the delete icon by selecting multiple rows under in BM
    Then  The respective row in the table should be deleted in BM
    
    Scenario: validate serach box functionality
    Given Admin is on the Batch page
    When Admin enters the batch name in the serach text box in BM
   Then  Admin should see the filtered batches in the data table in BM

