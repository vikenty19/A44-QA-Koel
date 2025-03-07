package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class TutorialLoginPage {
    public TutorialLoginPage(){
        PageFactory.initElements(driver,this);
    }
    public static By inputEmail = By.id("input-email");
    public static WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
    public static By inputPassword = By.id("input-password");
    public static WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(inputPassword));
    public static By submitLogin = By.cssSelector("input[type ='submit']");
    public static WebElement loginSubmitBtn =wait.until(ExpectedConditions.elementToBeClickable(submitLogin));

}
