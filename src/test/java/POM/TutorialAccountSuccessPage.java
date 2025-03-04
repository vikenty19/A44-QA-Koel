package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static StepDefinitions.StepsToTutorialsLogin.driver;

public class TutorialAccountSuccessPage {
    public TutorialAccountSuccessPage(){
        PageFactory.initElements(driver,this);
    }
 public static By successText = By.cssSelector("#content h1");

}
