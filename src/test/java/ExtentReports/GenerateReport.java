package ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GenerateReport {
   public static WebDriver driver;
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.get("https://qa.koel.app/");
       //HERE WE ARE TAKING SCREENSHOT ON THE TEST LEVEL
      // Create a method to get KoelScreenShot
      /*File KoelHomeScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String KoelScreenPath = System.getProperty("user.dir")+"./src/test/java/Koel/KoelHomeScreenShot.png";
        FileUtils.copyFile(KoelHomeScreenShot,new File(KoelScreenPath));*/
       String KoelScreenPath = takeScreenShot("HomePageKoel");
        ExtentReports extent = new ExtentReports();//extent is an engine
        // create object extentSparkReporter
        File path = new File(System.getProperty("user.dir") + "/src/test/java/ExtentReports/ReportsFolder/eReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        // attach reporter to the engine
        extent.attachReporter(sparkReporter);
        ExtentTest eTest1 = extent.createTest("Test One","This is the test description");
        ExtentTest eTest2 = extent.createTest("Test two","<h1>This is KoelHomePage</h1>")
                .log(Status.INFO, MarkupHelper.createLabel("<h1>KoelHomePage</h1>", ExtentColor.GREEN));//description of th test added
        eTest1.log(Status.INFO,"<h1>Chrome is started</h1>");//HEADER
        eTest1.log(Status.INFO,"<b>Browser got closed</b>");//bold
        eTest1.log(Status.WARNING,"Waiting is too long");
        eTest1.log(Status.PASS,"<i>Test One passed</i>");//italic
        eTest1.log(Status.FAIL,"<u>Test one filed</u.");//1st level <u> -> underlined
        eTest2.addScreenCaptureFromPath(KoelScreenPath,"<i><b>Koel Home Page</b></i> ");//Screenshot in ExtentReport
        eTest2.log(Status.INFO,"<b>KoelHomePage</b>");
        eTest2.log(Status.INFO, MarkupHelper.createLabel("<h1>KoelHomePage</h1>", ExtentColor.BLUE));//highlight text
        //another ScreenShot
        driver.findElement(By.cssSelector("[type='email']")).sendKeys("VIPlakh@mail.com");
        String KoelEmailField = takeScreenShot("KoelEmail");
        eTest2.addScreenCaptureFromPath(KoelEmailField,"<b>Koel Email Enter</b>");
        extent.flush();//to generate report!!!
        driver.quit();
        //To open generated eReport automatically
        try {
            Desktop.getDesktop().browse(path.toURI());
        } catch (IOException e) {
           e.printStackTrace();
        }


        }
    public static String takeScreenShot(String fileName) throws IOException {
        File KoelHomeScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String KoelScreenPath = System.getProperty("user.dir")+"./src/test/java/Koel/"+fileName+".png";
        FileUtils.copyFile(KoelHomeScreenShot,new File(KoelScreenPath));
        return KoelScreenPath;
    }
}
