import POM.HomePage;
import POM.LoginPage;
import POM.PlayListPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        System.out.println(plName);
        System.out.println("After test");
        Assert.assertEquals(songTitle,addedSong);
      //  Assert.assertEquals(plName,SmartPlistName);

    }
}
