package base;

import commonUtils.PropertyFileReader;
import commonUtils.Utility;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestBase {

    public WebDriver driver;
    public Logger logger = Logger.getLogger(TestBase.class.getClass());

    ThreadLocal<WebDriver> threadLocal;

    @BeforeSuite(alwaysRun=true)
    public void startSuite() throws IOException {
        logger.info("*********Starting test suite************");
        moveTestReportsToArchive();
    }

    public WebDriver initializeDriver(String browserName){

        if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if(browserName.equalsIgnoreCase("Safari"))
        {
            driver=new SafariDriver();
        }
        else {
            driver = new ChromeDriver();
        }
        threadLocal=new ThreadLocal<WebDriver>();
        threadLocal.set(driver);
        driver=threadLocal.get();
        driver.manage().window().maximize();
        driver.get(PropertyFileReader.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("LONG_WAIT_TIMEOUT"))));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("SHORT_WAIT_TIMEOUT"))));
        return driver;
    }


    public WebDriver getWebDriver() {

        return initializeDriver(PropertyFileReader.getProperty("browserName"));
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser(){
        driver.close();

    }

    // To take the screenshot
    public String getScreenshotPath(String testCaseName, WebDriver driver, String error) throws IOException {

        TakesScreenshot ts =(TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        logger.info("Saving screenshot for : "+ testCaseName);
        String destPath = System.getProperty("user.dir")+"\\Current test results\\"+testCaseName+"_"+error+"_"+Utility.getCurrentTimeStamp()+".png";
        File file = new File(destPath);
        FileUtils.copyFile(source,file);
        return destPath;

    }

    // To move the old reports to archive

    public void moveTestReportsToArchive() {

        File src = new File(System.getProperty("user.dir")+"\\Current test results\\");
        File dest;
        String path = "Archived_test_results-"+ Utility.getCurrentTimeStamp();
        logger.info("Moving old test results to archive folder");
        try {
            File folder = new File(path);
            dest=new File(System.getProperty("user.dir")+"\\Archived test results\\"+path+"\\");
            FileUtils.copyDirectory(src, dest);
            FileUtils.cleanDirectory(src);
            logger.info("Moved test reports to archive");
        } catch (IOException e) {
            logger.error("Error in moving old test results :"+e.getMessage());
            e.printStackTrace();
        }catch (Exception e){
            logger.error("Error in moving old test results :"+e.getMessage());
            e.printStackTrace();
        }
    }

}
