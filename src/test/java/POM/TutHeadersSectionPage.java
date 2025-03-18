package POM;

import Base.BasePage;
import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Base.BasePage.driver;
import static Base.BasePage.wait;
import static StepDefinitions.Orders.pfr;

public class TutHeadersSectionPage {

    public TutHeadersSectionPage() {

        PageFactory.initElements(driver, this);

    }

public static By accountEnterBtn = By.cssSelector(".fa-user");
public static By loginBtn = By.linkText("Login");

public static By email = By.id("input-email");

public static By password = By.id("input-password");

public static By submit = By.xpath("//input[@type ='submit']");
public static By searchType = By.cssSelector("input[name ='search']");
    public static By searchClick = By.cssSelector(".fa-search");
public static By confirm = By.cssSelector("#content");
public static WebElement searchField = wait.until(ExpectedConditions
        .elementToBeClickable(searchType));
public static By registerBtn = By.linkText("Register");
public static By shopCart = By.cssSelector("[title ='Shopping Cart']");

public static void navigateToLoginPage(){

    WebElement account = BasePage.wait.until(ExpectedConditions
            .visibilityOfElementLocated(accountEnterBtn));
    Elements.clickOnlyIfElementPresent(account);
    WebElement logIn = BasePage.wait.until(ExpectedConditions
            .visibilityOfElementLocated(TutHeadersSectionPage.loginBtn));
    Elements.clickOnlyIfElementPresent(logIn);
}
public static void searchProduct(){
     WebElement searchField = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchType));
        Elements.TypeText(searchField, pfr.getProduct());
        WebElement searchBtn = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchClick));
        Elements.clickOnlyIfElementPresent(searchBtn);
}

    public static void navigateToThShoppingCartPage(){
        WebElement shoppingCart = BasePage.wait.until(ExpectedConditions
                .visibilityOfElementLocated(shopCart));
        Elements.clickOnlyIfElementPresent(shoppingCart);
    }
}