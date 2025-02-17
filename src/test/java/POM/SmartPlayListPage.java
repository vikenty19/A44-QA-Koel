package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SmartPlayListPage extends BasePage{

    public SmartPlayListPage(WebDriver givenDriver) {
        super(givenDriver);

    }
      HomePage homePage = new HomePage(driver);
    @FindBy(css ="[data-testid =playlist-context-menu-create-smart]")
    WebElement createSmartPlist;
    @FindBy(name = "name")
    WebElement playListName;
    @FindBy(name = "value[]")
    WebElement songName;
    @FindBy(css = "footer [type = 'submit']")
    WebElement submit;
    @FindBy(css = ".btn-add-group")
    WebElement titleField;

    By dropOptionField = By.cssSelector("div.rule-group:nth-child(2) select[name='model[]']");
    public void createSmartPlistWithOutGroup(String name, String addedSong){

        createSmartPlist.click();
        playListName.sendKeys(name);
        songName.sendKeys(addedSong);
        submit.click();
    }
    public void enterSmartPlistName(String plName){
        createSmartPlist.click();
        playListName.sendKeys(plName);
    }
    public void selectGroupTitle(String artist) {

       titleField.click();
        WebElement dropDownField=  homePage.waitUntilClickable(dropOptionField);
        dropDownField.click();
        Select select = new Select(dropDownField);
        select.selectByVisibleText(artist);
    }
    public void selectOptionInGroup(String option){

        WebElement dropOptionField = homePage.waitUntilClickable(By.cssSelector("div.rule-group:nth-child(2) select[name='operator[]']"));
        dropOptionField.click();
        Select select1 = new Select(dropOptionField);
        select1.selectByVisibleText(option);

    }

    public void enterValueToCreateSmartPlist(String text) {
        driver.findElement(By.name("value[]")).sendKeys(text);
    }

    public void enterOptionForGroupRule(String text) {
        WebElement dropValueField = homePage.waitUntilClickable(By.cssSelector("div.rule-group:nth-child(2) [name='value[]']"));
        dropValueField.click();
        dropValueField.sendKeys(text);
    }

    public void clickSubmitBtn() {
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
    }
}
//div.rule-group:nth-child(2) select[name='model[]']