Feature: Desktops
  Background: Common steps for all the desktop scenarios
    Given User is on Retail website
    When User click on Desktops tab
    And User click on Show all desktops

  Scenario: User verify all items are present in Desktops tab
#    Given User is on Retail website
#    When User click on Desktops tab
#    And User click on Show all desktops
    Then User should see all items are present in Desktop page

  @dpo
  Scenario: User add HP LP 3065  from Desktops tab to the cart
#    Given User is on Retail website
#    When User click on Desktops tab
#    And User click on Show all desktops
    And User click  ADD TO CART option on HP LP3065 item
    And User select quantity 1
    And User click add to Cart button
    Then User should see a message ‘Success: you have added HP LP 3065 to your Shopping cart!’

  @cpo
  Scenario: User add Canon EOS 5D from Desktops tab to the cart
#    Given User is on Retail website
#    When User click on Desktops tab
#    And User click on Show all desktops
    And User click  ADD TO CART option on ‘Canon EOS 5D’ item
    And User select color from dropdown ‘Red’
    And User select quantity 1
    And User click add to Cart button
    Then User should see a message ‘Success: You have added Canon EOS 5D to your shopping cart!’

  Scenario Outline: User add a review to Canon EOS 5D item in Desktops tab
#    Given User is on Retail website
#    When User click on Desktops tab
#    And User click on Show all desktops
    And User click on Canon EOS 5D item
    And User click on write a review link
    And user fill the review information with "<yourname>", "<yourReview>" and "<rating>"
    And User click on Continue Button
    Then User should see a message with ‘Thank you for your review. It has been submitted to the webmaster for approval.”

    Examples:
      | yourname | yourReview                       | rating |
      | Jasna    | Awesome, wonderful, marvelous    | good   |
      | Jasmine  | need improvement, not up to mark | bad    |








