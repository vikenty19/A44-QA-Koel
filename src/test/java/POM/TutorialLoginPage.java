package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static StepDefinitions.TutorialsLoginOnly.driver;

public class TutorialLoginPage {
    public TutorialLoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-email")
    public static WebElement emailField;
    @FindBy(id="input-password")
    public static WebElement passwordField;
    @FindBy(css = "input[type ='submit']")
    public static WebElement loginSubmitBtn;

}
