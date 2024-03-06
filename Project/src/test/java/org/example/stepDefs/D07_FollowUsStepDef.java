package org.example.stepDefs;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_HomePage;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;

import static org.example.stepDefs.Hooks.driver;

public class D07_FollowUsStepDef{

    P03_HomePage home;

    @Given("^User in home page and click on  \"([^\"]*)\" Icon$")
    public void user_in_home_page_and_click_on_something_icon(String social) {
        home = new P03_HomePage(driver);
        home.OpenSocialLinks(social);
    }

    @Then("^user verify that \"([^\"]*)\" for every social correct$")
    public void user_verify_that_something_for_every_social_correct(String URL) throws InterruptedException {

        Thread.sleep(3000);
        String parent = driver.getWindowHandle();
        Set<String> Tabs = driver.getWindowHandles();
        Iterator<String> I1 = Tabs.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (Tabs.size() == 2) {
                if (!parent.equals(child_window)) {
                    System.out.println("tabs : " + Tabs.size());
                    driver.switchTo().window(child_window);
                    Thread.sleep(5000);
                    System.out.println("Site URL : " + driver.getCurrentUrl());
                    System.out.println("file  URL : " + URL);
                    Assert.assertEquals(driver.getCurrentUrl().equalsIgnoreCase(URL), true);
                    driver.close();
                }
            } else if (Tabs.size() == 1) {
                driver.switchTo().window(parent);
                System.out.println("Site URL : " + driver.getCurrentUrl());
                System.out.println("file  URL : " + URL);
                Assert.assertEquals(driver.getCurrentUrl().equalsIgnoreCase(URL), true);
            }
        }
        driver.switchTo().window(parent);
    }

}



