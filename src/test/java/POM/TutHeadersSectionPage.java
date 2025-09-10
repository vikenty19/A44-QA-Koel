package POM;


import Base.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static StepDefinitions.Orders.pfr;

public class TutHeadersSectionPage {

    public TutHeadersSectionPage() {

        PageFactory.initElements(hooks.MyHooks.driver, this);

    }

public static By accountEnterBtn = By.cssSelector(".fa-user");
public static By loginBtn = By.linkText("Login");

public static By email = By.id("input-email");

public static By password = By.id("input-password");

public static By submit = By.xpath("//input[@type ='submit']");
public static By searchType = By.cssSelector("input[name ='search']");
    public static By searchClick = By.cssSelector(".fa-search");
public static By confirm = By.cssSelector("#content");
public static WebElement searchField = hooks.MyHooks.wait.until(ExpectedConditions
        .elementToBeClickable(searchType));
public static By registerBtn = By.linkText("Register");
public static By shopCart = By.cssSelector("[title ='Shopping Cart']");

public static void navigateToLoginPage(){

    WebElement account = hooks.MyHooks.wait.until(ExpectedConditions
            .visibilityOfElementLocated(accountEnterBtn));
    Elements.clickOnlyIfElementPresent(account);
    WebElement logIn = hooks.MyHooks.wait.until(ExpectedConditions
            .visibilityOfElementLocated(TutHeadersSectionPage.loginBtn));
    Elements.clickOnlyIfElementPresent(logIn);
}
public static void searchProduct(){
     WebElement searchField = hooks.MyHooks.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchType));
        Elements.TypeText(searchField, pfr.getProduct());
        WebElement searchBtn = hooks.MyHooks.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchClick));
        Elements.clickOnlyIfElementPresent(searchBtn);
}
    public static void searchProduct(String product){
        WebElement searchField =hooks.MyHooks.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchType));
        Elements.TypeText(searchField, product);
        WebElement searchBtn = hooks.MyHooks.wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchClick));
        Elements.clickOnlyIfElementPresent(searchBtn);
    }

    public static void navigateToThShoppingCartPage(){
        WebElement shoppingCart = hooks.MyHooks.wait.until(ExpectedConditions
                .visibilityOfElementLocated(shopCart));
        Elements.clickOnlyIfElementPresent(shoppingCart);
    }
}