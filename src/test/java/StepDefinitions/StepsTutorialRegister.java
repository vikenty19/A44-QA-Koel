package StepDefinitions;

import Base.Elements;
import POM.RegisterPage;
import POM.TutHeadersSectionPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static StepDefinitions.StepsToTutorialsLogin.driver;

public class StepsTutorialRegister  {
  /*  @Given("I launch the app")
    public void iLaunchTheApp() {
    }*/
  // To initialise pages with @FindBy
  RegisterPage registerPage = new RegisterPage();
  TutHeadersSectionPage tutHeadersSectionPage = new TutHeadersSectionPage();
    @And("I navigate to Account Registration page")
    public void iNavigateToAccountRegistrationPage() {
        driver.findElement(tutHeadersSectionPage.accountEnterBtn).click();
        driver.findElement(tutHeadersSectionPage.registerBtn).click();
    }

    @When("I provide all the below valid details :")
    public void iProvideAllTheBelowValidDetails(DataTable dataTable) {
      Map<String,String> map =dataTable.asMap(String.class,String.class);
      Elements.TypeText(RegisterPage.firstName,map.get("FirstName"));
      Elements.TypeText(RegisterPage.lastName,map.get("LastName"));
      Elements.TypeText(RegisterPage.emailAddress,map.get("Email"));
      Elements.TypeText(RegisterPage.phone,map.get("Telephone"));
      Elements.TypeText(RegisterPage.passwordField,map.get("Password"));
      Elements.TypeText(RegisterPage.passwordConfirm,map.get("Password"));
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
