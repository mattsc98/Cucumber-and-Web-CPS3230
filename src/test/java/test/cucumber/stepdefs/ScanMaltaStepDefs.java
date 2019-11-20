package test.cucumber.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.ScanMaltaPageObject;

import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class ScanMaltaStepDefs {

    WebDriver browser = null;
    public ScanMaltaPageObject sut;

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {}
    }

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/matts/Downloads/chromedriver.exe");
        browser = new ChromeDriver();
        sut = new ScanMaltaPageObject(browser);
    }

    @After
    public void teardown() {
        browser.quit();
    }

    @Given("I am a user on the website")
    public void i_am_a_user_on_the_website() {
        sut.getPage();
        //browser.get("https://www.scanmalta.com/newstore/customer/account/login/");
        //sleep(5);
    }

    @When("I log in using valid credentials {string} and {string}")
    public void i_log_in_using_valid_credentials(String username, String password) {
//        browser.findElement(By.name("login[username]")).sendKeys(username);
//        browser.findElement(By.name("login[password]")).sendKeys(password);
//        browser.findElement(By.name("send")).submit();
//        sleep(2);
        sut.validLogin(username, password);
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
//        assertTrue(browser.findElement(By.className("hello")).getText().contains("Hello, Matthew Schembri!"));
        sut.validateLogin();
    }

    @When("I log in using invalid credentials {string} and {string}")
    public void i_log_in_using_invalid_credentials_and(String username, String wrongPass) {
//        browser.findElement(By.name("login[username]")).sendKeys(username);
//        browser.findElement(By.name("login[password]")).sendKeys(wrongPass);
//        browser.findElement(By.name("send")).submit();
//        sleep(2);
        sut.invalidLogin(username, wrongPass);
    }

    @Then("I should not be logged in")
    public void i_should_not_be_logged_in() {
        //assertTrue(browser.findElement(By.className("error-msg")).getText().contains("Invalid login or password."));
        sut.validateInvalidLogin();
    }

    @Given("I am a logged in user on the website {string} and {string}")
    public void i_am_a_logged_in_user_on_the_website(String username, String password) {
        sut.getPage();
        sut.validLogin(username, password);
    }

    @When("I search for a product {string}")
    public void i_search_for_a_product(String product) {
        sut.search(product);
    }

    @When("I select the first product in the list")
    public void i_select_the_first_product_in_the_list() {
        sut.selectFirstProduct();
    }

    @Then("I should see the product details")
    public void i_should_see_the_product_details() {
        sut.productDetails();
    }




}
