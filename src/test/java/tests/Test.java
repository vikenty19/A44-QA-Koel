package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefinitions.TutorialsLoginOnly.driver;

public class Test {



        WebDriverWait wait;
        WebDriver driver;
        String tutorialURL = "http://tutorialsninja.com/demo/";

@org.testng.annotations.Test
        public void test(){
            WebDriverManager.chromedriver().clearDriverCache().setup();
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");

            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(tutorialURL);
            driver.findElement(By.cssSelector(".fa-user")).click();
            driver.findElement(By.linkText("Register")).click();
            driver.findElement(By.xpath("//input[@type ='submit']")).click();
            WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert")));
            String text = alert.getText();
            System.out.println("Warning message  :" + text);
        }
    }
