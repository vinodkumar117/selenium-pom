package extentReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import commonUtils.Utility;


public class ExtentReport {
    static ExtentReports extent;

    public static ExtentReports extentReportGenerator() {


        String path = System.getProperty("user.dir")+"/Current test results/AutomationReport_"+ Utility.getCurrentTimeStamp()+".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Selenium Web Automation");
        reporter.config().setDocumentTitle("Automation Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Automation Developer","Vinod Kumar");
        return extent;
    }
}
