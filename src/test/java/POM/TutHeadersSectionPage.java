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


public By accountEnterBtn = By.cssSelector(".fa-user");
public By loginBtn = By.linkText("Login");

public By email = By.id("input-email");

public By password = By.id("input-password");

public By submit = By.xpath("//input[@type ='submit']");
public By confirm = By.cssSelector("#content");
public By registerBtn = By.linkText("Register");
}