package POM;

import Base.Elements;
import StepDefinitions.TutorialsLoginOnly;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TutHeadersSectionPage {
    static WebDriverWait wait;
    public TutHeadersSectionPage() {

        PageFactory.initElements(TutorialsLoginOnly.driver, this);
        wait =TutorialsLoginOnly.wait;
    }
 /*   @FindBy(css = ".fa-user")
    public static   WebElement accountEnterBtn;*/


public static By accountEnterBtn = By.cssSelector(".fa-user");
public static By loginBtn = By.linkText("Login");

public static By email = By.id("input-email");

public static By password = By.id("input-password");

public static By submit = By.xpath("//input[@type ='submit']");
public static By confirm = By.cssSelector("#content");
public static By registerBtn = By.linkText("Register");

public static void navigateToLoginPage(){
    WebElement account = wait.until(ExpectedConditions
            .visibilityOfElementLocated(TutHeadersSectionPage.accountEnterBtn));
    Elements.clickOnlyIfElementPresent(account);
    WebElement logIn = wait.until(ExpectedConditions
            .visibilityOfElementLocated(TutHeadersSectionPage.loginBtn));
    Elements.clickOnlyIfElementPresent(logIn);
}
}