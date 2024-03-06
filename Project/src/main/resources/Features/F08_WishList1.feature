@smoke
Feature: Logged user could add different products to Wishlist

  Scenario: Logged user could add different products to Wishlist

    Given User in homepage and add product to his wishlist
    And the system show green success message
    When user go to his Wishlist
    Then The User find Product "HTC One M8 Android L 5.0 Lollipop" in the Wishlist