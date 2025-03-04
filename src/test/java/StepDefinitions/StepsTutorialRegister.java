package StepDefinitions;

import POM.TutHeadersSection;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.StepsToTutorialsLogin.driver;

public class StepsTutorialRegister  {
  /*  @Given("I launch the app")
    public void iLaunchTheApp() {
    }*/
  TutHeadersSection tutHeadersSection = new TutHeadersSection();
    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
        driver.findElement(tutHeadersSection.accountEnterBtn).click();
        driver.findElement(tutHeadersSection.registerBtn).click();
    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails(DataTable dataTable) {
    }

    @And("I check-in the Privacy Policy")
    public void iCheckInThePrivacyPolicy() {
    }

    @And("I click on continue button")
    public void iClickOnContinueButton() {
    }

    @Then("I should see that the User Account has successfully been created")
    public void iShouldSeeThatTheUserAccountHasSuccessfullyBeenCreated() {
    }
}
