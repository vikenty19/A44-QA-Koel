Feature: Register a new user or restore forgotten password
@Register
  Scenario Outline: User is able to register in app using allowed email
    Given I open browser
    And I open registration page
    And I enter my valid email "<email>" and submit it:
    Then  I should see a message that new password was sent to my email
    Examples:
      | email      |
      | V2@mail.ru |