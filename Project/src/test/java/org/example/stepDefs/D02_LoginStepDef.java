package org.example.stepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_LoginPage;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
import static org.example.stepDefs.Hooks.driver;

public class D02_LoginStepDef {
    P02_LoginPage login = new P02_LoginPage();
    @Given("user navigates login page")
    public static void navigate_to_loginPAge(){
        driver.navigate().to("https://demo.nopcommerce.com/login");
    }
    @When("^user login with \"(.*)\" and \"(.*)\"$")
    public static void enter_valid_data(String email, String password) throws InterruptedException {
        P02_LoginPage.LoginData(email, password);
    }

    @And("user click on login button")
    public static void clickLoginButton() throws InterruptedException {
        P02_LoginPage.loginButton().click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Then("user could login successfully")
    public void Success_login(){

       String ExpectedResult = "Log out";
       String ActualResult = login.logoutButton().getText();
       SoftAssert soft = new SoftAssert();
       soft.assertTrue(ActualResult.contains(ExpectedResult));
       soft.assertEquals(ActualResult.contains(ExpectedResult), true);
       soft.assertAll();
    }

    @And("redirected to homepage")
    public static void goto_homepage() throws InterruptedException {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
        System.out.println(driver.findElement(By.cssSelector("[class=\"ico-account\"]")).isDisplayed());
        soft.assertAll();
    }

    @Then("user could not login successfully")
    public void login_wrong (){
        String ExpectedResult = "Login was unsuccessful.";
        String ActualResult = Hooks.driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]")).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(ActualResult.contains(ExpectedResult), true);
        System.out.println("Expected Result is: " + ExpectedResult);
        String unsuccessmsgColor = Hooks.driver.findElement(By.cssSelector("[class=\"message-error validation-summary-errors\"]")).getCssValue("color");
        System.out.println("Color is :" + unsuccessmsgColor);
        soft.assertAll();}
}
