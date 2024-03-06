package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D05_hoverCatStepDef {

    P03_HomePage homePage;

    @When("^user can hover on computer category and selects sub category notebook$")
    public void user_can_hover_on_computer_category_and_selects_sub_category_notebook() {
        homePage = new P03_HomePage(driver);
        homePage.hoverComputerMenu();
    }

    @Then("^the system show all sub category products$")
    public void the_system_show_all_sub_category_products() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(homePage.PageTitle));
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(homePage.PageTitle.getText(), "Software");
        soft.assertAll();
    }

}



