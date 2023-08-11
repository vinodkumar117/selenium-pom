import base.TestBase;
import commonUtils.PropertyFileReader;
import commonUtils.Utility;
import pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends TestBase {

    public WebDriver driver;
    SignInPage signInPage;
    private Utility eleUtils;
    @BeforeMethod(alwaysRun=true)
    public void setUp(){
        driver= getWebDriver();
        eleUtils = new Utility();
        signInPage = new SignInPage(driver);
    }

    /*
    * This method reads data from property file
    * It validates whether user is able to log in successfully
     */

    @Test(groups= {"SmokeTest"}, priority = 1, description = "Validate sign in")
    public void verifySignIn() {
        signInPage.userSignIn(PropertyFileReader.getProperty("username"), PropertyFileReader.getProperty("password"));
        boolean isLoggedInPresent = eleUtils.isElementPresent(driver,signInPage.loggedInClass);
        Assert.assertTrue(isLoggedInPresent);
    }

}
