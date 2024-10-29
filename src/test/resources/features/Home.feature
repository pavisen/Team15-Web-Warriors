Feature: Home Page Validation

Scenario: Verify Admin is able to land on login page

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should land on the LMS poral

Scenario: Verify Admin is able to land on home page with invalid URL

Given Admin launches the browser
When Admin gives the invalid LMS portal URL
Then Admin should recieve page not found error 


Scenario: Verify for broken link

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin Verifying the broken links in this page


Scenario: Verify the text spelling in the page 

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see correct spellings in all fields 

@Test
Scenario: Verify the company logo

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see logo on the left side


Scenario: Verify application name

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see  LMS - Learning Management System



Scenario: Verify company name below the application name

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see company name below the app name


Scenario: Validate sign in content

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see Please login to LMS application


Scenario: Verify text field is present
Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see two text field


Scenario: Verify text on the first text field

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should "User" in the first text field


Scenario: Verify asterik next to User text

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see "user" field mandatory symbol next to user text



Scenario: Verify text on the second text field

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should "Password" in the second text field


Scenario: Verify asterik next to password text

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see "Password" field mandatory symbol next to password text


Scenario: verify Login button is present

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see login button 


Scenario: Verify the alignment of the login button

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see login button on the centre of the page


Scenario Outline: Verify input descriptive test in Admin field

Given Admin launches the browser
When Admin gives the correct LMS portal URL
Then Admin should see "<Text Fields>" in gray color

Examples:
|Text Fields|
|User|
|Password|



