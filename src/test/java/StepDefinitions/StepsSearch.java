package StepDefinitions;

import Base.BasePage;
import Base.Elements;
import POM.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static POM.SearchResultsPage.*;


public class StepsSearch {
    @When("User search for a product {string}")
    public void userSearchForAProduct(String arg0)  {

        WebElement searchField = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        Elements.TypeText(searchField,arg0);
        WebElement searchBtn = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        searchBtn.click();
    }

    @Then("User should see this product {string} in the search results")
    public void userShouldSeeThisProductInTheSearchResults(String message) {
        WebElement result = BasePage.wait.until(ExpectedConditions.presenceOfElementLocated(SearchResultsPage.resultSearch));
        String SearchResult = result.getText();
        Assert.assertEquals(SearchResult, message);
    }

    @Then("User should see a message {string}")
    public void userShouldSeeAMessage(String arg0) {
        System.out.println(arg0);
    }



}
