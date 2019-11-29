package Task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

class ScanMaltaSystem {

     WebDriver browser;

    private boolean
            loggedIn = false,
            loggedOut = true,
            searching = false,
            addingToCart = false,
            removingFromCart = false,
            checkingOut = false;

    public ScanMaltaSystem(WebDriver browser) {
        this.browser = browser;
        browser.get("https://www.scanmalta.com/newstore/customer/account/login/");
    }

    boolean isLoggedIn() throws InterruptedException {
//        return loggedIn;
        sleep(2);
        return browser.findElement(By.className("hello")).getText().contains("Hello, Matthew Schembri!");
    }

    boolean isLoggedOut() {
        return loggedOut;
    }

    boolean isSearching() {
        return searching;
    }

    boolean isAddingToCart() {
        return addingToCart;
    }

    boolean isRemovingFromCart() {
        return removingFromCart;
    }

    boolean isCheckingOut() {
        return checkingOut;
    }

    void loggingIn() throws InterruptedException {
//        if (loggedIn && !loggedOut && !searching && !addingToCart && !removingFromCart && !checkingOut) {
//farseersc28@gmail.com" and "Test@123"
//        }
        browser.findElement(By.name("login[username]")).sendKeys("farseersc28@gmail.com");
        browser.findElement(By.name("login[password]")).sendKeys("Test@123");
        browser.findElement(By.name("send")).submit();
        sleep(2);
    }

    void loggingOut() {
        if (!loggedIn && loggedOut && !searching && !addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
        }
    }

    void searchItem() {
        if (!loggedIn && !loggedOut && searching && !addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            searching = true;
        }
    }

    void addToCart() {
        if (!loggedIn && !loggedOut && !searching && addingToCart && !removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            addingToCart = true;
        }
    }

    void removeFromCart() {
        if (!loggedIn && !loggedOut && !searching && !addingToCart && removingFromCart && !checkingOut) {
            loggedOut = false;
            loggedIn = true;
            removingFromCart = true;
        }
    }

    void checkout() {
        if (!loggedIn && !loggedOut && !searching && !addingToCart && !removingFromCart && checkingOut) {
            loggedOut = false;
            loggedIn = true;
            checkingOut = true;
        }
    }


}
