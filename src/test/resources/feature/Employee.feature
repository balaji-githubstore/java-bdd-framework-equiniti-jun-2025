@employee
Feature: Employee
  In order to manage employee details 
  As an Admin
  I would like add, edit, delete the employee record

  Scenario: Add Valid Employee
    Given I have browser with OrangeHRM application
    When I enter username as "Admin"
    And I enter password as "admin123"
    And I click on login
    And I click on PIM menu
    And I click on add employee
    And I fill the employee form
      | first_name | middle_name | last_name |
      | jack       |        4454 | wick      |
      | jack2      |       44542 | wick2     |
    And I click on save employee
    Then I should get the profile name as "jack wick"
    And I should get the personal details form filled with added data
