Feature: Search functionality on nopCommerce

  Scenario: Search with valid product name
    Given the user is on the nopCommerce home page
    When the user searches for "laptop"
    Then search results should be displayed