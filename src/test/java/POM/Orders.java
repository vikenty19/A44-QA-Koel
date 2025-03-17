package POM;

import Base.BasePage;
import Base.Elements;
import Config.PropertyFileReader;
import StepDefinitions.StepsSearch;
import StepDefinitions.TutorialsLoginOnly;
import io.cucumber.java.an.E;
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

import static POM.SearchResultsPage.*;
import static POM.TutHeadersSectionPage.*;
import static POM.TutorialLoginPage.*;
import static StepDefinitions.TutorialsLoginOnly.tutorialURL;

public class Orders {
    static PropertyFileReader pfr = new PropertyFileReader();

    @Given("I login to the app")
    public void iLoginToTheApp() throws InterruptedException {

        BasePage.setUpDriver();
        driver.get(pfr.getUrl());
        TutHeadersSectionPage.navigateToLoginPage();
        loginToTheApp();

    }

    public static void loginToTheApp() {

        WebElement emailField = driver.findElement(email);
        Elements.TypeText(emailField, pfr.getEmail());
        WebElement passwordField = driver.findElement(password);
        Elements.TypeText(passwordField, pfr.getPassword());
        WebElement loginSubmitBtn = BasePage.wait.until(ExpectedConditions.elementToBeClickable(submit));
        Elements.clickOnlyIfElementPresent(loginSubmitBtn);

    }

    @When("I add a product to a cart and check-out")
    public void iAddAProductToACartAndCheckOut() throws InterruptedException {

        System.out.println(pfr.getProduct());
        TutHeadersSectionPage.searchProduct();
        SearchResultsPage.addFirstProduct();
       /* WebElement addToCart = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(addPurchase));
        Elements.clickOnlyIfElementPresent(addToCart);*/
        Thread.sleep(4000);//.button-group .fa-shopping-cart

    }

    @And("I place the order")
    public void iPlaceTheOrder() {
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
    }
}
