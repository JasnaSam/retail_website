Feature: for this feature you have to have an existing account

#  username:jaimee@gmail.com
#  password: Jaimee@123
  Background:
    Given User is on Retail website
    And User click  on MyAccount
    When  User click on Login
    And User enter username ‘userName’ and password 'password’
    And User click on Login button
    Then User should be logged in to MyAccount dashboard

  Scenario: Register as an Affiliate user with Cheque Payment Method
    When User click on ‘Register for an Affiliate Account’ link
    And User fill affiliate form with below information
      | company  | website      | taxID | paymentMethod |
      | Yahoo    | yahoo.com    | 1234  | Cheque        |
    And User check on About us check box
    And User click on Continue Button on the page
    Then User should see a success message

Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer
  When User click on ‘Edit your affiliate informationlink
  And user click on Bank Transfer radio button
  And User fill Bank information with below information
    | bankName | abaNumber | swiftCode | accountName | accountNumber |
    | TD Bank  | 143217    | 143       | Chequing    | 889113        |
  And User click on Continue Button on the page
  Then User should see a success message
  @erw
  Scenario: Edit your account Information
    When User click on ‘Edit your account information’ link
    And User modify below information
      | firstname | lastName | email           | telephone  |
      | Jasna     | Sam      | jasna@gmail.com | 7687789087 |
    And User click on continue button after updation
    Then User should see a message ‘Success: Your account has been successfully updated.’


