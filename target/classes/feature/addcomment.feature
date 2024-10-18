Feature: Facebook Comment Functionality

  Scenario: Add a comment to a post
    Given I am logged into Facebook
    And I see a post on my timeline
    When I write a comment on the post
    And I click the comment button
    Then my comment should appear under the post
