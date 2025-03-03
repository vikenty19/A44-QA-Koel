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
public By registerBtn = By.linkText("Register");
}