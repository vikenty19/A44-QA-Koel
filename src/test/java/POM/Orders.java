package POM;

import Base.Elements;
import Config.PropertyFileReader;
import StepDefinitions.TutorialsLoginOnly;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.tutorialURL;

public class Orders {
    public WebDriverWait wait;
    @Given("I login to the app")
    public void iLoginToTheApp() throws InterruptedException {
        PropertyFileReader pfr = new PropertyFileReader();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(pfr.getUrl());
        driver.manage().window().maximize();

        WebElement account = wait.until(ExpectedConditions
                .visibilityOfElementLocated(TutHeadersSectionPage.accountEnterBtn));
        Elements.clickOnlyIfElementPresent(account);
        WebElement logIn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(TutHeadersSectionPage.loginBtn));
        Elements.clickOnlyIfElementPresent(logIn);
     //   TutHeadersSectionPage.navigateToLoginPage();
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
