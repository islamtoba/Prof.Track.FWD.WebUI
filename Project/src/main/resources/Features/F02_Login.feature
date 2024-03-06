@smoke
Feature: User could log in with valid email and password
Background:
  Given user navigates login page


  Scenario: user login successfully
    When user login with "islamtoba@gmail.com" and "170389"
    And user click on login button
    Then user could login successfully
    And redirected to homepage

  Scenario: user couldn't login successfully
    When user login with "wrong@gmai.com" and "170389"
    And user click on login button
    Then user could not login successfully
