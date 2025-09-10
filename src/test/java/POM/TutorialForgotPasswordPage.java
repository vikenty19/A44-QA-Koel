package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class TutorialForgotPasswordPage {
    private WebDriver driver;
    public TutorialForgotPasswordPage(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    public static WebElement emailField = hooks.MyHooks.wait.until
            (ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));


    public static By continued = By.cssSelector("input.btn");
    public static WebElement continueBtn;

}
