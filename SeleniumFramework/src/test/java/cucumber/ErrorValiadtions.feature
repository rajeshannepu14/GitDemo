
@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Negative Test of login page
  	Given Landed on Ecommerce Page
    When Login with Username <userName> and Password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | userName         | password  |
      | Rajesh@gmail.com | Rajesh12  |
      
