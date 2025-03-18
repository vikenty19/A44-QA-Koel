package POM;

import Base.BasePage;
import Base.Elements;
import Config.PropertyFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Base.BasePage.driver;

import static POM.TutHeadersSectionPage.*;

public class Orders {
    static PropertyFileReader pfr = new PropertyFileReader();

    @Given("I login to the app")
    public void iLoginToTheApp()  {

        BasePage.setUpDriver();
        driver.get(pfr.getUrl());
        TutHeadersSectionPage.navigateToLoginPage();
        loginToTheApp();

    }



    @When("I add a product to a cart and check-out")
    public void iAddAProductToACartAndCheckOut() throws InterruptedException {

        System.out.println(pfr.getProduct());
        TutHeadersSectionPage.searchProduct();
        SearchResultsPage.addFirstProduct();
        TutHeadersSectionPage.navigateToThShoppingCartPage();
        ShoppingCartPage.navigateToCheckOutPage();
         Thread.sleep(4000);

    }

    @And("I place the order")
    public void iPlaceTheOrder() {
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
    }
    public static void loginToTheApp() {

        WebElement emailField = driver.findElement(email);
        Elements.TypeText(emailField, pfr.getEmail());
        WebElement passwordField = driver.findElement(password);
        Elements.TypeText(passwordField, pfr.getPassword());
        WebElement loginSubmitBtn = BasePage.wait.until(ExpectedConditions.elementToBeClickable(submit));
        Elements.clickOnlyIfElementPresent(loginSubmitBtn);

    }
}
