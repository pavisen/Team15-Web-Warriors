@tag
Feature: Program Pagination 
  I want to use this template for my feature file

##@launching_website
Background: Launching application
    Given Admin Gives the valid LMS portal URL
    And Admin is in login Page
    When Admin enter valid credentials  and clicks login button 
    And Admin click on Program Module Link on Dashboard_1 

 @ProgramLastPageLinkValidation
   Scenario: validate last page link
   # Given Admin is on the Batch page
    When Admin clicks last page link on the data table 
    Then Admin should see the last page link with next page link disabled on the table
    
    @ProgramBackwardPageLinkValidation
    Scenario: validate the backward page link
    #Given Admin is on the Batch page
    When  Admin clicks backward page link on the data table
    Then Admin should see the previous page on the table
    
     @ProgramFirstPageLinkValidation
    Scenario: validate the first page link
     #Given Admin is on the Batch page
     When  Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table 