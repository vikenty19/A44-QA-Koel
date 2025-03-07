package StepDefinitions;

import POM.MyAccountPage;
import POM.TutHeadersSectionPage;
import POM.TutorialLoginPage;
import POM.TutorialRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsTutorialLogin {
    @And("User navigate to Account Login page")
    public void userNavigateToAccountLoginPage() {
        driver.findElement(TutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(TutHeadersSectionPage.loginBtn).click();
    }
    @When("User login to the app using email {string} and password {string}")
    public void userLoginToTheAppUsingEmailAndPassword(String email, String password) {
        TutorialLoginPage.emailField.sendKeys(email);
        TutorialLoginPage.passwordField.sendKeys(password);
        TutorialLoginPage.loginSubmitBtn.click();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        Assert.assertTrue(MyAccountPage.accountBreadCrumb.isDisplayed());
    }


    @Then("User shouldn't be able to login successfully and see a warning message")
    public void userShouldnTBeAbleToLoginSuccessfullyAndSeeAWarningMessage() {
      //  By alert = By.cssSelector(".alert");
         WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
         Assert.assertEquals(warningMessage.getText(),);

    }
}

