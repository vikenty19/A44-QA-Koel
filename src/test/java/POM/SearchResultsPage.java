package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static POM.CheckOutPage.negativeAlert;


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
public static void addOptionsOfOutOfStockProduct() throws InterruptedException, AWTException {
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
    //Uploading file from the computer using Robot class

    WebElement fileLoadBtn = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(load));
    fileLoadBtn.click();
//=== create path to the file on the computer
    String path = "attachment.png";
    //=== create object of Stringselection path to the loading file
    StringSelection stringSelection = new StringSelection(path);
    //=== emulate Cntrl+C keys command
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
    //=== Robot class to emulate Cntrl+V command on the computer to paste this path to open file
    Robot robot = new Robot();
    robot.delay(2000);
    robot.keyPress(KeyEvent.VK_CONTROL);
    robot.keyPress(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    robot.keyRelease(KeyEvent.VK_V);
    robot.delay(2000);//adding stability
    //===Robot emulate ENTER key
    robot.keyPress(KeyEvent.VK_ENTER);
    robot.keyRelease(KeyEvent.VK_ENTER);

    //alert accept
    //wait until alert is present
   BasePage.wait.until(ExpectedConditions.alertIsPresent());
    Alert alert = BasePage.driver.switchTo().alert();
    alert.accept();

    WebElement addToCart = BasePage.wait.until(ExpectedConditions
            .elementToBeClickable(add));
    Elements.clickOnlyIfElementPresent(addToCart);
    TutHeadersSectionPage.navigateToThShoppingCartPage();
 /*   String outOfStock = CheckOutPage.outOfStockWarningMessage();
    Assert.assertTrue(outOfStock.contains(
                    "Products marked with *** are not available in the desired quantity or not in stock!"));*/




}
}
