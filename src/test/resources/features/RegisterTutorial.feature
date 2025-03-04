Feature: Registration functionality scenarios
@Register @One
  Scenario: Verify whether user is able to register into the application by providing all the details

    Given User opens application URL
    And I navigate to Account Registration page
    When I provide all the below valid details :

      |FirstName| Ravi                    |
      |LastName | Kiran                   |
      |Email    |Vic@gmail.com     |
      |Telephone|9212345678               |
      |Password |rkiran                   |
    And I check-in the Privacy Policy
    And  I click on continue button
    Then I should see that the User Account has successfully been created