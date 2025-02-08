import POM.HomePage;
import POM.LoginPage;
import POM.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createPlistWithName() {
        String addedSong = "Episode 2";
        String SmartPlistName = generateRandomPlaylistName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail, myLogin);
        playListPage.plusBtnClick();
        ;////div/p[@class = 'msg']
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        driver.findElement(By.name("value[]")).sendKeys(addedSong);
        //  Thread.sleep(5000);
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        String plName = driver.findElement(By.cssSelector("#playlistWrapper .heading-wrapper h1")).getText();
        String songTitle = driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .title")).getText();
        System.out.println(songTitle);
        //Just to check info with differ Plist title
        String playlist = driver.findElement(By.cssSelector("#playlists ul li:nth-child(3)")).getText();

        System.out.println(playlist);
        // System.out.println(plName);
        System.out.println("After test");
        Assert.assertEquals(songTitle, addedSong);
        //  Assert.assertEquals(plName,SmartPlistName);

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
    public void plListByArtistNames(char letter)  {


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