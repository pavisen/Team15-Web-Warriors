@ProgramAddFeature
Feature: Add Program feature

    # Navigation
    @navigatingToProgram
    Scenario: Verify that Admin is able to navigate to Program module
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then  Admin should be navigated to Program module
   # MenuBar
    @verifyingProgramLinks
    Scenario: Verify any broken links on program page
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should not have any broken links for Program module
   
    @verifyingHeading
    Scenario: Verify heading in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the heading "LMS - Learning Management System"
    @verifyingModuleNames
    Scenario:Verify other module's name displayed in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the module names as in order "Home Program Batch Class Admin Assignment Attendance"
    @verifyingLogout
    Scenario: Verify Logout displayed in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see Logout in menu bar
    @verifyingSubMenu
    Scenario: Verify sub menu displayed in program menu bar
        Given Admin is on program page
        When Admin clicks "Program" on the navigation bar
        Then Admin should see sub menu in menu bar as "Add New Program"

   # ManageProgramPageValidation
    @verifyingHeading
    Scenario: Verify heading in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the heading "Manage Program"
    @verifyingViewDetails
    Scenario: Verify view details of programs
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should able to see Program name, description, and status for each program
    @verifyingMultipleDeleteButton
    Scenario: Verify the Multiple Delete button state
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see a Delete button in left top is disabled
    @verifyingSearchButton
    Scenario: Verify the Search button
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see Search bar with text as "Search..."
    @verifyingColumnHeader
    Scenario: Verify column header name of data table
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
    @verifyingCheckbox
    Scenario: Verify checkbox default state beside Program Name column header
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see checkbox default state as unchecked beside Program Name column header as
@verifyingCheckboxesbeside
    Scenario: Verify checkboxes default state beside each Program names in the data table
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see check box default state as unchecked on the left side in all rows against program name
@verifyingSortIcon
    Scenario: Verify Sort icon in manage program	Admin is on dashboard page after Login
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
@verifyingEditAndDeleteicon
       Scenario: Verify edit and delete icon in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the Edit and Delete buttons on each row of the data table
@verifyingPaginationIcons
    Scenario: Verify pagination icons below data table in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the text as "Showing x to y of z entries"along with Pagination icon below the table.x- starting record number on that page y-ending record number on that page z-Total number of records"

@verifyingFooterMessage
    Scenario: Verify footer message in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks "Program" on the navigation bar
        Then Admin should see the footer as "In total there are z programs".z- Total number of records"

    @MenubarProgramAddNewProgram
    Scenario: Verify add New Program
        Given Admin is on Program module
        When Admin clicks on "New Program" under the "Program" menu bar
        Then Admin should see pop up window for program
@verifyingTitilepopup
    Scenario: Verify title of the pop up window
        Given Admin is on Program module
        When Admin clicks on "New Program" under the "Program" menu bar
        Then Admin should see window title as "Program Details"
@verifyingMandatoryFields
    Scenario: Verify mandatory fields with red "*" mark
        Given Admin is on Program module
        When Admin clicks on "New Program" under the "Program" menu bar
        Then Admin should see red "*" mark beside mandatory field "Name"
@verifyingEmptyForm
    Scenario: Verify empty form submission
        Given Admin is on Program details form
        When Admin clicks save button without entering mandatory
        Then Admin gets message '<field> is required'
@verifyingCancelButton
    Scenario: Verify cancel button
        Given Admin is on Program details form
        When Admin clicks Cancel button
        Then Admin can see Program Details form disappears
     @verifyingEnterProgramName   
    Scenario: Verify enter program name
        Given Admin is on program details form
        When Admin enters the Name in the text box
        Then Admin can see the text entered
@verifyingEnterDescription
    Scenario: Verify enter description
        Given Admin is on program details form
        When Admin enters the Description in text box
        Then Admin can see the text entered in description box
@verifyingSelectStatus
    Scenario: Verify select Status
        Given Admin is on program details form
        When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
        Then Admin can see 'Active/Inactive' status selected
        
        @verifyingSavingDetails
    Scenario: Verify Admin is able to save the program details
        Given Admin is on program details form
        When Admin enter valid details for mandatory fields and Click on save button
        Then Admin gets message 'Successful Program created'
        @verifyingCancelDetails
    Scenario: Verify cancel program details
        Given Admin is on program details form
        When Admin Click on cancel button
        Then Admin can see program details form disappear
        @verifyingAddedProgram
    Scenario: Verify added Program is created
        Given Admin is on Program module
        When Admin searches with newly created "Program Name"
        Then Records of the newly created  "Program Name" is displayed and match the data entered

    @verifyingCloseButton
    Scenario: Verify close window with "X"
        Given Admin is on program details form
        When Admin Click on "X" button
        Then Admin can see program details form disappear


