package StepDefinitions;

import Base.Elements;
import POM.SearchResultsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static POM.SearchResultsPage.*;
import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class StepsSearch {
    @When("User search for a product {string}")
    public void userSearchForAProduct(String arg0) throws InterruptedException {
        Thread.sleep(1000);

        driver.navigate().refresh();
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        Elements.TypeText(searchField,arg0);
      //  searchField.sendKeys(arg0);
        WebElement searchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
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
