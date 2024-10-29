Feature: Dashboard Page Verification

Background: Verify Admin is able to land on login page

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should land on the LMS poral

Scenario: Verify after login Admin lands on dashboard page

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should land on dashboard page 


Scenario: Verify the response time

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Maximum navigation time in milliseconds defaults to 30 seconds


Scenario: Verify broken link in Dashboard page

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin Verifying the broken links in dashboard page


Scenario: Verify LMS title

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should see LMS -Learning management system as title

Scenario: Validate LMS title has correct spelling and space

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should see correct spelling and space in LMS title


Scenario: Validate navigation bar text LMS

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then LMS title should be on the top left corner of page


Scenario: Validate navigation bar text

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should see correct spelling in navigation bar text


Scenario Outline: Validate navigation bar order 

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should see "<NavigationBarOrder>" in their respective "<places>"

Examples:
|NavigationBarOrder|places|
|1|Program|
|2|Batch|
|3|Class|
|4|Logout|



Scenario Outline: Validate alignment for navigation bar on the top right side

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button
Then Admin should see the navigation bar text "<headerText>" on the top right side

Examples:
|headerText|
|Program|
|Batch|
|Class|
|Logout|







