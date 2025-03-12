package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static POM.SearchResultsPage.searchBtn;
import static POM.SearchResultsPage.searchField;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsSearch {
    @When("User search for a product {string}")
    public void userSearchForAProduct(String arg0) {
       // WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#search [name='search']")));
        searchField.sendKeys("Samsung SyncMaster 941BW");
       // WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-search")));
        searchBtn.click();
    }

    @Then("User should see this product in the search results")
    public void userShouldSeeThisProductInTheSearchResults() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4>a")));
        String SearchResult = result.getText();
        Assert.assertEquals(SearchResult,"Samsung SyncMaster 941BW");
    }
}
