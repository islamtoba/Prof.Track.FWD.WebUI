package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class P03_HomePage extends SharedMethods{
public Actions actions;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(id = "small-searchterms")
    WebElement searchTextField;

    @FindBy(css = ".button-1.search-box-button")
    WebElement searchButton;

    @FindBy(id = "customerCurrency")
    WebElement currencyList;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]")
    WebElement computers;
    @FindBy(xpath = "//ul[@class='sublist first-level']/li[3]")
    WebElement Software;
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[3]")
    WebElement apparel;
    @FindBy(linkText = "Shoes")
    WebElement Shoes;

    @FindBy(xpath = "//li[@class='facebook']/a")
    WebElement Facebook;

    @FindBy(xpath = "//li[@class='twitter']/a")
    WebElement Twitter;

    @FindBy(xpath = "//li[@class='rss']/a")
    WebElement RSS;

    @FindBy(xpath = "//li[@class='youtube']/a")
    WebElement Youtube;

    @FindBy(className = "add-to-wishlist-button")
    List<WebElement> wishListBtn;

    @FindBy(xpath = "//p[@class='content']")
    public WebElement WishListMessage;

    @FindBy(xpath = ".//div[@class='bar-notification success']")
    public WebElement WishListMessageContainer;

    @FindBy(className = "ico-wishlist")
    public WebElement WishlistLink ;

    @FindBy(className = "close")
    public WebElement CloseX ;

    @FindBy(xpath = ".//div[@class='nivo-controlNav']/a[1]")
    WebElement SliderFirst;

    @FindBy(xpath = ".//div[@class='nivo-controlNav']/a[2]")
    WebElement SliderSecond;

    @FindBy(xpath = ".//div[@id='nivo-slider']/a[1]")
    WebElement SliderFirstImage;

    @FindBy(xpath = ".//div[@id='nivo-slider']/a[2]")
    WebElement SliderSecondImage;

    @FindBy(className = "ico-account")
    public WebElement myAccount;
    @FindBy(xpath = "//h2[@class='product-title']")
    public WebElement ProductName;

    @FindBy(className = "product-item")
    public List<WebElement> NumOfProducts;

    @FindBy(xpath = "//span[@class='price actual-price']")
    public WebElement euroIcon;

    @FindBy(xpath = ".//*[@class='page-title']/h1")
    public WebElement PageTitle;

    @FindBy(xpath = "//h2[@class='product-title']/a")
    List<WebElement> ProductNames;

    @FindBy(xpath = "//button[@class='button-2 product-box-add-to-cart-button']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//span[@class=\"wishlist-qty\"]")
    public WebElement Qty ;

    public P03_HomePage(WebDriver driver) {
        super(driver);
    }
    public void searchFun(String itemName) {
        ClickButtons(searchTextField);
        SendValue(searchTextField, itemName);
    }

    // search in home page top
    public void clickSearch() {
        ClickButtons(searchButton);
    }

    public void switchCurrency() {
        select = new Select(currencyList);
        select.selectByVisibleText("Euro");
    }
    public WebElement currBox(){
        return Hooks.driver.findElement(By.id("customerCurrency"));
    }

    public WebElement currentCurr(){
        WebElement cur = Hooks.driver.findElement(By.className("option[value=\"https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2Fregisterresult%2F1%3FreturnUrl%3D%2Fpasswordrecovery\""));
        return cur;
    }
    public void ClickAddToCart() {
        ClickButtons(addToCartBtn);
    }

    public void checkProductName(String CheckText) {
        for (int i = 0; i < ProductNames.size(); i++) {
            String name = ProductNames.get(i).getText();
            SoftAssert soft = new SoftAssert();
            soft.assertTrue(name.contains(CheckText));
            System.out.println(name);
            soft.assertAll();
        }
    }

    // open cateogry computers and sub Software
    public void hoverComputerMenu() {
        actions = new Actions(driver);
        actions.moveToElement(computers).perform();
        actions.moveToElement(Software).perform();
        actions.click().build().perform();
    }

    // open cateogry apparel  and sub Shoes
    public void OpenSubcateogryShoes() {
        actions = new Actions(driver);
        actions.moveToElement(apparel).perform();
        actions.moveToElement(Shoes).perform();
        actions.click().build().perform();
    }

    // open Social links
    public void OpenSocialLinks(String val) {
        if (val.equalsIgnoreCase("Facebook")) {
            ClickButtons(Facebook);
        } else if (val.equalsIgnoreCase("Twitter")) {
            ClickButtons(Twitter);
        } else if (val.equalsIgnoreCase("RSS")) {
            ClickButtons(RSS);
        } else if (val.equalsIgnoreCase("Youtube")) {
            ClickButtons(Youtube);
        }
    }

    // add product to wishlist
    @SuppressWarnings("deprecation")
	public void clickAddToWishList() throws InterruptedException {
        ClickButtons(wishListBtn.get(2));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // close any message
    public void CloseMessgae()
    {
        ClickButtons(CloseX);
    }

    // open Wishlist page
    public void OpenWishListPage()
    {
        ClickButtons(WishlistLink);
    }

    // fun to select slider and open the slider
    public void SelectSlider(String valS) throws InterruptedException {
        if(valS.equalsIgnoreCase("first"))
        {
            ClickButtons(SliderFirst);
            ClickButtons(SliderFirstImage);
        } else if (valS.equalsIgnoreCase("second"))
        {
            ClickButtons(SliderSecond);
            Thread.sleep(1000);
            ClickButtons(SliderSecondImage);
        }
    }


}

