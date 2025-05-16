@Ui-Tests

Feature: Add to cart Feature
  
  @Smoke
  Scenario: Add item to Cart and check name and numbers
    Given Login as user
    When Add to Cart by item name: "Sauce Labs Backpack"
    Then Check that number of Cart items: 1
    When Add to Cart by item name: "Sauce Labs Bolt T-Shirt"
    Then Check that number of Cart items: 2
    When Click on cart icon
    Then Check name of Cart item: 1, "Sauce Labs Backpack"
    Then Check name of Cart item: 2, "Sauce Labs Bolt T-Shirt"