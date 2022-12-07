@login
Feature: Krafttech Log in test
  # As a user, I should be able to login so I can see my account

  Background:
    Given The user is on the login page
  Scenario: Login as Selim

    When The user enters Selim credentials
    Then The user should be able to login
  @Mike @smoke
  Scenario: Login as Mike

    When The user enters Mike credentials
    Then The user should be able to login

    #class Task user enters Jhon Nash credentials
  @JhonNash @smoke
  Scenario: Login as Jhon Nash

    When The user enters Jhon Nash credentials
    Then The user should be able to login
  @smoke @db
  Scenario: Login as Adem KOÇ

    When The user enters Adem KOÇ credentials
    Then The user should be able to login

  Scenario: Login as Efe
    Given The user is on the login page
    When The user enters Efe credentials
    Then The user should be able to login

  Scenario: Login as Rosa

    When The user enters Rosa credentials
    Then The user should be able to login


  Scenario: User should be abe to login with valid credentilas

    When User should input login information
    Then User should be on home page

  Scenario: Login with parameters

    When User should input "user11@test.com" and "Test123456"
    Then User should be on home page

  @wip
  Scenario: Login as a given user

    Then User should input following credentials

      | email    | user22@test.com |
      | password | Test123456      |
      | Name     | User22          |




