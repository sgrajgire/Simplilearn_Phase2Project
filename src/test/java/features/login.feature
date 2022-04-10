@Feature_Login
Feature: This feature would be used to test the login page of the application https://www.saucedemo.com/

  Background: Open the application https://www.saucedemo.com/
    Given I have opened the swaglabs application in browser


  Scenario Outline: Positive Login using scenario outline
    When I enter username "<UserName>"
    And I enter password "<Password>"
    And I click on the login button
    Then I should be logged in succesful and land on product page

    Examples: 
      | UserName      | Password     |
      | standard_user | secret_sauce |

  Scenario Outline: Negative Login using scenario outline
    When I enter username "<UserName>"
    And I enter password "<Password>"
    And I click on the login button
    Then I should be getting error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | UserName      | Password   |
      | standard_user | wrong_pass |
