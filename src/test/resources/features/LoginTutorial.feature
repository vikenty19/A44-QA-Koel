Feature: Login scenarios
  @Login @Two
  Scenario Outline: Successfully login the user with valid credentials
    Given User opens application URL
    And User navigate to Account Login page
    When User login to the app using email "<email>" and password "<password>"
    Then User should be able to login successfully
    Examples:
      |email             | password      |
      | ravi.kiran1@gmail.com    |rkiran         |

  @Login @One
  Scenario Outline:User shouldn't login with invalid credentials
    Given User opens application URL
    And User navigate to Account Login page
    When User login to the app using email "<email>" and password "<password>"
    Then User shouldn't be able to login successfully and see a warning message
    Examples:
      |email             | password      |
      | ravi.kiran99@gmail.com    |rkiran99        |