Feature: Login functionality

Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter "Admin" as username
    And I enter "admin123" as password
    And I click the login button
    Then I should see the dashboard page
    And the title should be "OrangeHRM"
    And Verify all asserts an exit from web site
