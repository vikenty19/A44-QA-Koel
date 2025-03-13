Feature: Placing orders E-2-E scenarios
  Scenario: Verify whether the user can place the order
    Given I login to the app
    When I add a product to a cart and check-out
    And I place the order
    Then I should see that the order is placed successfully


