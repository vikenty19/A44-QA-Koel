package StepDefinitions;

import Base.BasePage;
import Base.Elements;
import Config.PropertyFileReader;
import POM.OrdersSuccessPage;
import POM.SearchResultsPage;
import POM.CheckOutPage;
import POM.TutHeadersSectionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;

import static Base.BasePage.driver;

import static POM.TutHeadersSectionPage.*;

public class Orders {
    public static PropertyFileReader pfr = new PropertyFileReader();

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
        CheckOutPage.navigateToCheckOutPage();


    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        CheckOutPage.placeTheOrder();
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
        OrdersSuccessPage.orderSuccessConfirmation();
    }
    public static void loginToTheApp() {

        WebElement emailField = driver.findElement(email);
        Elements.TypeText(emailField, pfr.getEmail());
        WebElement passwordField = driver.findElement(password);
        Elements.TypeText(passwordField, pfr.getPassword());
        WebElement loginSubmitBtn = BasePage.wait.until(ExpectedConditions.elementToBeClickable(submit));
        Elements.clickOnlyIfElementPresent(loginSubmitBtn);

    }

    @When("I add an out-of-stock product to a cart and check-out")
    public void iAddAnOutOfStockProductToACartAndCheckOut() throws InterruptedException, AWTException {
        System.out.println(pfr.getProduct("outOfStockProduct"));
        TutHeadersSectionPage.searchProduct(pfr.getProduct("outOfStockProduct"));
        SearchResultsPage.addFirstProduct();
        SearchResultsPage.addOptionsOfOutOfStockProduct();

    }

    @Then("I should see the message that this product is out-of-stock")
    public void iShouldSeeTheMessageThatThisProductIsOutOfStock() {
    }
}
