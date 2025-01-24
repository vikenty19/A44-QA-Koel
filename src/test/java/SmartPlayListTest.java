import POM.LoginPage;
import POM.PlayListPage;
import org.testng.annotations.Test;

public class SmartPlayListTest extends BaseTest {

    @Test
    public void createPlistWithName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        PlayListPage playListPage = new PlayListPage(driver);
        loginPage.login(myEmail,myLogin);
        playListPage.plusBtnClick();
        Thread.sleep(5000);


    }
}
