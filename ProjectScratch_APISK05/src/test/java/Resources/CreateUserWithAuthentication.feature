@sanity

Feature: Create a new User with and process authentication

  Scenario Outline: NewUser Creation with Authentication
    Given user has requested to hit an application URL
    And user passes a payload with all required credentials
    #When the user is going to hit url with "<endpoint>"
    #Then user will be able to validate the response code and the body

    Examples: 
      | endpoint        |
      | public/v2/users |
