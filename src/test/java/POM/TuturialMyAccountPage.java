package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;




public class TuturialMyAccountPage {
    private WebDriver driver;
    public TuturialMyAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public static By account = By.cssSelector(".breadcrumb>li:nth-child(2)>a");
    public static WebElement accountBreadCrumb = hooks.MyHooks.wait.until(ExpectedConditions.visibilityOfElementLocated(account));
}
