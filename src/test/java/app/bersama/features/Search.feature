@search
Feature: Search

  @search @positive
  Scenario: As a user i want search product to buy
    Given user navigate to login page
    * user login with "valid_credential1"
    * user should be directed to profilepage
    Given navigate to homepage and tap search field
    When input product search and click product
    Then navigate to product page
