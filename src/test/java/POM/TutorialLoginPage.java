package POM;

import Config.PropertyFileReader;
import hooks.MyHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static POM.TutHeadersSectionPage.*;


public class TutorialLoginPage {
    private WebDriver driver;
    public TutorialLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
  public    static PropertyFileReader pfr = new PropertyFileReader();
  //  public static By inputEmail = By.id("input-email");
   // public static WebElement emailField = MyHooks.wait.until(ExpectedConditions.elementToBeClickable(inputEmail));
  //  public static WebElement emailField = driver.findElement(By.id("input-email"));
  //  public static By inputPassword = By.id("input-password");
    public static WebElement passwordField = hooks.MyHooks.wait
            .until(ExpectedConditions.elementToBeClickable(password));
    public static By submitLogin = By.cssSelector("input[type ='submit']");
    public static WebElement loginSubmitBtn = hooks.MyHooks.wait.until(ExpectedConditions.elementToBeClickable(submitLogin));
public static By forgot = By.cssSelector(".form-group>a");
   public static WebElement forgotPassword;
    public static By info = By.cssSelector(".alert");
    public static WebElement infoMessage = MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(info));
/*    public static void loginToTheApp(){
        PropertyFileReader pfr = new PropertyFileReader();
        WebElement emailField =  driver.findElement(email);
       Elements.TypeText(emailField,pfr.getEmail());
       WebElement passwordField = driver.findElement(password);
       Elements.TypeText(passwordField,pfr.getPassword());
        WebElement loginSubmitBtn =MyHooks.wait.until(ExpectedConditions.elementToBeClickable(submit));
       Elements.clickOnlyIfElementPresent(loginSubmitBtn);
    }*/
}
