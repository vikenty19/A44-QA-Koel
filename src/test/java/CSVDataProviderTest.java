import POM.BasePage;
import POM.LoginPage;
import POM.SongPage;
import com.opencsv.CSVReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class CSVDataProviderTest extends BaseTest {



    @Test(dataProvider = "getSongsData",dataProviderClass = DataProviders.class)
    public void searchForSong(String song) {
        LoginPage loginPage = new LoginPage(driver);
        SongPage songPage = new SongPage(driver);
        loginPage.login(myEmail, myLogin);
        songPage.clickSearchField();
        songPage.enterNameInSearchField(song);
        songPage.checkSearchResult();
        System.out.println(songPage.checkSearchResult());
        Assert.assertEquals(songPage.checkSearchResult(), song);


    }
}