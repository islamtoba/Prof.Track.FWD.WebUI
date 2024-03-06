package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {


    public WebElement regLinkBut(){
        WebElement icon = Hooks.driver.findElement(By.className("ico-register"));
        return icon;
    }

    public static WebElement firstname(){
        By firstName = By.id("FirstName");
        WebElement Fname= Hooks.driver.findElement(firstName);
        return Fname;
    }

    public static WebElement lastname() {
        By lastName = By.id("LastName");
        WebElement Lname = Hooks.driver.findElement(lastName);
        return Lname;
    }

    public static WebElement email() {
        By Email = By.id("Email");
        WebElement email = Hooks.driver.findElement(Email);
        return email;
    }

    public static WebElement Password() {
        return Hooks.driver.findElement(By.name("Password"));
    }

    public static WebElement confirmPassword() {
        return Hooks.driver.findElement(By.name("ConfirmPassword"));
    }

    public static WebElement registerButton(){
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public static By result()
    {
        return By.className("result");
    }


    public void RegisterData(String ftname, String ltname, String email, String password, String confPass){

        firstname().sendKeys(ftname);

        lastname().sendKeys(ltname);

        email().sendKeys(email);

        Password().sendKeys(password);

        confirmPassword().sendKeys(confPass);
    }

    public WebElement continueBTN(){
        WebElement btn = Hooks.driver.findElement(By.className("register-continue-button"));
        return btn;
    }

}
