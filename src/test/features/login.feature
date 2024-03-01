Feature: Sauce demo app login feature

  @login @smoke @regression
  Scenario: Login Should be successfully with valid credentials
    Given User should navigate to home page "https://www.saucedemo.com"
    And User should enter username as "standard_user"
    And User should enter password as "secret_sauce"
    When User clicks login button
    Then User should be login successfully and redirect to products page "Products"

@login @regression
  Scenario: Login Should be fail with Invalid credentials
    Given User should navigate to home page "https://www.saucedemo.com"
    And User should enter username as "standard_usr_1"
    And User should enter password as "secret_sauce_1"
    When User clicks login button
    Then User should be fail with error message as "Epic sadface: Username and password do not match any user in this service"
@login
  Scenario Outline: : Login Should be successfully with all valid credentials
    Given User should navigate to home page "https://www.saucedemo.com"
    When User should enter username as "<username>"
    And User should enter password as "secret_sauce"
    When User clicks login button
    Then User should be login successfully and redirect to products page "Products"

    Examples:
      | username                |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |