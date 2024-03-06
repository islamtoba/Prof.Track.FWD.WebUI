package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.example.stepDefs.Hooks.driver;

public class D08_WishListStepDef{

    P03_HomePage home;

    @Given("^User in homepage and add product to his wishlist$")
    public void user_in_homepage_and_add_product_to_his_wishlist() throws InterruptedException {
        home = new P03_HomePage(driver);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        home.clickAddToWishList();

    }

    @And("^the system show green success message$")
    public void the_system_show_green_success_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String Expectedresult = "The product has been added to your wishlist";
        String Actualresult= home.WishListMessage.getText();
        wait.until(ExpectedConditions.visibilityOf(home.WishListMessage)).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Actualresult.contains(Expectedresult));
        System.out.println(Actualresult);
//        Assert.assertEquals(home.WishListMessage.getText(), "The product has been added to your wishlist");
        String backgroundcolor = home.WishListMessageContainer.getCssValue("background-color");
        soft.assertEquals(home.WishListMessageContainer.getCssValue("background-color"), "rgba(75, 176, 122, 1)");
        System.out.println("Background Color is: " + backgroundcolor);
        soft.assertAll();
    }
    @When("^user go to his Wishlist$")
    public void user_go_to_his_wishlist() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home.CloseMessgae();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("^The User find Product \"([^\"]*)\" in the Wishlist$")
    public void the_user_find_product_something_in_the_wishlist(String strArg1) {
        SoftAssert soft = new SoftAssert();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//      soft.assertEquals(home.ProductName.getText().equalsIgnoreCase(strArg1) , true);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("=============== >>" + home.Qty.getAttribute("innerText"));
        soft.assertTrue(home.Qty.getAttribute("innerText").equalsIgnoreCase("(1)"));
        soft.assertAll();
    }
}
