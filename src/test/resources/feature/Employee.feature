@employee
Feature: Employee
  In order to manage employee details 
  As an Admin
  I would like add, edit, delete the employee record

  Scenario Outline: Add Valid Employee
    Given I have browser with OrangeHRM application
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login
    And I click on PIM menu
    And I click on add employee
    And I fill the employee form
      | first_name | middle_name   | last_name |
      | <fname>    | <middle_name> | <lname>   |
    And I click on save employee
    Then I should get the profile name as "<fname> <lname>"
    And I should get the personal details form filled with added data

    Examples: 
      | username | password | fname | middle_name | lname   |
      | Admin    | admin123 | john  | w           | wick    |
      | Admin    | admin123 | saul  | g           | goodman |
