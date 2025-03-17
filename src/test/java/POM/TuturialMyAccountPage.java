package POM;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Base.BasePage.driver;


public class TuturialMyAccountPage {
    public TuturialMyAccountPage(){
        PageFactory.initElements(driver,this);
    }
    public static By account = By.cssSelector(".breadcrumb>li:nth-child(2)>a");
    public static WebElement accountBreadCrumb = BasePage.wait.until(ExpectedConditions.visibilityOfElementLocated(account));
}
