@register
Feature: Register

  @register @positive
  Scenario: As a user i should be able to register
    Given user navigate to login page
    Given user navigate to register page
    When user fill out register form and tap register
    Then user should be navigate to profile page
