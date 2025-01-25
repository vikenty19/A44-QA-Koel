import POM.HomePage;
import POM.LoginPage;
import POM.PlayListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createPlistWithName() {
        String addedSong = "Episode 2";
        String SmartPlistName = addedSong;
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.plusBtnClick();
        ;////div/p[@class = 'msg']
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        driver.findElement(By.name("value[]")).sendKeys(addedSong);
      //  Thread.sleep(5000);
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        String plName = driver.findElement(By.cssSelector("#playlistWrapper .heading-wrapper h1")).getText();
        String songTitle =driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .title")).getText();
        System.out.println(songTitle);
        //Just to check info with differ Plist title
        String playlist = driver.findElement(By.cssSelector("#playlists ul li:nth-child(3)")).getText();

        System.out.println(playlist);
       // System.out.println(plName);
        System.out.println("After test");
        Assert.assertEquals(songTitle,addedSong);
      //  Assert.assertEquals(plName,SmartPlistName);

    }
    @Test
    public void plListByArtistName() throws InterruptedException {
        String addedSong = generateRandomPlaylistName();
        String SmartPlistName =generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.plusBtnClick();
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
        select.selectByVisibleText("Artist");

        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText("begins with");
        driver.findElement(By.name("value[]")).sendKeys("D");
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        // Check songs in the playlist
        String artistName = driver.findElement(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist")).getText();
        System.out.println(artistName);
        Character firstLetter = artistName.charAt(0);
        System.out.println(firstLetter);
        Assert.assertEquals(firstLetter.toString(),"D");
        Thread.sleep(5000);

    }
    @Test
    public void plListByArtistNames() throws InterruptedException {
       // String addedSong = generateRandomPlaylistName();
        String firstLetterOfArtistName = "h";
        String SmartPlistName =generateRandomPlaylistBookName();
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.plusBtnClick();
        driver.findElement(By.cssSelector("[data-testid =playlist-context-menu-create-smart]")).click();
        driver.findElement(By.name("name")).sendKeys(SmartPlistName);
        WebElement dropDownField = homePage.waitUntilClickable(By.name("model[]"));
        WebElement dropDownOption = homePage.waitUntilClickable(By.name("operator[]"));

        Select select = new Select(dropDownField);
        select.selectByVisibleText("Artist");

        Select select1 = new Select(dropDownOption);
        select1.selectByVisibleText("begins with");
        driver.findElement(By.name("value[]")).sendKeys(firstLetterOfArtistName);
        driver.findElement(By.cssSelector("footer [type = 'submit']")).click();
        Assert.assertTrue(homePage.getAvatar());
        // Check List of songs in the playlist
        List<WebElement> artistName = driver.findElements(By
                .cssSelector(".song-list-wrap.main-scroll-wrap.playlist .virtual-scroller .artist"));
        for (WebElement temp:artistName){
           String name= temp.getText();
            System.out.println(name);
            Character firstLetter = name.charAt(0);
            String a = firstLetter.toString();
            Assert.assertTrue(a.equalsIgnoreCase(firstLetterOfArtistName));
        }


        Thread.sleep(5000);

    }
}
