package CucumberPOM;

import StepDefinitions.LoginStepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageCucumber {
    public LoginPageCucumber(){
        PageFactory.initElements(LoginStepDefinitions.driver,this);
    }
   public static By email = By.cssSelector("[type='email']");
    public static WebElement emailInput =LoginStepDefinitions.driver.findElement(email);
    public static By pass = By.cssSelector("[type='password']");
    //public static WebElement passwordInput=LoginStepDefinitions.driver.findElement(pass);
}
