package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_LoginPage {


    public static WebElement email(){
        WebElement Email= Hooks.driver.findElement(By.id("Email"));
        return Email;
    }

    public static WebElement password()
    {
       WebElement password=Hooks.driver.findElement(By.id("Password"));
        return password;
    }

    public static WebElement loginButton(){
       WebElement button = Hooks.driver.findElement(By.className("login-button"));
       return button;
    }


    public WebElement logoutButton()
    {
       WebElement button = Hooks.driver.findElement(By.className("ico-logout"));
        return button;
    }

    public static void LoginData(String email, String password) throws InterruptedException {

        email().sendKeys(email);
        password().sendKeys(password);
        Thread.sleep(2000);
    }
}
