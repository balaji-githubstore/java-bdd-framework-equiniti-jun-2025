Feature: Login
  In order to maintain the employee details
  As an admin
  I want to login into the orangehrm portal

  Background: 
    Given I have browser with OrangeHRM application

  Scenario: Valid Login
    When I enter username as "Admin"
    And I enter password as "admin123"
    And I click on login
    Then I should get access to dashboard with content as "Time at Work"

  Scenario Outline: Invalid Login
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I click on login
    Then I should not get access to portal with error "<expected_error>"

    Examples: 
      | username | password | expected_error      |
      | saul     | saul123  | Invalid credentials |
      | kim      | kim123   | Invalid credentials |
