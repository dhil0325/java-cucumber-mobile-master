@login
Feature: Login

  @login @positive
  Scenario: As a user i should be able to login
    Given user navigate to login page
    When user login with valid credential
    Then user should be directed to homepage
