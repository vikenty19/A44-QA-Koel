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

import static POM.TutHeadersSectionPage.email;
import static POM.TutorialLoginPage.emailField;
import static POM.TutorialLoginPage.inputEmail;
import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.tutorialURL;

public class Orders {
    public WebDriverWait wait;
    public static WebDriver driver = BasePage.setUpDriver();
    @Given("I login to the app")
    public void iLoginToTheApp() throws InterruptedException {
        PropertyFileReader pfr = new PropertyFileReader();

        driver.get(pfr.getUrl());
        driver.manage().window().maximize();
        TutHeadersSectionPage.navigateToLoginPage();
        System.out.println(emailField);
       //  WebElement emailField = BasePage.wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));

        Elements.TypeText(emailField,pfr.getEmail());
       // emailField.sendKeys(pfr.getEmail());
        TutorialLoginPage.passwordField.sendKeys(pfr.getPassword());
        TutorialLoginPage.loginSubmitBtn.click();
        Thread.sleep(5000);
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
