@ProgramAddFeature
Feature: Add Program feature
Background: Admin gives the correct LMS portal URL

Given Admin Gives the valid LMS portal URL
And Admin is in login Page
When Admin enter valid credentials  and clicks login button 
Feature: Add Program feature

@MenubarProgramAddNewProgram
    Scenario: Verify add New Program
        Given Admin is on Program module11
        When Admin clicks on New Program under the Program menu bar
        Then Admin should see pop up window for program
@verifyingTitilepopup
    Scenario: Verify title of the pop up window
        Given Admin is on Program module11
        When Admin clicks on New Program under the Program menu bar
        Then Admin should see window title as Program Details
@verifyingMandatoryFields
    Scenario: Verify mandatory fields with red * mark
        Given Admin is on Program module11
        When Admin clicks on New Program under the Program menu bar
        Then Admin should see red * mark beside mandatory field Name
@verifyingEmptyForm
    Scenario: Verify empty form submission
        Given Admin is on Program details form
        When Admin clicks save button without entering mandatory
        Then Admin gets message '<field> is required'
@verifyingCancelButton
    Scenario: Verify cancel button
        Given Admin is on Program details form
        When Admin clicks Cancel button
        Then Admin can see Program Details form disappears11
     @verifyingEnterProgramName   
    Scenario: Verify enter program name
        Given Admin is on program details form
        When Admin enters the Name in the text box as 'Program Name'
        Then Admin can see the text entered
@verifyingEnterDescription
    Scenario: Verify enter description
        Given Admin is on program details form
        When Admin enters the Description in text box 
        Then Admin can see the text entered in description box
@verifyingSelectStatus
    Scenario: Verify select Status
        Given Admin is on program details form
        When Admin selects the status of the program by clicking on the radio button (Active/InActive)
        Then Admin can see 'Active/Inactive' status selected
        
        @verifyingSavingDetails
    Scenario: Verify Admin is able to save the program details
        Given Admin is on program details form
        When Admin enter valid details for mandatory fields and Click on save button
        Then Admin gets message 'Successful Program created'
        @verifyingCancelDetails
    Scenario: Verify cancel program details
        Given Admin is on program details form
        When Admin Clicks on cancel button
        Then Admin can see program details form disappear11
        @verifyingAddedProgram
    Scenario: Verify added Program is created
        Given Admin is on Program module11
        When Admin searches with newly created Program Name
        Then Records of the newly created  Program Name is displayed and match the data entered

    @verifyingCloseButton
    Scenario: Verify close window with X
        Given Admin is on program details form
        When Admin Clicks on X button
        Then Admin can see program details form disappear11


