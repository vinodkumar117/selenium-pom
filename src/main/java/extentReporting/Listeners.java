package extentReporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends TestBase implements ITestListener {
    public Logger logger = Logger.getLogger(Listeners.class.getClass());
    ExtentReports extent = ExtentReport.extentReportGenerator();
    ExtentTest test;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test for : "+result.getMethod().getMethodName());
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS,"successful");
        logger.info("Test Case Passed : "+result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = null;
        extentTest.get().fail(result.getThrowable());
        logger.error("Test Case Failed : "+result.getMethod().getMethodName());
        logger.error("Error in "+result.getMethod().getMethodName()+": "+result.getThrowable().getMessage());

        // Shorting the error message to append in screenshot name, sometimes error is too big and removing special chars from error
        int lengthOfError = result.getThrowable().getMessage().length();
        String errorMessage;
        if(lengthOfError>100){
            errorMessage = result.getThrowable().getMessage().substring(0,100).replaceAll("[^a-zA-Z0-9]", "-");
        }
        else {
            errorMessage = result.getThrowable().getMessage().replaceAll("[^a-zA-Z0-9]", "-");
        }

        Object testObject = result.getInstance();
        Class testClass = result.getTestClass().getRealClass();
        try {
            driver=(WebDriver) testClass.getDeclaredField("driver").get(testObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            extentTest.get().addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver,errorMessage),result.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        logger.info("Test report generated");

    }
}
