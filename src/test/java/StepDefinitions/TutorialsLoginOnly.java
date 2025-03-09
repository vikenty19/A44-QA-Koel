package StepDefinitions;

import POM.TutHeadersSectionPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class TutorialsLoginOnly {

    public static WebDriverWait wait;
    public static WebDriver driver;
    public static String tutorialURL = "http://tutorialsninja.com/demo/";
    TutHeadersSectionPage tutHeadersSectionPage = new TutHeadersSectionPage();

    @Given("User opens application URL")
    public void userOpensApplicationURL() {
      /*  WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
         driver.manage().window().maximize();*/

       WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(tutorialURL);

        System.out.println("User open the URL");
    }

    @And("navigates om Login page")
    public void navigatesOmLoginPage() {
        driver.findElement(TutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(TutHeadersSectionPage.loginBtn).click();
    }

    @When("User enters valid email {string}")
    public void userEntersValidEmail(String email) {
        driver.findElement(tutHeadersSectionPage.email).sendKeys(email);

        System.out.println("User enters  " + email);
    }

    @And("Enters valid password {string}")
    public void entersValidPassword(String password) {
        driver.findElement(tutHeadersSectionPage.password).sendKeys(password);

        System.out.println("User enters   " + password);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        driver.findElement(tutHeadersSectionPage.submit).click();
        System.out.println("Click on login button");
    }

    @Then("User login successfully")
    public void userLoginSuccessfully() {
        WebElement confirm = driver.findElement(tutHeadersSectionPage.confirm);
        Assert.assertTrue(confirm.isDisplayed());
        System.out.println("User is logged in!!");
    }

    @Then("User should get a warning message")
    public void userShouldGetAWarningMessage() {
        System.out.println("You are NOT logged in!");
    }

    @And("Enters invalid password {string}")
    public void entersInvalidPassword(String invalidPassword) {
        System.out.println("user entered invalid password" + invalidPassword);
    }

    @When("User enters invalid email {string}")
    public void userEntersInvalidEmail(String email) {
        System.out.println("User enters invalid email  " + email);
    }

    @When("User doesn't enter any credentials")
    public void userDoesnTEnterAnyCredentials() {
    }

}
