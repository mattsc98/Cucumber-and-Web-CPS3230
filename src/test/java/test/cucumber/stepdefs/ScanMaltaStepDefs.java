package test.cucumber.stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScanMaltaStepDefs {

    WebDriver browser = null;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/users/mark/Downloads/chromedriver");
        browser = new ChromeDriver();
    }

    @After
    public void teardown() {
        browser.quit();
    }


}
