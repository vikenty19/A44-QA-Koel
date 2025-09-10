package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;




public class TutorialAccountSuccessPage {
    private WebDriver driver;
    public TutorialAccountSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
 public static By successText = By.cssSelector("#content h1");
    public static By successCrumble = By.linkText("Success");

}
