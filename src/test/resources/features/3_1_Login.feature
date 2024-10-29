Feature: Login feature
@launching_website
Scenario: Launching application
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should land on the login page
@login_tag1
Scenario Outline: verify login button action valid credentials 
    Given Admin is in login Page
    When Admin enter valid credentials and clicks login button through keyboard
    Then Admin should land on dashboard page