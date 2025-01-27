@sanity
Feature: Creation of New User with all payload details

  Scenario Outline: Creation of a new user for a demo site
    Given user has requested to hit an application URL
    And user will pass the payload with all needed details
    When user will hit the specific "<endpoint1>"
    Then we are going to validate the status code as specific "<status_code>"

    Examples: 
      | endpoint1 | status_code |
      | api/users |         201 |
