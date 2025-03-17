package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static Base.BasePage.driver;


public class TutorialAccountSuccessPage {
    public TutorialAccountSuccessPage(){
        PageFactory.initElements(driver,this);
    }
 public static By successText = By.cssSelector("#content h1");
    public static By successCrumble = By.linkText("Success");

}
