package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
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
        sleep(2);
    }

    public void invalidLogin(String username, String wrongPass) {
        browser.findElement(By.name("login[username]")).sendKeys(username);
        browser.findElement(By.name("login[password]")).sendKeys(wrongPass);
        browser.findElement(By.name("send")).submit();
        sleep(2);
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
        browser.get("https://www.scanmalta.com/newstore/checkout/cart/");
        sleep(3);
    }

    public void emptyCart() {
        goToCart();
        if(getCartAmount() != 0) {
            browser.findElement(By.id("empty_cart_button")).sendKeys("\n");
        }
        sleep(2);
    }

    public void addToCart() {
        browser.findElement(By.id("product-addtocart-button")).submit();
        //sleep(7); //due to popup that follows
    }

    public int getCartAmount() {
//        List<WebElement> cartList = browser.findElements(By.id("shopping-cart-table"));
//
//        //System.out.println("Number in cart " + items);  //test to see that cart got incremented
//
//        return cartList.size();
        String amount = browser.findElement(By.xpath("//span[contains(text(), 'items')]")).getText();
        return Integer.parseInt(amount.split(" ")[0]);
    }

    public void checkCartAmount(int int1) { // cartHasMultipleItems does the same thing
        int items = getCartAmount();
        //System.out.println("Number in cart " + items +" should contain " + int1); //test to see amount in cart and what it should have
        assertEquals(items, int1);
    }

//    public void selectMultipleProductsAndAddToCart(int int1) {
//        //create list to hold all the list item products displayed, then add to cart
//        emptyCart();
//        int i = 0;
//
//        /*
//        For some reason this method is no longer working. The first 4 items added
//        are fine, but when the loop reaches i=4 it simply doesn't find the item
//        and clicks on nothing, thus giving an error when trying to add to cart.
//        Manually doing WebElement product = productsList.get(4); works, just not
//        when it reaches 4 via the loop. Instead another method was created which
//        does the same thing only passes different search strings from a string
//        array.
//         */
//        do {
//            search("ssd");
//            List<WebElement> productsList = browser.findElements(By.className("item-images"));
//            System.out.println("Loop No. " + i);
//            WebElement product = productsList.get(i);
//            sleep(2);
//            product.click();
//            sleep(2);
//            addToCart();
//            i++;
//        }while(i != int1);
//    }

    public void selectMultipleProductsAndAddToCart2(int int1) {
        //create list to hold all the list items to search, then add to cart
        emptyCart();
        int i = 0;
        String[] productsSearch = {"ssd", "wire", "dell", "tower", "mouse",
                "keyboard", "laptop", "mac", "printer", "scanner"};
        do {
            search(productsSearch[i]);
            List<WebElement> productsList = browser.findElements(By.className("item-images"));
            System.out.println("Loop No. " + (i+1));
            WebElement product = productsList.get(0);
            product.click();
            sleep(2);
            addToCart();
            i++;
        }while(i != int1);
    }
//    public void cartHasMultipleItems(int int1) {
//        int items = getCartAmount();
//        //System.out.println("Number in cart " + items +" should contain " + int1); //test to see amount in cart and what it should have
//        assertEquals(items, int1);
//    }

    public void addTwoProducts() {
        search("ssd");
        selectFirstProduct();
        addToCart();

        search("adapter");
        selectFirstProduct();
        addToCart();
    }

    public void removeFirstProduct() {
        sleep(7); //due to popup that follows
        WebElement shoppingCartTable = browser.findElement(By.id("shopping-cart-table"));
        WebElement shoppingCartTableBody = shoppingCartTable.findElement(By.xpath("//table/tbody"));
        WebElement firstProduct = shoppingCartTableBody.findElement(By.className("first"));

        firstProduct.findElement(By.className("btn-remove")).click();
    }

}
