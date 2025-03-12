Feature: search functionality scenario
  Scenario: Verify user is able to search the product
    Given User opens application URL
    When User search for a product "Samsung SyncMaster 941BW"
    Then User should see this product in the search results