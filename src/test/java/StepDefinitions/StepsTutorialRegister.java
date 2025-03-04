package StepDefinitions;

import Base.Elements;
import POM.TutorialAccountSuccessPage;
import POM.TutorialRegisterPage;
import POM.TutHeadersSectionPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.Duration;

import static StepDefinitions.StepsToTutorialsLogin.driver;
import static StepDefinitions.StepsToTutorialsLogin.wait;

public class StepsTutorialRegister  {
  /*  @Given("I launch the app")
    public void iLaunchTheApp() {
    }*/
  // To initialise pages with @FindBy
  TutorialRegisterPage tutorialRegisterPage = new TutorialRegisterPage();
  TutHeadersSectionPage tutHeadersSectionPage = new TutHeadersSectionPage();
    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
        driver.findElement(tutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(tutHeadersSectionPage.registerBtn).click();
    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails(DataTable dataTable) {
    TutorialRegisterPage.enterAllDetails(dataTable);
    }

    @And("I check-in the Privacy Policy")
    public void iCheckInThePrivacyPolicy() {
      TutorialRegisterPage.agree.click();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
      TutorialRegisterPage.submitBtn.click();
    }

    @Then("I should see that the User Account has successfully been created")
    public void iShouldSeeThatTheUserAccountHasSuccessfullyBeenCreated() {
      Assert.assertTrue(wait
              .until(ExpectedConditions.visibilityOfElementLocated(TutorialAccountSuccessPage.successText))
              .isDisplayed());
      Assert.assertTrue(wait.until(ExpectedConditions
              .visibilityOfElementLocated(TutorialAccountSuccessPage.successCrumble)).isDisplayed());
    }
}
