package StepDefinitions;

import POM.TutorialAccountSuccessPage;
import POM.TutorialRegisterPage;
import hooks.MyHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static hooks.MyHooks.wait;


public class StepsTutorialRegister  {
  TutorialRegisterPage tutorialRegisterPage = new TutorialRegisterPage(hooks.MyHooks.driver);


    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
      WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'My Account')]")));
       myAccount.click();
       hooks.MyHooks.driver.findElement(By.linkText("Register")).click();

    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails(DataTable dataTable) {
      System.out.println("Driver  "+ hooks.MyHooks.driver);
     System.out.println("Locator "+ tutorialRegisterPage.firstNameField);
        tutorialRegisterPage.firstNameField.click();
     /*WebElement firstNameField = MyHooks.wait
              .until(ExpectedConditions.elementToBeClickable(By.id("input-firstname")));*/
     tutorialRegisterPage.firstNameField.sendKeys("raviiii");
    tutorialRegisterPage.enterAllDetails(dataTable,"unique");
    }

    @And("I check-in the Privacy Policy")
    public void iCheckInThePrivacyPolicy() {
      tutorialRegisterPage.agree.click();
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
      tutorialRegisterPage.submitBtn.click();
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
    softAssert.assertEquals(tutorialRegisterPage
            .lastNameWarning.getText(),"Last Name must be between 1 and 32 characters!");
    softAssert.assertEquals(tutorialRegisterPage
            .emailWarning.getText(),"E-Mail Address does not appear to be valid!");
    softAssert.assertEquals(tutorialRegisterPage
            .phoneWarning.getText(),"Telephone must be between 3 and 32 characters!");
  softAssert.assertEquals(tutorialRegisterPage
            .passwordWarning.getText(),"Password must be between 4 and 20 characters!");
  softAssert.assertEquals(tutorialRegisterPage
            .mainWarning.getText(),"Warning: You must agree to the Privacy Policy!");
    softAssert.assertAll();


  }

  @And("I check-in the Subscription radio button")
  public void iCheckInTheSubscriptionRadioButton() {
      tutorialRegisterPage.subscriptionBtn.click();
  }

  @When("I provide duplicated details")
  public void iProvideDuplicatedDetails(DataTable dataTable) {
      tutorialRegisterPage.enterAllDetails(dataTable,"duplicate");
  }

  @Then("I should see that the User Account is restricted from creating duplicate account")
  public void iShouldSeeThatTheUserAccountIsRestrictedFromCreatingDuplicateAccount() {

      Assert.assertEquals(tutorialRegisterPage
              .mainWarning.getText(),"Warning: E-Mail Address is already registered!");
  }
}
