Feature: Login scenarios
  @Login @One
  Scenario Outline: Successfully login the user with valid credentials
    Given User opens application URL
    And User navigate to Account Login page
    When User login to the app using email "<email>" and password "<password>"
    Then User should be able to login successfully
    Examples:
      |email             | password      |
      | ravi.kiran1@gmail.com    |rkiran         |