Feature: Add a friend on Facebook

  Scenario: Successfully adding a friend through profile link
    Given I am logged into Facebook for adding a friend
    When I navigate to the friend's profile link
    And I add the friend from their profile
    Then the friend request should be sent successfully
