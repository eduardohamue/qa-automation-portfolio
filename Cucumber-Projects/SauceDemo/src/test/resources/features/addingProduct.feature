Feature: Adding products to cart

  Background:
    Given the user is logged in with standard_user and secret_sauce

  Scenario: Add a product to the cart
    When the user adds a product to the cart
    Then the product should appear in the shopping cart