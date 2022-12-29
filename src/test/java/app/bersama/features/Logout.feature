@logout
Feature: Logout

  @logout @positive
  Scenario: As a user i should be able to logout
    Given user navigate to login page
    * user login with "valid_credential1"
    * user should be directed to profilepage
    When user tap logout button
    Then user navigate to homepage

