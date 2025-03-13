package POM;

import StepDefinitions.TutorialsLoginOnly;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static StepDefinitions.TutorialsLoginOnly.tutorialURL;

public class Orders {
    @Given("I login to the app")
    public void iLoginToTheApp() {
        TutorialsLoginOnly.driver.get(tutorialURL);
    }

    @When("I add a product to a cart and check-out")
    public void iAddAProductToACartAndCheckOut() {
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
    }
}
