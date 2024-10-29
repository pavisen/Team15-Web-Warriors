@Add_Class_Module
Feature: Add New Class Feature Validation

  Background: The Admin is logged on to the LMS portal
    Given Admin Gives the valid LMS portal URL
    When Admin enter valid credentials  and clicks login button
    When Admin clicks "Class" on the navigation bar_CM
    When Admin clicks "+ Add New Class" button_CM

  # Then Admin should be able to see a new pop up with Class details
  @AddClass01
  Scenario: Check if the buttons exist in pop-up_CM
    Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window_CM

  @AddClass02
  Scenario Outline: Check if the fields exist in pop-up of AddClass window_CM
    Then Admin should be able to see the "<field>" for Add Batch as "<type>"_CM

    Examples: 
      | field            | type          |
      | staffName        | drop down     |
      | ClassDescription | text          |
      | BatchName        | drop down     |
      | Status           | p-radiobutton |
      | ClassTopic       | text          |
      | Class dates      | Calendertext  |
      | NumberofClasses  | input         |

  @AddClass03
  Scenario: Check if class is created when only mandatory fields are entered with valid data_CM
    When Admin enters mandatory fields in the form_CM
    And Admin clicks save button_CM
    Then Admin can see the class details popup closed and adding new class message Class added Successfully_CM

  @AddClass04
  Scenario: Check no.of classes value added when selecting class dates_CM
    When Admin selects class date in date picker_CM
    Then Admin should see no of class value is added automatically_CM

  @AddClass05
  Scenario: Check weekend dates are disabled in calender_CM
    When Admin clicks date picker_CM
    Then Admin should see weekends dates are disabled to select_CM

  @AddClass06
  Scenario: Check if class is created when only optional fields are entered with valid data_CM
    When Admin skips to add value in mandatory field and enter only the optional field_CM
    Then Admin should see error message below the test field and the field will be highlighed in red color_CM

  @AddClass07
  Scenario Outline: check if class is created when invalid data is entered in all of the fields_CM
    When Admin enters invalid data "<invalidValues>" in all of the  fields in the form and clicks on save button_CM
    Then Admin gets error message and class is not created_CM

    Examples: 
      | invalidValues |
      |           123 |
      | 6587**65      |

  @AddClass08
  Scenario: Empty form submission_CM
    When Admin clicks on save button without entering data_CM
    Then class wont be created and Admin gets error message_CM

  @AddClass09
  Scenario: Validate Cancel/Close(X) icon on class Details form_CM
    When Admin clicks Cancel/Close(X) Icon on Admin Details form_CM
    Then Class Details popup window should be closed without saving_CM
