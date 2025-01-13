package ListenersPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners  implements ITestListener {
// Call method to generate extent report

   ExtentReports report = ExtentReportGenerator.getExtendReport();
    ExtentTest eTest;
    @Override
    public void onTestStart(ITestResult result) {
     String testName =  result.getName();
     // Create a test with report
       eTest =  report.createTest(testName);
       eTest.log(Status.INFO,testName+"started");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName =  result.getName();
        eTest.log(Status.PASS,testName + "passed successfully");
    }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        String testName =  result.getName();
        eTest.log(Status.FAIL,testName+ "GOT FAILED");
        //Let's add a ScreenShot
        //Implement driver
        WebDriver driver = (WebDriver)result.getTestClass().getRealClass()
                        .getDeclaredField("driver").get(result.getInstance());
       // eTest.addScreenCaptureFromPath(takeScreenShot(testName,driver))
        //
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }
}
