package org.example.pages;

import org.example.stepDefs.D02_LoginStepDef;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SharedMethods {
    static protected Select select;
    protected WebDriver driver;
    public SharedMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void ClickButtons(WebElement button) {
        button.click();
    }

    protected void SendValue(WebElement field, String value) {
        field.sendKeys(value);
    }

    public static void loginSteps(String email, String password) throws InterruptedException {
            D02_LoginStepDef.navigate_to_loginPAge();
            D02_LoginStepDef.enter_valid_data(email, password);
            D02_LoginStepDef.clickLoginButton();
            Thread.sleep(2000);
        }

    }
