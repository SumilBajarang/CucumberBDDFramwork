Feature: User Login

  Scenario: Successful Login
    Given the user is on the nopCommerce login page
    When the user enters valid credentials (username: "testNg@gmail.com", password: "testng@123")
    Then the user should be redirected to the My Account page
    And the user should see a welcome message
