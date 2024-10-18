Feature: Facebook Login Functionality

  Scenario: Valid login with email and password
    Given I am on the Facebook login page
    When I enter a valid email and password
    And I click the login button
    Then I should be redirected to the Facebook homepage

  Scenario: Invalid login with incorrect email and password
    Given I am on the Facebook login page
    When I enter an invalid email and password
    And I click the login button
    Then I should see an error message

  Scenario: Login with empty email and password fields
    Given I am on the Facebook login page
    When I leave the email and password fields empty
    And I click the login button
    Then I should see a validation error
