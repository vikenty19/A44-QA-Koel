package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static StepDefinitions.TutorialsLoginOnly.driver;
import static StepDefinitions.TutorialsLoginOnly.wait;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public static By account = By.cssSelector(".breadcrumb>li:nth-child(2)>a");
    public static WebElement accountBreadCrumb = wait.until(ExpectedConditions.visibilityOfElementLocated(account));
}
