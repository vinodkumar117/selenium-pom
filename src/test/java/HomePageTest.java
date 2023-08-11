import base.TestBase;
import commonUtils.Utility;
import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {

    public WebDriver driver;
    private Utility eleUtils;
    HomePage homePage;
    @BeforeMethod(alwaysRun=true)
    public void setUp(){
        driver= getWebDriver();
        eleUtils = new Utility();
        homePage = new HomePage(driver);
    }

    @Test(groups= {"SmokeTest"}, priority = 1, description = "Validate Home Page")
    public void verifyHomePage() {
        String homePageTitle = eleUtils.getPageTitle(driver);
        Assert.assertEquals(homePageTitle, "Home Page");
        eleUtils.clickOnElement(driver,homePage.buttonShopNewYoga);
        String text = homePage.getTextFromElement(homePage.headerShopNewYoga);
        Assert.assertEquals(text, "New Luma Yoga Collection");

    }

}
