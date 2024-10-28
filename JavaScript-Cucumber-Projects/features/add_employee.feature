Feature: Add employee

Scenario: Add a new employee and verify their details
    Given I am logged in with "admin" user and "admin123" password
    When I navigate to the employee list
    When I click the add button
    And I enter the first name "Jane" and the last name "Smith"
    And I click the save button
    Then Should appears a message of "Successfully Saved"
    When I navigate to the employee list
    And I search for "Jane Smith"
    Then I should see a list of employee results
    And the first result should contain "Jane" "Smith"
