package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_Register;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class D01_RegistrStepDef {
    WebDriver driver = null;
    P01_Register register = new P01_Register();

    @Given("user go to registration page")
    public void registerPage() throws InterruptedException {
        register.regLinkBut().click();
        Thread.sleep(3000);
    }
   @When("^user enter \\\"(.*)\\\" and \\\"(.*)\\\" and \\\"(.*)\\\" and \\\"(.*)\\\" and \\\"(.*)\\\"$")
    public void enter_registration_Data(String ftname, String ltname, String email, String password, String confPass) throws InterruptedException {

    register.RegisterData(ftname, ltname, email, password, confPass);
       Thread.sleep(2000);
    }

    @And("user clicks on register button")
    public void click_regButton(){
    register.registerButton().click();
    }

    @Then("user could register successfully")
    public void register_success(){
        String ExpectedResult = "Your registration completed";
        String ActualResult = Hooks.driver.findElement(register.result()).getText();
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(ActualResult.contains(ExpectedResult), true);
        String msgColor = Hooks.driver.findElement(By.cssSelector("[class=result]")).getCssValue("color");
        System.out.println("Color is :" + msgColor);
        soft.assertAll();
    }
    @And("return to homepage")
    public void goto_homepage(){
        register.continueBTN().click();
    }
}
