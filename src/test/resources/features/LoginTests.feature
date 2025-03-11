Feature: login tests

  Background:
    Given I open browser
    When I open login page

  @Login
  Scenario Outline: login success

    And  i enter valid email <email>
    And I enter valid password <password>
    And  I click Submit
    Then I am logged in
    Examples:
      | email                        | password      |
      | "vikenty.plakhov@testpro.io" | "MEGAdelta06" |

  @Login @Two
  Scenario Outline:LoginWrongEmail
    And I enter valid password <password>
    And I enter wrong email <email>
    And I click Submit
    Then I am not logged in
    Examples:
      | email                  | password      |
      | "vicplach13@gmail.com" | "MEGAdelta06" |

  @Login
  Scenario: login1 success with Data Table
    And I enter details below into fields:
      | email    | vikenty.plakhov@testpro.io |
      | password | MEGAdelta06                |

    And I click Submit
    Then I am logged in
 @Login
  Scenario: I can restore the password via "forgot password" link to registered email
   When  I click the  forgot password link
   And   I enter my registered email "v@gmail.com"
   Then  I should see a message that new password was sent to my email
   @Login
   Scenario: Login without any credentials
     And I enter details below into fields:
       | email    | ""|
       | password | ""|
     And I click Submit
     Then I am not logged in