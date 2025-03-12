package CucumberPOM;

import StepDefinitions.LoginStepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPassword_RegisterPage {

    public static By emailF = By.cssSelector("input[name='email']");
    public static WebElement emailToForgottenPass = LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(emailF));//
    public static By text = By.cssSelector("p .small");
    public static WebElement InfoMessage =LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(text));
    public static By sbmit = By.cssSelector("input#button");
    public static WebElement submitBtn = LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(sbmit));
    public static By info =By.cssSelector("div.errors");
    public static WebElement warningMessage=LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(info));
}
