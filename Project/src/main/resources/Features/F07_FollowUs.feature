@smoke
Feature:  the User can follow us on different Social media

  Scenario Outline: the Social media links should be working

    Given User in home page and click on  "<Social>" Icon
    Then user verify that "<URL>" for every social correct

    Examples:
      | Social   | URL                                      |
      | Facebook | https://www.facebook.com/nopCommerce     |
      | Twitter  | https://twitter.com/nopCommerce          |
      | Youtube  | https://www.youtube.com/user/nopCommerce |
      | RSS      | https://demo.nopcommerce.com/news/rss/1  |
