package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class ScanMaltaPageObject {

    WebDriver browser = null;

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {}
    }

    public ScanMaltaPageObject(WebDriver browser) {
        this.browser = browser;
    }

    public void getPage() {
        browser.get("https://www.scanmalta.com/newstore/customer/account/login/");
    }

    public void validLogin(String username, String password) {
        browser.findElement(By.name("login[username]")).sendKeys(username);
        browser.findElement(By.name("login[password]")).sendKeys(password);
        browser.findElement(By.name("send")).submit();
        sleep(2);
    }

    public void validateLogin() {
        assertTrue(browser.findElement(By.className("hello")).getText().contains("Hello, Matthew Schembri!"));
    }

    public void invalidLogin(String username, String wrongPass) {
        browser.findElement(By.name("login[username]")).sendKeys(username);
        browser.findElement(By.name("login[password]")).sendKeys(wrongPass);
        browser.findElement(By.name("send")).submit();
        sleep(3);
    }

    public void validateInvalidLogin() {
        assertTrue(browser.findElement(By.className("error-msg")).getText().contains("Invalid login or password."));
    }

    public void search(String product) {
        browser.findElement(By.id("search")).sendKeys(product);
        browser.findElement(By.className("icon-search")).submit();
        sleep(2);
    }

    public void selectFirstProduct() {
        //browser.findElement(By.xpath("/html/body/div[1]/div/section/ul/li[1]")).submit();
        //create list to hold all the list item products displayed, then retrieve the 1st one
        List<WebElement> productsList = browser.findElements(By.className("item-images"));
        WebElement firstProduct = productsList.get(0);
        firstProduct.click();
        sleep(2);
    }

    public void productDetailsFound() {
        assertTrue(browser.findElement(By.className("product-description")).getText().contains("Product Description"));
    }

    public void goToCart() {
        //browser.findElement(By.className("icon-cart")).submit(); CHECK THIS LATER
        browser.get("https://www.scanmalta.com/newstore/checkout/cart/");
        sleep(2);
    }

    public void emptyCart() {
        assertTrue(browser.findElement(By.className("page-title")).getText().contains("Shopping Cart is Empty"));
        sleep(2);
    }

    public void addToCart() {
        browser.findElement(By.id("product-addtocart-button")).submit();
        sleep(7); //due to popup that follows
    }

    public void viewCartAfterAdd() {
        List<WebElement> productsList = browser.findElements(By.className("data-table cart-table"));

        int items = productsList.size();
        System.out.println("Number in cart " + items);
    }

    public void cartHasOneItem(Integer int1) {
        //int items = viewCartAfterAdd();
        //System.out.println("Number in cart " + items);
    }

}
