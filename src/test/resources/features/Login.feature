@tag
Feature: Login feature
@launching_website
Scenario: Launching application
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should land on the login page

@login_admin
Scenario Outline: Login to the application
Given Admin is in login Page
When Admin enter valid credentials from "<SheetName>" and <RowNumber> clicks login button through keyboard
Then Admin should land on dashboard page
Examples:
			| SheetName  | RowNumber |
			| login      | 1        |

