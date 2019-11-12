package test.cucumber.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScanMaltaStepDefs {

    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void openBrowser() {
        driver = new ChromeDriver();
    }

    @When("^I open Ebay website$")
    public void goToEbay() {
        driver.navigate().to("https://www.scanmalta.com/newstore/");
    }

    @Then("^Login button should exits$")
    public void loginButton() {
        if(driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div[2]/a[3]")).isEnabled()) {
            System.out.println("Test 1 Pass");
        } else {
            System.out.println("Test 1 Fail");
        }
        driver.close();
    }

}
