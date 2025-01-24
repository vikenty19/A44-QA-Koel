import POM.HomePage;
import POM.LoginPage;
import POM.PlayListPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createPlistWithName() throws InterruptedException {
        String addedSong = "Dark Days";
        String SmartPlistName = "qQqQQQQQQQQQqq";
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
        System.out.println(plName);
        System.out.println("After test");
        //Assert.assertEquals(plName,SmartPlistName);

    }
}
