package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static StepDefinitions.TutorialsLoginOnly.driver;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = ".breadcrumb>li:nth-child(2)>a")
    public static WebElement accountBreadCrumb;
}
