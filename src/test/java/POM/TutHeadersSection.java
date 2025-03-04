package POM;

import StepDefinitions.StepsToTutorialsLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TutHeadersSection {

    public TutHeadersSection() {

        PageFactory.initElements(StepsToTutorialsLogin.driver, this);
    }
 /*   @FindBy(css = ".fa-user")
    public static   WebElement accountEnterBtn;*/


public By accountEnterBtn = By.cssSelector(".fa-user");
public By loginBtn = By.linkText("Login");

public By email = By.id("input-email");

public By password = By.id("input-password");

public By submit = By.xpath("//input[@type ='submit']");
public By confirm = By.cssSelector("#content");
public By registerBtn = By.linkText("Register");
}