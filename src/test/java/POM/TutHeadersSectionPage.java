package POM;

import StepDefinitions.TutorialsLoginOnly;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class TutHeadersSectionPage {

    public TutHeadersSectionPage() {

        PageFactory.initElements(TutorialsLoginOnly.driver, this);
    }
 /*   @FindBy(css = ".fa-user")
    public static   WebElement accountEnterBtn;*/


public static By accountEnterBtn = By.cssSelector(".fa-user");
public static By loginBtn = By.linkText("Login");

public static By email = By.id("input-email");

public static By password = By.id("input-password");

public static By submit = By.xpath("//input[@type ='submit']");
public static By confirm = By.cssSelector("#content");
public static By registerBtn = By.linkText("Register");
}