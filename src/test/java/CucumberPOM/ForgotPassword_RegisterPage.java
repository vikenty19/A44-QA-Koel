package CucumberPOM;

import StepDefinitions.LoginStepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotPassword_RegisterPage {
    public static By email = By.cssSelector("input[type='email']");
    public static WebElement emailToForgottenPass = LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(email));//
    public static By text = By.cssSelector("p .small");
    public static WebElement InfoMessage =LoginStepDefinitions.wait
            .until(ExpectedConditions.visibilityOfElementLocated(text));
}
