package POM;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static StepDefinitions.TutorialsLoginOnly.driver;


public class TutorialLoginPage {
    public TutorialLoginPage(){
        PageFactory.initElements(driver,this);
    }
    public static By inputEmail = By.id("input-email");
   // public static WebElement emailField = BasePage.wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
    public static WebElement emailField = BasePage.driver.findElement(By.id("input-email"));
    public static By inputPassword = By.id("input-password");
    public static WebElement passwordField = BasePage.wait
            .until(ExpectedConditions.elementToBeClickable(inputPassword));
    public static By submitLogin = By.cssSelector("input[type ='submit']");
    public static WebElement loginSubmitBtn =BasePage.wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
public static By forgot = By.cssSelector(".form-group>a");
   public static WebElement forgotPassword;
    public static By info = By.cssSelector(".alert");
    public static WebElement infoMessage = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(info));

}
