package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.example.pages.SharedMethods;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D03_currenciesStepDef {
//    P04_CurrenciesPage currency = new P04_CurrenciesPage();
    P03_HomePage homePage;

    @Given("^user could logged by \"(.*)\" and \"(.*)\"$")
    public void preSteps(String email, String password) throws InterruptedException {
        SharedMethods.loginSteps(email, password);
        homePage = new P03_HomePage(driver);
SoftAssert soft = new SoftAssert();
        soft.assertTrue(homePage.euroIcon.getText().contains("$"));
        homePage.switchCurrency();
        soft.assertAll();
    }

    @Then("^the system change the system currency$")
    public void the_system_change_the_system_currency() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(homePage.euroIcon.getText().contains("€"));
        soft.assertAll();
    }

    }

