import com.github.javafaker.Faker;
import com.github.javafaker.Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Locale;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://qa.koel.app/";
    public static String myLogin = "te$t$tudent1";
    public static String myEmail = "galy.o@testpro.io";
    public static WebDriverWait wait = null;

//    @BeforeSuite
  /*  static void setupDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
    }*/
    public static WebDriver pickBrowser(String browserName) throws MalformedURLException {
        WebDriver driver;
        DesiredCapabilities dc = new DesiredCapabilities();
        if (browserName.equalsIgnoreCase("chrome")){
            dc.setBrowserName("chrome");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            dc.setBrowserName("firefox");
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--disable-notifications");

        } else if (browserName.equalsIgnoreCase("edge")) {
            dc.setBrowserName("MicrosoftEdge");
        } else if (browserName.equalsIgnoreCase("opera")) {
            dc.setBrowserName("opera");
        } else if (browserName.equalsIgnoreCase("ie")) {
            dc.setBrowserName("internet explorer");

        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444"),dc);
        return driver;
    }



    @BeforeMethod
    public void setUpBrowser() throws MalformedURLException {
    /*    ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        // System.setProperty("webdriver.chromedriver","C:\\Users\\Acer\\Downloads\\chrome-win64 (1).zip\\chrome-win64\\");

        driver = new ChromeDriver(options);*/
        driver=pickBrowser("firefox");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        openUrl(url);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public String generateRandomName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.name().firstName();
        return newName;
    }

    public String generateRandomPlaylistName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().country();
        return newName;
    }

    public String generateRandomPlaylistBookName() {
        Faker faker = new Faker();
        String newName = faker.book().title();
        return newName;
    }



    public void openUrl(String url) {

        driver.get(url);
    }

    @DataProvider(name = "IncorrectLoginProviders")
    public static Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"notExisting@email.com", "NotExistingPassword"},
                {"demo@class.com", ""},
                {"", ""}, {"demo@@class.com", "te$t$tudent"}, {"<include name=test'></include>@class.com", "te$t$tudent"}
        };
    }

    @DataProvider(name = "profileThemeTest")
    public static Object[][] getProfileThemeFromDataProvider() {
        return new Object[][]{
                //    {"li:nth-of-type(1) > .theme > .name", 0},
                {"li:nth-of-type(8) > .theme > .name", 7},
                {"li:nth-of-type(16) > .theme > .name", 15},
        };
    }


    public void searchForSong(String text) throws InterruptedException {

        WebElement searchInput = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("[type='search']")));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys(text);


    }


}