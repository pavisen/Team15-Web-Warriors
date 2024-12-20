Feature: Manage Program  Sorting Program

Background: Admin is on program module after reaching dashboard

    Given Admin Gives the valid LMS portal URL
    And Admin is in login Page
    When Admin enter valid credentials  and clicks login button 
    And Admin click on Program Module Link on Dashboard_1


Scenario Outline: Verify sorting of  Program name in Ascending order/Descending order

Given Admin is on Program module
When Admin clicks on Arrow next to program Name
Then Admin See the Program Name is sorted in "<SortingOrder>" Ascending or Descending order
Examples:
|SortingOrder|
|Ascending|
|Descending|



Scenario Outline: Verify sorting of  Program Description in  Descending order

Given Admin is on Program module
When Admin clicks on Arrow next to Program Description
Then Admin See the program Description "<Description_SortingOrder>" Ascending or Descending order

Examples:
|Description_SortingOrder|
|Ascending|
|Descending|


@Test
Scenario Outline: Verify sorting of   Program status in Ascending order/Descending order

Given Admin is on Program module
When Admin clicks on Arrow next to Program status
Then Use See the  Program Status is sorted in "<ProgramStatus_SortingOrder>" Ascending order or Descending order

Examples:
|ProgramStatus_SortingOrder|
|Ascending|
|Descending|