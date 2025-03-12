package StepDefinitions;

import CucumberPOM.TestData;
import POM.HomePage;
import POM.LoginPage;
import hooks.MyHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
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
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

import static CucumberPOM.ForgotPassword_RegisterPage.InfoMessage;
import static CucumberPOM.ForgotPassword_RegisterPage.emailToForgottenPass;
import static CucumberPOM.LoginPageCucumber.*;
import static hooks.Base.driver;

public class LoginStepDefinitions  {
   //  public static WebDriver driver;
  // public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    public static String url ="https://qa.koel.app/";
<<<<<<< Updated upstream
    public static String registerUrl ="https://qa.koel.app/registration";
    public static WebDriverWait wait = null;
  @After
=======
  //  public static WebDriverWait wait = null;
 /* @After
>>>>>>> Stashed changes
    public void tearDown() {
        driver.quit();
    }
   @Given ("I open browser")
    public void setUpDriver(){
       MyHooks.setUpDriver();
 /*       WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");

          driver = new ChromeDriver(options);*/

       System.out.println("SetUpDriver");
    }
    @When("I open login page")
    public void iOpenLoginPage(){
        driver.get(url);
    }
    @And("i enter valid email {string}")
    public void iEnterEmail(String email){

       emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);

    }
    @And("I enter valid password {string}")
    public void iEnterPassword(String password) {
       // Other declaration in cucumberPOM brings "stale element exception"
        WebElement passwordInput=LoginStepDefinitions
                .wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(password);

    }

    @And("I click Submit")
    public void iClickSubmit(){

     LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
           }


    @Then("I am logged in")
    public void iLoggedIn(){

        HomePage homePage = new HomePage(driver);
       Assert.assertTrue(homePage.getAvatar());
    }




    @And("I enter wrong email {string}")
    public void iEnterWrongEmail(String email) {
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(email);
    }




    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        LoginPage loginpage = new LoginPage(driver);
               System.out.println("Is Submit button is displayed?  " + loginpage.isSubmitLoginBtnDisplayed());
        Assert.assertTrue(loginpage.isSubmitLoginBtnDisplayed());
    }


    @And("I enter details below into fields:")
    public void iEnterDetailsBelowIntoFields(DataTable dataTable) {
       Map<String,String> map  =  dataTable.asMap(String.class,String.class);
        System.out.println("Table data");
    //email
        WebElement emailInput = driver.findElement(By.cssSelector("[type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys(map.get("email"));
    //password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(map.get("password"));
    }


    @When("I click the  forgot password link")
    public void iClickTheForgotPasswordLink() {
        WebElement forgotPassLink = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(link));
      forgotPassLink.click();

    }

    @And("I enter my registered email {string}")
    public void iEnterMyRegisteredEmail(String email) {
        WebElement emailToForgottenPass = LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='email']")));
        emailToForgottenPass.sendKeys(email);
    }




    @And("I logs in with email {string} and password {string}")
    @Test(dataProvider = "LoginData",dataProviderClass = TestData.class)
    public void iLogsInWithEmailAndPassword(String emailF, String passwordF) {
        System.out.println(emailF+ "   "+passwordF);
        WebElement passwordInput=LoginStepDefinitions
                .wait.until(ExpectedConditions.visibilityOfElementLocated(pass));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys(passwordF);
        WebElement emailField= LoginStepDefinitions.wait
                .until(ExpectedConditions.visibilityOfElementLocated(email));

        emailField.sendKeys(emailF);
    }
    /*WebElement emailInput = loginPage.waitUntilVisible(By.cssSelector("[type='email']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String message = (String) js.executeScript("return arguments[0].validationMessage", emailInput);
        String lang = (String) js.executeScript("return navigator.language");
        System.out.println(message);
        System.out.println(lang);
        Assert.assertTrue(message.contains("@"));*/
}

