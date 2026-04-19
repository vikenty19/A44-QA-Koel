import POM.BasePage;
import POM.LoginPage;
import POM.SongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class PlaySongs extends BaseTest {

    @Test
    public void playSong() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);
        SongPage songPage = new SongPage(driver);
        BasePage basePage = new BasePage(driver);
        songPage.goToAllSongsTub();
        // Play the song

        songPage.playSongWithPlayBtn();
        basePage.isEqualizerDisplayed();
        basePage.isPauseBtnDisplayed();
    }

    @Test
    public void playSongOverPlayBtn() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);
        SongPage songPage = new SongPage(driver);
        BasePage basePage = new BasePage(driver);
        songPage.goToAllSongsTub();
        songPage.selectSongFromAllSongs();
        songPage.playSongWithPlayBtn();
        Thread.sleep(3000);// to check the sound
        basePage.isEqualizerDisplayed();
    }


    @Test
    public void playSongFromListTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);
        SongPage songPage = new SongPage(driver);
        BasePage basePage = new BasePage(driver);
        songPage.goToAllSongsTub();
        songPage.rightClickOnSong();
        songPage.playbackSongFromDropMenu();
        basePage.isEqualizerDisplayed();
    }

    @Test
    public void switchToAlbumWindow() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);

        String parentWindow = driver.getWindowHandle();
        WebElement allAlbums = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("li>a.albums")));
        // allAlbums.click();
        Actions actions = new Actions(driver);
        actions
                .keyDown(Keys.CONTROL)
                .click(allAlbums)
                .keyUp(Keys.CONTROL)
                .perform();

        Set<String> allWindows = driver.getWindowHandles();
       Iterator<String> iterator = allWindows.iterator();
        while (iterator.hasNext()) {
            String win = iterator.next();
            driver.switchTo().window(win);

            if (driver.getCurrentUrl().contains("/albums")) {
                System.out.println(driver.getCurrentUrl());
                break;
            }
            //  this loop works fo 2 | Iterator with part of the url because title koel the same
     /*   for (String handle : allWindows) {
            if (!handle.equals(parentWindow)) {//this is if only 2 windows are opened
                driver.switchTo().window(handle);
                break;
            }
        }*/
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("/albums"));
        driver.close();//close current window
        driver.switchTo().window(parentWindow);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
        WebElement home = loginPage.waitUntilVisible(By.cssSelector(".menu .home"));
        System.out.println(home.getText());;
        Assert.assertTrue(home.isDisplayed());
    }
}

