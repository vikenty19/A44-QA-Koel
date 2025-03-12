package StepDefinitions;

import POM.TutorialForgotPasswordPage;
import POM.TuturialMyAccountPage;
import POM.TutHeadersSectionPage;
import POM.TutorialLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static POM.TutHeadersSectionPage.accountEnterBtn;
import static POM.TutHeadersSectionPage.loginBtn;
import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsTutorialLogin {

    @And("User navigate to Account Login page")
    public void userNavigateToAccountLoginPage() {
        driver.findElement(By.cssSelector(".fa-user")).click();
        driver.findElement( By.linkText("Login")).click();
    }
    @When("User login to the app using email {string} and password {string}")
    public void userLoginToTheAppUsingEmailAndPassword(String email, String password) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-email")));
        emailField.sendKeys(email);
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-password")));
        passwordField.sendKeys(password);
        WebElement loginSubmitBtn =wait
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type ='submit']")));
        loginSubmitBtn.click();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        Assert.assertTrue(TuturialMyAccountPage.accountBreadCrumb.isDisplayed());
    }


    @Then("User shouldn't be able to login successfully and see a warning message")
    public void userShouldnTBeAbleToLoginSuccessfullyAndSeeAWarningMessage() {
      //  By alert = By.cssSelector(".alert");
        WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
        Assert.assertEquals(warningMessage.getText(),"Warning: No match for E-Mail Address and/or Password.");
        System.out.println("URAY!!");
    }
    @When("User reset forgotten password for email {string}")
    public void userResetForgottenPasswordForEmail(String email) {
        TutorialLoginPage.forgotPassword.click();
        TutorialForgotPasswordPage.emailField.sendKeys(email);
        TutorialForgotPasswordPage.continueBtn.click();
    }


    @Then("Use see a message that resetting info was sending to his email")
    public void useSeeAMessageThatResettingInfoWasSendingToHisEmail() {
        String message = TutorialLoginPage.infoMessage.getText();
        Assert.assertEquals(message,"An email with a confirmation link has been sent your email address.");

    }


}

