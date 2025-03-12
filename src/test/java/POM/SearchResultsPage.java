package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class SearchResultsPage {
    public SearchResultsPage(){
        PageFactory.initElements(driver,this);
    }
    public static By search = By.cssSelector("#search [name='search']");
  public static   WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(search));
  public static By name = By.cssSelector(".fa-search");
 public static WebElement searchBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
  //  @FindBy(css = ".fa-search")
// public static WebElement searchBtn;
}
