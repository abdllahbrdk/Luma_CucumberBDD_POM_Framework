Feature: Add New Address Functionality
  Background:  New Address
    Given User is on Login Page
    When User enter admin credentials
    Then User should successfully login

  Scenario Outline: Add new Addresses
    And User Create a New Address with "<PhoneNumber>" "<StreetAddress>" "<City>" "<ZipCode>"
    Then Success message should be displayed
    Examples:
    |PhoneNumber|StreetAddress|City|ZipCode|
    |2019873456 |kenotolonya  |cali|07609  |
    |2019873457 |kenotolonka  |kali|07608  |
    |2019873458 |kenotolonma  |sali|07607  |
