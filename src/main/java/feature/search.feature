Feature: Facebook Search Functionality

  Scenario: Search with a valid term after logging in
    Given I log into Facebook for search
    When I enter a valid search term in the search bar
    
    Then I should see search results related to the term

  Scenario: Search with an invalid term after logging in
    Given I log into Facebook for search
    When I enter an invalid search term in the search bar
 
    Then I should see a message indicating no results found
