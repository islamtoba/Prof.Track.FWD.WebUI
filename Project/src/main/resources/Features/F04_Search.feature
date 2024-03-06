@smoke
Feature: User could search for any product

  Background:
    Given user could login by "islamtoba@gmail.com" and "170389"

    Scenario:  Logged User could search for any product

    Given user writes Product name "apple"
    When user click on search button
    Then the system show related product that include "Apple"
