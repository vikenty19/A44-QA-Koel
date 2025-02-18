import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createSmartPlistWithName() {
        BasePage basePage = new BasePage(driver);
        String addedSong = "Episode 2";
        String SmartPlistName = generateRandomPlaylistName() + basePage.timeStamp();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        smart.createSmartPlistWithOutGroup(SmartPlistName, addedSong);
        basePage.isSuccessBannerDisplayed();

        String plName = driver.findElement(By.cssSelector("#playlistWrapper .heading-wrapper h1")).getText();
        String songTitle = driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .title")).getText();
        System.out.println("Song added in the Playlist --" + songTitle);

        System.out.println(" name of created plyList  ---" + plName);
        System.out.println("After test");
        Assert.assertEquals(songTitle, addedSong);
        //  Assert.assertEquals(plName,SmartPlistName);

    }
    @Test
    public void cancelCreatingSmartPlist() throws InterruptedException {
        BasePage basePage = new BasePage(driver);
        String SmartPlistName = generateRandomPlaylistName()+basePage.timeStamp();
        String addedSong = "Episode 2";;
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        SmartPlayListPage smart = new SmartPlayListPage(driver);
        smart.createSmartPlist.click();
        smart.playListName.sendKeys(SmartPlistName);
        smart.songName.sendKeys(addedSong);
        driver.findElement(By.cssSelector(".btn-cancel")).click();
        driver.findElement(By.cssSelector("button.ok")).click();
        Assert.assertFalse(smart.isSmartPlistCreated(SmartPlistName));
    }

    @Test
    public void createSmartPlistWithNameAndGroup() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage(driver);
        SmartPlayListPage smartPlayListPage = new SmartPlayListPage(driver);
        String addedSong = "Reactor";// this artist name ended with "O" "Reactor"
        String enteredLetter = "o";
        String SmartPlistName = generateRandomPlaylistName() + basePage.timeStamp();
        System.out.println(SmartPlistName);
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        smartPlayListPage.enterSmartPlistName(SmartPlistName);
        //Add text in the value field
        smartPlayListPage.enterValueToCreateSmartPlist(addedSong);
        //add group title Artist
         smartPlayListPage.selectGroupTitle("Artist");
         //select option in group
        smartPlayListPage.selectOptionInGroup("ends with");
        smartPlayListPage.enterOptionForGroupRule(enteredLetter);
        smartPlayListPage.clickSubmitBtn();
        basePage.isSuccessBannerDisplayed();
        //Check name in the DB
        GetSQLInfo.checkSQLPlayListName(SmartPlistName);

        //Check if Playlist is in the list
       Assert.assertTrue(smartPlayListPage.isSmartPlistCreated(SmartPlistName));

        Thread.sleep(1000);//because of instability

        //check the last letter of the artist name
        List<WebElement> songsInSmartPlist = driver.findElements(By.cssSelector("tr td.artist"));
        for (WebElement temp : songsInSmartPlist) {
            String lastLetter = temp.getText();

            // Get last char of the artist name
            if (!lastLetter.isEmpty()) {
                char lastChar = lastLetter.charAt(lastLetter.length() - 1);

                String lastLetterString = "" + lastChar;
                // Assert if result conform to entering last letter of the artist name
                softAssert.assertTrue(lastLetterString.equalsIgnoreCase(enteredLetter));
                //Taking screenShot of the error
                if (!lastLetterString.equalsIgnoreCase(enteredLetter)) {
                    File scrShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                    File destinationScrShotFile = new File("./src/test/java/ScreenShots/SmartPlist.png");
                    try {
                        FileHandler.copy(scrShot, destinationScrShotFile);

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                softAssert.assertAll();
            }

        }

    }



    @Test
    public void plListByArtistName() throws InterruptedException {

        String SmartPlistName = generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
        select.selectByVisibleText("Artist");

        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText("begins with");
        driver.findElement(By.name("value[]")).sendKeys("U");
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        // Check songs in the playlist
        String artistName = driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist")).getText();
        System.out.println(artistName);
        Character firstLetter = artistName.charAt(0);
        System.out.println(firstLetter);
        Assert.assertEquals(firstLetter.toString(), "U");
        Thread.sleep(5000);

    }

    @Test(dataProvider = "alphabet")//Checking first letter of the artists names in the list of songs
    public void plListByArtistNamesFirstLetterCheck(char letter) {


        Character firstLetterOfArtistName = letter;
        String SmartPlistName = generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
        select.selectByVisibleText("Artist");

        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText("begins with");
        driver.findElement(By.name("value[]")).sendKeys(firstLetterOfArtistName.toString());
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        // Check List of songs in the playlist
        List<WebElement> artistName = driver.findElements(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist"));
        if (artistName.size() == 0) {
            String message = driver.findElement(By.cssSelector("#playlistWrapper .screen-placeholder .text")).getText();
            Assert.assertTrue(message.contains("No songs match the playlist's "));
            System.out.println("No song like that");
        }
        for (WebElement temp : artistName) {
            String name = temp.getText();
            System.out.println(name);
            Character firstLetter = name.charAt(0);
            String a = firstLetter.toString();
            Assert.assertTrue(a.equalsIgnoreCase(firstLetterOfArtistName.toString()));
        }

    }

    @DataProvider(name = "alphabet")
    public Object[][] returnChar() {
        Object[][] alphabet = new Object[26][1];
        for (int i = 0; i < 26; i++) {
            alphabet[i][0] = (char) ('a' + i);
        }
        return alphabet;
    }

}