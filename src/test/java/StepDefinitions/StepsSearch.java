package StepDefinitions;

import POM.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static POM.SearchResultsPage.searchBtn;
import static POM.SearchResultsPage.searchField;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsSearch {
    @When("User search for a product {string}")
    public void userSearchForAProduct(String arg0) {
        driver.navigate().refresh();
        searchField.sendKeys(arg0);
        searchBtn.click();
    }

    @Then("User should see this product in the search results")
    public void userShouldSeeThisProductInTheSearchResults() {
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(SearchResultsPage.resultSearch));
        String SearchResult = result.getText();
        Assert.assertEquals(SearchResult, "Samsung SyncMaster 941BW");
    }

    @Then("User should see a message {string}")
    public void userShouldSeeAMessage(String arg0) {
        System.out.println(arg0);
    }
}
