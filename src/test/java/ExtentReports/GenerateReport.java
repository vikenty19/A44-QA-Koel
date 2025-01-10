package ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GenerateReport {
    public static void main(String[] args) throws IOException {


        ExtentReports extent = new ExtentReports();//extent is an engine
        // create object extentSparkReporter
        File path = new File(System.getProperty("user.dir") + "/src/test/java/ExtentReports/ReportsFolder/eReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        // attach reporter to the engine
        extent.attachReporter(sparkReporter);
        ExtentTest eTest1 = extent.createTest("Test One","This is test description");
        ExtentTest eTest2 = extent.createTest("Test two","This is test description");
        eTest1.log(Status.INFO,"<h1>Chrome is started</h1>");//HEADER
        eTest1.log(Status.INFO,"<b>Browser got closed</b>");//bold
        eTest1.log(Status.WARNING,"Waiting is too long");
        eTest1.log(Status.PASS,"<i>Test One passed</i>");//italic
        eTest1.log(Status.FAIL,"<u>Test one filed</u.");//1st level <u> -> underlined
        extent.flush();//to generate report!!!
        //To open generated eReport automatically
        Desktop.getDesktop().browse(path.toURI());
    }
}
