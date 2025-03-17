package POM;

import Base.BasePage;
import Base.Elements;
import Config.PropertyFileReader;
import StepDefinitions.TutorialsLoginOnly;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Base.BasePage.driver;

import static POM.TutHeadersSectionPage.*;
import static POM.TutorialLoginPage.*;
import static StepDefinitions.TutorialsLoginOnly.tutorialURL;

public class Orders {

    @Given("I login to the app")
    public void iLoginToTheApp() throws InterruptedException {
        PropertyFileReader pfr = new PropertyFileReader();
        BasePage.setUpDriver();
        driver.get(pfr.getUrl());
        TutHeadersSectionPage.navigateToLoginPage();
          loginToTheApp();

        Thread.sleep(5000);

    }
    public static void loginToTheApp(){
        PropertyFileReader pfr = new PropertyFileReader();
        WebElement emailField =  driver.findElement(email);
       Elements.TypeText(emailField,pfr.getEmail());
       WebElement passwordField = driver.findElement(password);
       Elements.TypeText(passwordField,pfr.getPassword());
        WebElement loginSubmitBtn =BasePage.wait.until(ExpectedConditions.elementToBeClickable(submit));
       Elements.clickOnlyIfElementPresent(loginSubmitBtn);
    }
    @When("I add a product to a cart and check-out")
    public void iAddAProductToACartAndCheckOut() {
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
    }
}
