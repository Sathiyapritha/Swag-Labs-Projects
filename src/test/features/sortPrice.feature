Feature: Sort feature
  As a user
  I should be able to sort the product

  Background:
    Given User should navigate to home page "https://www.saucedemo.com/"
    And User should enter username as "standard_user"
    And User should enter password as "secret_sauce"
    When User clicks login button
    Then User should be login successfully and redirect to products page "Products"

@sort
  Scenario: Verify values in sort dropdown
    Then User should see "Name (A to Z)" and "Name (Z to A)" in sort dropdown


@sort
  Scenario: Verify price low to high in sort option
    Then user choose "Price (low to high)" sort option


  @sort
  Scenario: Verify price high to low in sort option
    Then user should select "Price (high to low)" in sort option
