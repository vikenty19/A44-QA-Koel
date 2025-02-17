import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Date;

public class PlayListTests extends BaseTest {

    @Test
    public void deletePlaylistTest() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        String playlistName = generateRandomPlaylistBookName()+basePage.timeStamp();
        System.out.println(playlistName);
        PlayListPage playListPage = new PlayListPage(driver);
     //   GetSQLInfo getSQLInfo = new GetSQLInfo();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        playListPage.goToPlayListField();
        playListPage.createNewPlaylist(playlistName);
        //Assertions of playlist name
        playListPage.checkPlayListName(playlistName);
        playListPage.isSuccessBannerDisplayed();
        //checking created plist name in the DB
        GetSQLInfo.checkSQLPlayListName(playlistName);
        //delete playlist
        playListPage.deleteCreatedPlaylist();
        //Assertions
        Thread.sleep(1000);//left it because of instability
        playListPage.isPlayListDeleted(playlistName);
        //Assert deleting created playlist from DB
       Assert.assertNull(GetSQLInfo.checkSQLPlayListName(playlistName));
    }






    @Test
    public void renamePlayListWithDoubleClick()  {
        String newPlayLIstName = generateRandomPlaylistName();
        PlayListPage playListPage = new PlayListPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        BasePage basePage = new BasePage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.choosePlayListToDelete();
        playListPage.createNewPlaylist(newPlayLIstName );
        playListPage.enterNewNameIntoNameField(newPlayLIstName);
        System.out.println(newPlayLIstName);
        System.out.println(playListPage.getPlaylistName());
        basePage.isSuccessBannerDisplayed();
        //DataBase checking pListName
        GetSQLInfo getSQLInfo = new GetSQLInfo();
        //Assertion
       Assert.assertEquals(newPlayLIstName,getSQLInfo.checkSQLPlayListName(newPlayLIstName));
    }



    @Test
    public void renamePlistWithEditBtnAndDataBaseChecking()  {
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
       softAssert.assertEquals(getSQLInfo.checkSQLPlayListName(newName),newName);
        softAssert.assertAll();
    }

    @Test(enabled = false)
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
    @Test
    public void dragSongToPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(myEmail,myLogin);
        SongPage songPage = new SongPage(driver);
        songPage.goToAllSongsTub();

        WebElement song = loginPage.waitUntilClickable(By
                .cssSelector(".all-songs .song-item:nth-of-type(1) .title"));
        String songInAllSong = song.getText();
        System.out.println("song in all songs  " + songInAllSong);
        WebElement playlist = loginPage.waitUntilClickable(By
                .cssSelector("#playlists li:nth-child(3)"));
        //drag song to created playlist


        new Actions(driver)
                .dragAndDrop(song, playlist)
                .perform();
        playlist.click();
        WebElement addedSong = loginPage.waitUntilVisible(By
                .cssSelector(".playlist .item-container .items tr.song-item:nth-child(1) .title"));
        addedSong.click();
        String songInPlaylist = addedSong.getText();
        System.out.println("Song In Playlist  " + songInPlaylist);
        Assert.assertEquals(songInAllSong, songInPlaylist);

    }
}
//#playlists li:nth-child(3)