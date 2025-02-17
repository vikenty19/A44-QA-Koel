package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SmartPlayListPage extends BasePage{

    public SmartPlayListPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public void createSmartPlistWithoutGroup(String name, String addedSong){

        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("value[]")).sendKeys(addedSong);
        //  Thread.sleep(5000);
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
    }
    public void enterSmartPlistName(String plName){
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(plName);
    }
    public void selectGroupTitle(String artist) {
        HomePage homePage = new HomePage(driver);
        driver.findElement(By.cssSelector(".btn-add-group")).click();
        WebElement dropDownField = homePage.waitUntilClickable(By.cssSelector("div.rule-group:nth-child(2) select[name='model[]']"));
        dropDownField.click();
        Select select = new Select(dropDownField);
        select.selectByVisibleText(artist);
    }
    public void selectOptionInGroup(String option){
        HomePage homePage = new HomePage(driver);
        WebElement dropOptionField = homePage.waitUntilClickable(By.cssSelector("div.rule-group:nth-child(2) select[name='operator[]']"));
        dropOptionField.click();
        Select select1 = new Select(dropOptionField);
        select1.selectByVisibleText(option);

    }

}
//div.rule-group:nth-child(2) select[name='model[]']