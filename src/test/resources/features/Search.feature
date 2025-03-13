Feature: search functionality scenario

  @Search @One
  Scenario: User can't order unavailable product and gets a warning message
    Given User opens application URL
    When User search for a product "Apple Iphone"
    Then User should see a message "Your shopping cart is empty"

  @Search
  Scenario: Verify user is able to search the product
    Given User opens application URL
    When User search for a product "Samsung SyncMaster 941BW"
    Then User should see this product in the search results