Feature: Login Functionality
  Scenario: Login with Valid Credentials
    Given User is on Login Page
    When User enter admin credentials
    Then User should successfully login