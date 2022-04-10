@Feature_Products
Feature: This feature would be used to test the products price of the application https://www.saucedemo.com/

  Background: Logon to the application https://www.saucedemo.com/
    Given I have opened the swaglabs application in browser

  Scenario Outline: Validate the prices of the product
    When I have logged in successful
    Then Validate "<ProductName>" and "<Price>"

    Examples: 
      | ProductName                       | Price  |
      | Sauce Labs Backpack               | $29.99 |
     # | Sauce Labs Bike Light             | $9.99  |
     # | Test.allTheThings() T-Shirt (Red) | $15.99 |

  Scenario: Validate the prices of the product using data table
    Given I have logged in successful
    When I pass below prodcuts
      | Sauce Labs Backpack               | $29.99 |
      | Sauce Labs Bike Light             | $9.99  |
      | Test.allTheThings() T-Shirt (Red) | $15.99 |
    Then I should validate product prices successful
