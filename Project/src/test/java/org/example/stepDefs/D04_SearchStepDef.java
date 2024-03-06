package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.example.pages.SharedMethods;
import static org.example.stepDefs.Hooks.driver;

public class D04_SearchStepDef{

    @Given("^user could login by \"(.*)\" and \"(.*)\"$")
    public void preSteps(String email, String password) throws InterruptedException {
        SharedMethods.loginSteps(email, password);
    }

P03_HomePage homePage;

    @Given("^user writes Product name \"([^\"]*)\"$")
public void user_writes_product_name_something(String SerachText) {
//        driver = DriverFactory.getDriver();
        homePage = new P03_HomePage(driver);
        homePage.searchFun(SerachText);
    }

    @When("^user click on search button$")
    public void user_click_on_search_button() {
        homePage.clickSearch();
    }

    @Then("^the system show related product that include \"([^\"]*)\"$")
    public void the_system_show_related_product_that_include_something(String strArg1) throws InterruptedException {
        homePage = new P03_HomePage(driver);
        Thread.sleep(1000);
        homePage.checkProductName(strArg1);
    }

}
