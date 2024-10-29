  
  
  @tag
  Feature: Title of your feature
  
    
   @BatchNextPagelinkValidation
   Scenario: Validate next page link
    Given Admin is on the Batch page
    When  Admin clicks next page link on the data table
    Then  Admin should see the Next enabled link 
    
    
    @BatchLastPageLinkValidation
   Scenario: validate last page link
    Given Admin is on the Batch page
    When Admin clicks last page link on the data table 
    Then Admin should see the last page link with next page link disabled on the table 
    
    @BatchBackwardPageLinkValidation
    Scenario: validate the backward page link
    Given Admin is on the Batch page
    When  Admin clicks backward page link on the data table
    Then Admin should see the previous page on the table 
    
     @BatchFirstPageLinkValidation
    Scenario: validate the first page link
     Given Admin is on the Batch page
     When  Admin clicks first page link on the data table
    Then Admin should see the very first page on the data table   
    
    
    
  
