@smoke
Feature: switching between currencies US-Euro
  Background:
    Given user could logged by "islamtoba@gmail.com" and "170389"
    Given user writes Product name "Apple MacBook"
    Given user click on search button
  Scenario:  Logged User could switch between currencies US-Euro

    Then the system change the system currency