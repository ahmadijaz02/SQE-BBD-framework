Feature: Update Facebook Profile Information

  Scenario: Update Facebook profile information
    Given I am logged into Facebook for profile update
    When I navigate to the profile settings page
    And I update my profile information
    Then the profile information should be updated successfully
