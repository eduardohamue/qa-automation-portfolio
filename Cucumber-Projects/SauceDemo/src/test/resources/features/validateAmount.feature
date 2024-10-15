Feature: Adding multiple products and validating the total amount

  Background:
    Given the user is logged in with standard_user and secret_sauce

  Scenario: Add two products to the cart and verify the total amount at checkout
    When the user adds 2 products to the cart
    Then the user proceeds to the cart
    And the user clicks on the checkout button
    And the user field "FirstName", "LastName", and "12345"
    When the user clicks the continue button
    Then the total amount should be the sum of the prices of both products
