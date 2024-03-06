@smoke
Feature: The links on slider page should working

  Scenario Outline:  The links on slider page should working

    Given User in home page and click on  "<Slider>"
    Then user verify that "<URL>" for Slider correct

    Examples:
      | Slider | URL |
      | first  | https://demo.nopcommerce.com/nokia-lumia-1020 |
      | second | https://demo.nopcommerce.com/iphone-6 |