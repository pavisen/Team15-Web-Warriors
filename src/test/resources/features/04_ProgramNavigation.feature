@ProgramFeature
Feature: Add Program Navigation feature
Background: Admin gives the correct LMS portal URL

Given Admin Gives the valid LMS portal URL
And Admin is in login Page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page  

    # Navigation
    @navigatingToProgram
    Scenario: Verify that Admin is able to navigate to Program module
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then  Admin should be navigated to Program module
        
   # MenuBar
    @verifyingProgramLinks
    Scenario: Verify any broken links on program page
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should not have any broken links for Program module
   
    @verifyingHeading
    Scenario: Verify heading in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the heading LMS - Learning Management System
    @verifyingModuleNames
    Scenario:Verify other module's name displayed in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the module names as in order Home Program Batch Class Admin Assignment Attendance
    @verifyingLogout
    Scenario: Verify Logout displayed in menu bar
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see Logout in menu bar
    @verifyingSubMenu
    Scenario: Verify sub menu displayed in program menu bar
        Given Admin is on program page
        When Admin clicks Program on the navigation bar
        Then Admin should see sub menu in menu bar as Add New Program

   # ManageProgramPageValidation
    @verifyingHeading
    Scenario: Verify heading in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the heading Manage Program
    @verifyingViewDetails
    Scenario: Verify view details of programs
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should able to see Program name, description, and status for each program
    @verifyingMultipleDeleteButton
    Scenario: Verify the Multiple Delete button state
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see a Delete button in left top is disabled
    @verifyingSearchButton
    Scenario: Verify the Search button
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see Search bar with text as Search
    @verifyingColumnHeader
    Scenario: Verify column header name of data table
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete
    @verifyingCheckbox
    Scenario: Verify checkbox default state beside Program Name column header
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see checkbox default state as unchecked beside Program Name column header as
@verifyingCheckboxesbeside
    Scenario: Verify checkboxes default state beside each Program names in the data table
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see check box default state as unchecked on the left side in all rows against program name
@verifyingSortIcon
    Scenario: Verify Sort icon in manage program	Admin is on dashboard page after Login
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
		@verifyingEditAndDeleteicon
       Scenario: Verify edit and delete icon in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the Edit and Delete buttons on each row of the data table
		@verifyingPaginationIcons
    Scenario: Verify pagination icons below data table in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the text as Showing x to y of z entries along with Pagination icon below the table.x- starting record number on that page y-ending record number on that page z-Total number of records

		@verifyingFooterMessage
    Scenario: Verify footer message in manage program
        Given Admin is on dashboard page after Login
        When Admin clicks Program on the navigation bar
        Then Admin should see the footer as In total there are z programs.z- Total number of records
        
	 @verifyingAddedProgram
	 Scenario: Verify added Program is created
	     Given Admin is on Program module11
	     When Admin searches with newly created Program Name
	     Then Records of the newly created  Program Name is displayed and match the data entered
    