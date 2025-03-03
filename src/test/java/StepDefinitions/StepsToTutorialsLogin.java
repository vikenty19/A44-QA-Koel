package StepDefinitions;

import POM.TutHeadersSection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;



public class StepsToTutorialsLogin {

   public static WebDriver driver;
    public static String tutorialURL ="http://tutorialsninja.com/demo/";
    TutHeadersSection tutHeadersSection = new TutHeadersSection();
    @Given("User opens application URL")
    public void userOpensApplicationURL() {


           WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            driver.get(tutorialURL);

        System.out.println("User open the URL");
    }

    @And("navigates om Login page")
    public void navigatesOmLoginPage() {
     driver.findElement(tutHeadersSection.accountEnterBtn).click();

    }

    @When("User enters valid email {string}")
    public void userEntersValidEmail(String email) {
        System.out.println("User enters  " + email);
    }

    @And("Enters valid password {string}")
    public void entersValidPassword(String password) {
        System.out.println("User enters   " + password);
    }

    @And("Click on login button")
    public void clickOnLoginButton() {
        System.out.println("Click on login button");
    }

    @Then("User login successfully")
    public void userLoginSuccessfully() {
        System.out.println("User is logged in!!");
    }

    @Then("User should get a warning message")
    public void userShouldGetAWarningMessage() {
        System.out.println("You are NOT logged in!");
    }

    @And("Enters invalid password {string}")
    public void entersInvalidPassword(String invalidPassword) {
        System.out.println("user entered invalid password"+invalidPassword );
    }

    @When("User enters invalid email {string}")
    public void userEntersInvalidEmail(String email) {
        System.out.println("User enters invalid email  " + email);
    }

    @When("User doesn't enter any credentials")
    public void userDoesnTEnterAnyCredentials() {
    }
}
