package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static POM.SearchResultsPage.searchBtn;
import static POM.SearchResultsPage.searchField;
import static POM.SearchResultsPage.result;

public class StepsSearch {
    @When("User search for a product {string}")
    public void userSearchForAProduct(String arg0) {
        searchField.sendKeys("Samsung SyncMaster 941BW");
        searchBtn.click();
    }

    @Then("User should see this product in the search results")
    public void userShouldSeeThisProductInTheSearchResults() {

        String SearchResult = result.getText();
        Assert.assertEquals(SearchResult, "Samsung SyncMaster 941BW");
    }
}
