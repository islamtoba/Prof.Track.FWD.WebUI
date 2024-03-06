package org.example.stepDefs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
//define before and after methods for the project
    public static WebDriver driver;
@Before
public void OpenBrowser() throws InterruptedException {

//    String driverPath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
//    System.setProperty("webdriver.chrome.driver", driverPath);

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://demo.nopcommerce.com/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}

    @Given("user opens browser")
    @And("user go to register page")
    public void goRegisterPage()
    {
// System.out.println("This is a test before start coding");
        WebElement registerBtn =
                Hooks.driver.findElement(By.cssSelector("a[href=\"/register?returnUrl=%2F\"]"));
        registerBtn.click();
    }
    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
