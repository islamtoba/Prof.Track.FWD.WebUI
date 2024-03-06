@smoke
Feature:  the Logged user could select any different Categories in the system

  Background:
    Given user could login by "islamtoba@gmail.com" and "170389"

  Scenario: Logged user could select different Categories

    When user can hover on computer category and selects sub category notebook
    Then the system show all sub category products
