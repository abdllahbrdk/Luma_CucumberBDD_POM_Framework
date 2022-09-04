Feature: Purchase
  Background:  New Address
    Given User is on Login Page
    When User enter admin credentials
    Then User should successfully login

  Scenario: Purchase Functionality Test
    And User select a product from homepage
    And User purchase the product
    Then User should see success message
