package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static StepDefinitions.StepsToTutorialsLogin.driver;

public class RegisterPage {
    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name =firstname]")
    public static WebElement firstName;
    // public By firstName = By.cssSelector("[name =firstname]");
    @FindBy(id = "input-lastname")
    public static WebElement lastName;
    @FindBy(id = "input-email")
    public static WebElement emailAddress;
    @FindBy(id = "input-telephone")
    public static WebElement phone;
    @FindBy(id = "input-password")
    public static WebElement passwordField;
    @FindBy(id = "input-confirm")
    public static WebElement passwordConfirm;
    @FindBy(id = "[name ='agree']")
    public static WebElement agree;
    @FindBy(css = "input[type ='submit']")
    public static WebElement submitBtn;

}
