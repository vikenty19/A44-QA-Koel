package StepDefinitions;

import POM.TutorialAccountSuccessPage;
import POM.TutorialRegisterPage;
import POM.TutHeadersSectionPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsTutorialRegister  {
  /*  @Given("I launch the app")
    public void iLaunchTheApp() {
    }*/
  // To initialise pages with @FindBy

  TutHeadersSectionPage tutHeadersSectionPage = new TutHeadersSectionPage();
    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
        driver.findElement(tutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(tutHeadersSectionPage.registerBtn).click();
    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails(DataTable dataTable) {
      WebElement firstNameField = wait
              .until(ExpectedConditions.elementToBeClickable(By.id("input-firstname")));
     firstNameField.sendKeys("raviiii");
    TutorialRegisterPage.enterAllDetails(dataTable,"unique");
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

  @Then("I should see that the User Account is not created")
  public void iShouldSeeThatTheUserAccountIsNotCreated() {
    Assert.assertTrue(wait.until(ExpectedConditions
            .visibilityOfElementLocated(TutorialRegisterPage.registerBreadCrumb)).isDisplayed());
  }

  @And("I should see the error messages informing the user to fill the mandatory fields")
  public void iShouldSeeTheErrorMessagesInformingTheUserToFillTheMandatoryFields() {
    SoftAssert softAssert=new SoftAssert();
   // softAssert.assertEquals(TutorialRegisterPage
          //  .firstNameWarning.getText(),"First Name must be between 1 and 32 characters!");
    softAssert.assertEquals(TutorialRegisterPage
            .lastNameWarning.getText(),"Last Name must be between 1 and 32 characters!");
    softAssert.assertEquals(TutorialRegisterPage
            .emailWarning.getText(),"E-Mail Address does not appear to be valid!");
    softAssert.assertEquals(TutorialRegisterPage
            .phoneWarning.getText(),"Telephone must be between 3 and 32 characters!");
  softAssert.assertEquals(TutorialRegisterPage
            .passwordWarning.getText(),"Password must be between 4 and 20 characters!");
  softAssert.assertEquals(TutorialRegisterPage
            .mainWarning.getText(),"Warning: You must agree to the Privacy Policy!");
    softAssert.assertAll();


  }

  @And("I check-in the Subscription radio button")
  public void iCheckInTheSubscriptionRadioButton() {
      TutorialRegisterPage.subscriptionBtn.click();
  }

  @When("I provide duplicated details")
  public void iProvideDuplicatedDetails(DataTable dataTable) {
      TutorialRegisterPage.enterAllDetails(dataTable,"duplicate");
  }

  @Then("I should see that the User Account is restricted from creating duplicate account")
  public void iShouldSeeThatTheUserAccountIsRestrictedFromCreatingDuplicateAccount() {

      Assert.assertEquals(TutorialRegisterPage
              .mainWarning.getText(),"Warning: E-Mail Address is already registered!");
  }
}
