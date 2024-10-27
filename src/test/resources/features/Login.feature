Feature: Login  Page Verification 

Background: Admin gives the correct LMS portal URL

Given Admin Gives the valid LMS portal URL


Scenario: Validate login with valid credentials

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button 
Then Admin should land on dashboard page  


Scenario Outline: Validate login with invalid credentials

Given Admin is in login Page
When Admin enter invalid "<Sheet>" "<TestCase>" credentials and clicks login button 
Then Error message please check Adminname/password

Examples: 
|Sheet|TestCase|
|login| LP01 |
|login| LP02 |
|login| LP03 |


Scenario: verify login button action through keyboard

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through keyboard
Then Admin should land on dashboard page

Scenario: verify login button action through mouse

Given Admin is in login Page
When Admin enter valid credentials  and clicks login button through mouse
Then Admin should land on dashboard page

