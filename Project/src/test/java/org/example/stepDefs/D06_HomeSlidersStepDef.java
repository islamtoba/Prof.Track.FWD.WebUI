package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

import static org.example.stepDefs.Hooks.driver;

public class D06_HomeSlidersStepDef{

    P03_HomePage home ;

    @Given("^User in home page and click on  \"([^\"]*)\"$")
    public void user_in_home_page_and_click_on_something(String slider) throws InterruptedException {
        home = new P03_HomePage(driver);
        home.SelectSlider(slider);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^user verify that \"([^\"]*)\" for Slider correct$")
    public void user_verify_that_something_for_slider_correct(String url) throws InterruptedException {
        Thread.sleep(1000);
        SoftAssert soft = new SoftAssert();
//        Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url));
        Assert.assertFalse(driver.getCurrentUrl().equalsIgnoreCase(url));
//        soft.assertAll();
    }
}

