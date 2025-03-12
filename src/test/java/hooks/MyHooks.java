package hooks;

import StepDefinitions.LoginStepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyHooks {
   public static WebDriver driver = Base.driver;
  public static WebDriverWait wait;
  //  public static String url = "https://qa.koel.app/";

  @Before
    public static void setUpDriver() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @After
    public void tearDown() {

        driver.quit();
    }
}