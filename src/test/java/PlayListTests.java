import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        String playlistName = generateRandomPlaylistBookName();
        System.out.println(playlistName);
        PlayListPage playListPage = new PlayListPage(driver);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.createNewPlaylist(playlistName);
        //Assertions of playlist name
        playListPage.checkPlayListName(playlistName);
        playListPage.isSuccessBannerDisplayed();
        //delete playlist
        playListPage.deleteCreatedPlaylist();
        //Assertions
        Thread.sleep(1000);//left it because of instability
        playListPage.isPlayListDeleted(playlistName);

    }


    @Test
    public void renamePlayListWithDoubleClick()  {
        String newPlayLIstName = "Mermaid";
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.login(myEmail, myLogin);

        playListPage.choosePlayListToDelete();
        playListPage.createNewPlaylist(newPlayLIstName );

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement  enterNewPlistName = basePage.waitUntilClickable(By.cssSelector("li:nth-child(3).playlist.smart"));
        new Actions(driver).doubleClick(enterNewPlistName).perform();
        //Double click on plList name( first in the list)
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='name']")));

        //clear field plName
        jse.executeScript("arguments[0].value = '';",field);
        //Entering new name of the pList
        jse.executeScript("document.activeElement.innerText = 'Mermayd';");
        field.sendKeys("Mermaid", ENTER);

        System.out.println(newPlayLIstName);
        System.out.println(playListPage.getPlaylistName());
        basePage.isSuccessBannerDisplayed();
       // Assert.assertEquals(newPlayLIstName, playListPage.getPlaylistName());
    }

    @Test
    public void renamePlistWithEditBtnAndDataBaseChecking() throws InterruptedException {
        String newName = generateRandomPlaylistName();
        PlayListPage playListPage = new PlayListPage(driver);
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.rightClickToEditPlistName();
        playListPage.enterPlaylistName(newName);
        basePage.isSuccessBannerDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(newName, playListPage.getPlaylistName());
        System.out.println(newName + "  " + playListPage.getPlaylistName());
        GetSQLInfo getSQLInfo = new GetSQLInfo();
        //Assert new name with DB name
       softAssert.assertEquals(getSQLInfo.getSQLData(newName),newName);
        softAssert.assertAll();
    }

    @Test
    public void deletePlaylistAddingSongsByDragging() throws InterruptedException {
        //  String playlistName = generateRandomPlaylistBookName();
        String playlistName = "00000001";
        System.out.println(playlistName);
        //create playlist
        PlayListPage playListPage = new PlayListPage(driver);
        SongPage songPage = new SongPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.createNewPlaylist(playlistName);
        playListPage.isSuccessBannerDisplayed();
        //chose the song to drag to playlist
        songPage.goToAllSongsTub();
        //add song to playlist with dragging it from Allsongs

        playListPage.dragSongToPlaylist();

        playListPage.isSuccessBannerDisplayed();
        //delete playlist

        playListPage.deleteCreatedPlaylist();
        playListPage.clickOKbuttonToDeletePlist();


        //Assertions
        Thread.sleep(1000);//left it because of instability

        playListPage.isPlayListDeleted(playlistName);
        playListPage.isSuccessBannerDisplayed();


    }
}
//#playlists li:nth-child(3)