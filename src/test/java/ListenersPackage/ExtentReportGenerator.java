package ListenersPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentReportGenerator {
    public static ExtentReports getExtendReport(){
        ExtentReports report = new ExtentReports();
        File file = new File(System.getProperty("user.dir")+"./src/test/java/Koel/eReport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        report.attachReporter(sparkReporter);
         return report;
    }
}
