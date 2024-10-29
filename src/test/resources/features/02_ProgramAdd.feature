@ProgramFeature
Feature: Add Program feature

Background: Admin gives the correct LMS portal URL

    Given Admin Gives the valid LMS portal URL
    And Admin is in login Page
    When Admin enter valid credentials  and clicks login button 
    And Admin click on Program Module Link on Dashboard_1
    Then Admin clicks on New Program under the Program menu bar

		@MenubarProgramAddNewProgram
    Scenario: Verify add New Program with title and mandatory field
        When Admin is on Program module11
        Then Admin should see pop up window with title as Program Details
        And Admin should see red * mark beside mandatory field Name1

		@verifyingEmptyForm
    Scenario: Verify empty form submission
        Given Admin is on program details form
        When Admin clicks save button without entering mandatory
        Then Admin gets the error message '<field> is required'
        
     @verifyingCancelButton
     Scenario: Verify cancel button
         Given Admin is on program details form
         When Admin clicks on cancel button
         Then Admin can see Program Details form disappears11
         
     @verifyingCloseButton
     Scenario: Verify close window with X
         Given Admin is on program details form
         When Admin Clicks on X button
         Then Admin can see Program Details form disappears11  

     @verifyingEnterProgramName  
     Scenario: Verify program name, description input radio button and click save
         Given Admin is on program details form
         When Admin enters the program name, the description in the form
         And Select the inactive and active options
         Then Admin can see the text for name, description, active button and click save
         And Program details saved successfully



