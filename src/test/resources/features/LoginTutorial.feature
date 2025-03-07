Feature: Login scenarios
  @Login @One
  Scenario: Successfully login the user with valid credentials
    Given User opens application URL
    And User navigate to Account Login page
    When User login to the app using Username "Vic@gmail.com" and Password "rkiran"

    Then User should be able to login successfully