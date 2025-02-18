package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartPlayListPage extends BasePage{

    public SmartPlayListPage(WebDriver givenDriver) {
        super(givenDriver);

    }
      HomePage homePage = new HomePage(driver);
    @FindBy(css ="[data-testid =playlist-context-menu-create-smart]")
   public WebElement createSmartPlist;
    @FindBy(name = "name")
   public WebElement playListName;
    @FindBy(name = "value[]")
    public WebElement songName;
    @FindBy(css = "footer [type = 'submit']")
    WebElement submit;
    @FindBy(css = ".btn-add-group")
    WebElement titleField;
    @FindBy(css = ".btn-cancel")
   public WebElement cancelCreatedPlist;
    @FindBy(css = "button.ok")
            public WebElement cancelConfirm;

    By dropOptionField = By.cssSelector("div.rule-group:nth-child(2) select[name='model[]']");
    By optionGroup = By.cssSelector("div.rule-group:nth-child(2) select[name='operator[]']");
    By subMit =By.cssSelector("div.rule-group:nth-child(2) [name='value[]']");
    By plyListsName = By.cssSelector("li.playlist.smart");
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

        WebElement dropOptionField = homePage.waitUntilClickable(optionGroup);
        dropOptionField.click();
        Select select1 = new Select(dropOptionField);
        select1.selectByVisibleText(option);

    }

    public void enterValueToCreateSmartPlist(String text) {
        songName.sendKeys(text);
    }

    public void enterOptionForGroupRule(String text) {
        WebElement dropValueField = homePage.waitUntilClickable(subMit);
        dropValueField.click();
        dropValueField.sendKeys(text);
    }

    public void clickSubmitBtn() {
        submit.click();
    }

    public boolean isSmartPlistCreated(String name) throws InterruptedException {
        boolean exist = false;
        List<WebElement> smartPlistNames = driver.findElements(plyListsName );
        for (WebElement temp : smartPlistNames) {
            if (temp.getText().equalsIgnoreCase(name)) {
                Thread.sleep(1000);//because of instability
                temp.click();
                exist = true;
                break;
            }

        }return exist;
    }
}
//div.rule-group:nth-child(2) select[name='model[]']