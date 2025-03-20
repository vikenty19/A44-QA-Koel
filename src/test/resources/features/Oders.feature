Feature: Placing orders E-2-E scenarios
  @Orders
  Scenario: Verify whether the user can place the order
    Given I login to the app
    When I add a product to a cart and check-out
    And I place the order
    Then I should see that the order is placed successfully
@Orders
Scenario: User is not able to order yhe product which is out of stock
  Given I login to the app
  When  I add an out-of-stock product to a cart and check-out
  Then I should see the message that this product is out-of-stock

