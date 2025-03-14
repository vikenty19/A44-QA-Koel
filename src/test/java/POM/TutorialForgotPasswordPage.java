package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.event.WindowFocusListener;

import static StepDefinitions.TutorialsLoginOnly.driver;


public class TutorialForgotPasswordPage {
    public TutorialForgotPasswordPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    public static WebElement emailField;
    @FindBy(css = "input.btn")
    public static WebElement continueBtn;

}
