package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchResultsPage {

    public static By search = By.cssSelector("#search [name='search']");

  public static By name = By.cssSelector(".fa-search");
 public static WebElement searchBtn = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(name));
 public static By resultSearch = By.cssSelector("h4>a");
 public static By addPurchase = By.cssSelector(".button-group .fa-shopping-cart");

public static void addFirstProduct(){
     WebElement addToCart = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(addPurchase));
        Elements.clickOnlyIfElementPresent(addToCart);

}
}
