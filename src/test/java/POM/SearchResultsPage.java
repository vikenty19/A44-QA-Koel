package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class SearchResultsPage {

    public static By search = By.cssSelector("#search [name='search']");

  public static By name = By.cssSelector(".fa-search");
 public static WebElement searchBtn = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(name));
 public static By resultSearch = By.cssSelector("h4>a");
 public static By addPurchase = By.cssSelector(".button-group .fa-shopping-cart");
public static  By addToTheCart = By.id("button-cart");
public static By radio = By.cssSelector("div.radio input");
public static By check = By.xpath("//input[@value ='10']");
public static By text = By.id("input-option208");
public static By select = By.id("input-option217");
public static By field = By.id("input-option209");
public static By load = By.id("button-upload222");
public static By add = By.cssSelector("#button-cart.btn");

public static void addFirstProduct(){
     WebElement addToCart = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(addPurchase));
        Elements.clickOnlyIfElementPresent(addToCart);
        WebElement addItemToTheCart = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(addToTheCart));
      addItemToTheCart.click();

}
public static void addOptionsOfOutOfStockProduct() throws InterruptedException {
    WebElement radioBtn = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(radio));
    Elements.clickOnlyIfElementPresent(radioBtn);
    WebElement checkBox = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(check));
    Elements.clickOnlyIfElementPresent(checkBox);
    WebElement textField = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(text));
    Elements.TypeText(textField,"Test information");
    WebElement selectField =BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(select));
    Select select1 = new Select(selectField);
    select1.selectByIndex(3);
    WebElement enterTextField = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(field));
    Elements.TypeText(enterTextField,"I eager to have this comp!");
    WebElement fileLoadBtn = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(load));
    fileLoadBtn.click();
 /*   String path ="C:/Users/Acer/Desktop/attachment (7).png";
    fileLoadBtn.sendKeys(path)*/;
    WebElement addToCart = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(add));
    Elements.clickOnlyIfElementPresent(addToCart);
    Thread.sleep(9000);

}
}
