Feature: Employee search

Scenario: Search for an employee from a dynamic list
    Given I am logged in with "admin" user and "admin123" password
    When I navigate to the employee list
    And I search for "John Doe"
    Then I should see a list of employee results
    And the first result should contain "John" "Doe"