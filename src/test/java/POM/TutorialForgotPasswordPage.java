package POM;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.WindowFocusListener;

import static Base.BasePage.driver;


public class TutorialForgotPasswordPage {
    public TutorialForgotPasswordPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    public static WebElement emailField = BasePage.wait.until
            (ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));


    public static By continued = By.cssSelector("input.btn");
    public static WebElement continueBtn;

}
