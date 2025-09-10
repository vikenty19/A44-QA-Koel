package StepDefinitions;

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
import org.testng.Assert;

import java.awt.*;

;

import static POM.TutHeadersSectionPage.*;

public class Orders {
    public static PropertyFileReader pfr = new PropertyFileReader();
    CheckOutPage checkOutPage = new CheckOutPage(hooks.MyHooks.driver);
    @Given("I login to the app")
    public void iLoginToTheApp()  {


        hooks.MyHooks.driver.get(pfr.getUrl());
        TutHeadersSectionPage.navigateToLoginPage();
        loginToTheApp();

    }



    @When("I add a product to a cart and check-out")
    public void iAddAProductToACartAndCheckOut() throws InterruptedException {

        System.out.println(pfr.getProduct());
        TutHeadersSectionPage.searchProduct();
        SearchResultsPage.addFirstProduct();
        TutHeadersSectionPage.navigateToThShoppingCartPage();
        checkOutPage.navigateToCheckOutPage();


    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        checkOutPage.placeTheOrder();
    }

    @Then("I should see that the order is placed successfully")
    public void iShouldSeeThatTheOrderIsPlacedSuccessfully() {
        OrdersSuccessPage.orderSuccessConfirmation();
    }
    public static void loginToTheApp() {

        WebElement emailField = hooks.MyHooks.driver.findElement(email);
        Elements.TypeText(emailField, pfr.getEmail());
        WebElement passwordField = hooks.MyHooks.driver.findElement(password);
        Elements.TypeText(passwordField, pfr.getPassword());
        WebElement loginSubmitBtn = hooks.MyHooks.wait.until(ExpectedConditions.elementToBeClickable(submit));
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
        String outOfStock = checkOutPage.outOfStockWarningMessage();
        Assert.assertTrue(outOfStock.contains(
                "Products marked with *** are not available in the desired quantity or not in stock!"));
    }
}
