Feature: Login
  In order to maintain the employee details
  As an admin
  I want to login into the orangehrm portal

  Scenario: Valid Login
    Given I have browser with OrangeHRM application
    When I enter username as "Admin"
    And I enter password as "admin123"
    And I click on login
    Then I should get access to dashboard with content as "Time at Work"

  Scenario: Invalid Login
    Given I have browser with OrangeHRM application
    When I enter username as "john"
    And I enter password as "john123"
    And I click on login
    Then I should not get access to portal with error "Invalid credentials"
