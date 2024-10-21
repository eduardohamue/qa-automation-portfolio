Feature: Sauce Demo login functionality

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters <Username> and <Password>
    And the user clicks the login button
    Then the user is redirected to the products page
    Examples:
      | Username                | Password      |
      | standard_user           | secret_sauce  |
      | problem_user            | secret_sauce  |
      | performance_glitch_user | secret_sauces |
      | error_user              | secret_sauce  |
      | visual_user             | secret_sauce  |


  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters invalid_user and wrong_password
    And the user clicks the login button
    Then an error message of "Epic sadface: Username and password do not match any user in this service" is displayed


  Scenario: Unsuccessful login with locked user
    Given the user is on the login page
    When the user enters locked_out_user and secret_sauce
    And the user clicks the login button
    Then an error message of "Epic sadface: Sorry, this user has been locked out." is displayed