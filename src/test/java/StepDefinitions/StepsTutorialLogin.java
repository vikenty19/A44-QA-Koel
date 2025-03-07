package StepDefinitions;

import POM.TutHeadersSectionPage;
import POM.TutorialLoginPage;
import POM.TutorialRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static StepDefinitions.TutorialsLoginOnly.driver;

public class StepsTutorialLogin {
    @And("User navigate to Account Login page")
    public void userNavigateToAccountLoginPage() {
        driver.findElement(TutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(TutHeadersSectionPage.loginBtn).click();
    }

    @When("User login to the app using Username {string} and Password {string}")
    public void userLoginToTheAppUsingUsernameAndPassword(String email, String password) {
        TutorialLoginPage.emailField.sendKeys(email);
        TutorialLoginPage.passwordField.sendKeys(password);
        TutorialLoginPage.loginSubmitBtn.click();

    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
    }
}
