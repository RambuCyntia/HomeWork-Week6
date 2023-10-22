Feature: Website Saucedemo

  @Regression @positive @login
  Scenario: Success login
    Given Navigate in Login Page
    And Input valid username
    And Input valid password
    When Click login button
    Then User in dashboard menu

  @Regresion @negative @login
  Scenario: Unsuccessfull login
    Given Navigate in Login Page
    And Input valid username
    And Input invalid password
    When Click login button
    Then User can't login and get error message

  @Regression @positive @AddToCart
  Scenario: Remove Button from Product Menu Successfully
    Given Navigate in Login Page
    And Input valid username
    And Input valid password
    And Click login button
    When User Pick Product and Click Add to cart Button
    Then User successfully remove product from cart

  @Regression @positive @AddToCart
  Scenario: Remove Button from Product Menu Successfully
    Given Navigate in Login Page
    And Input valid username
    And Input valid password
    And Click login button
    When User Pick Product and Click Add to cart Button
    Then User successfully add to cart
