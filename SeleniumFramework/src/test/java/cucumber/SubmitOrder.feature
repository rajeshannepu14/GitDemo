
@tag
Feature: Purchase the order from your Ecommerce site
  I want to use this template for my feature file

	Background: 
		Given Landed on Ecommerce Page

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Login with Username <userName> and Password <password>
    When Add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANK YOU FOR THE ORDER." message is displayed on the Confirmatio Page

    Examples: 
      | userName         | password  | productName  |
      | Rajesh@gmail.com | Rajesh123 | ZARA COAT 3  |
     