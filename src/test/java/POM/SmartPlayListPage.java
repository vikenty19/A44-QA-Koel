package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
//div.rule-group:nth-child(2) select[name='model[]']