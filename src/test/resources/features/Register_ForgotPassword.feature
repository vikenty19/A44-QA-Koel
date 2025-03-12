Feature: Register a new user or restore forgotten password
@Register
  Scenario Outline: User is able to restore the password allowed email
    Given I open browser
    And I open registration page
    And I enter my valid email <email> and submit it:
    Then  I should see a message that new password was sent to my email
    Examples:
      | email      |
      | "V2@mail.ru" |

  @Register
  Scenario: User can't register in the app with empty email field
    Given I open browser
    And I open registration page
    And I click Submit button
    Then I should see a message that entered data is not valid