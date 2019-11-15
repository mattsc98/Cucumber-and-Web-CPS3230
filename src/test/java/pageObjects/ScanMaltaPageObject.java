package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
