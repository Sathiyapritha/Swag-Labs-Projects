Feature: List of all products feature
  User on a successful login
  user should see the all list of products in product page

 Background:
    Given User should navigate to home page "https://www.saucedemo.com/"
    And User should enter username as "standard_user"
    And User should enter password as "secret_sauce"
    When User clicks login button
    Then User should be login successfully and redirect to products page "Products"

@lop
  Scenario: Verify available list of products
    Then User should see 6 products listed

  @lop
  Scenario Outline: Verify listed products appropriately

    Then User should see products with "<title>","<price>", "<description>", "<image>", and "<Add to cart>" button



    Examples:
      | title                             | price  | description                                    | image                             | Add to cart |
      | Sauce Labs Backpack               | $29.99 | carry.allTheThings() with the sleek            | Sauce Labs Backpack               | Add to cart |
      | Sauce Labs Bike Light             | $9.99  | A red light isn't the desired state in testing | Sauce Labs Bike Light             | Add to cart |
      | Sauce Labs Bolt T-Shirt           | $15.99 | Get your testing superhero                     | Sauce Labs Bolt T-Shirt           | Add to cart |
      | Sauce Labs Fleece Jacket          | $49.99 | It's not every day that you come across        | Sauce Labs Fleece Jacket          | Add to cart |
      | Sauce Labs Onesie                 | $7.99  | Rib snap infant onesie for the junior          | Sauce Labs Onesie                 | Add to cart |
      | Test.allTheThings() T-Shirt (Red) | $15.99 | This classic Sauce Labs t-shirt                | Test.allTheThings() T-Shirt (Red) | Add to cart |