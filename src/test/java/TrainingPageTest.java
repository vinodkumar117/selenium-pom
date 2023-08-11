import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TrainingPage;

public class TrainingPageTest extends TestBase {

    public WebDriver driver;
    TrainingPage trainingPage;

    @BeforeMethod
    public void setUp(){
        driver= getWebDriver();
        trainingPage = new TrainingPage(driver);
    }

    /*
     This method will move cursor to Training then click sub menu Video Download
     And then validate whether user is landed on Video Download
     */
    @Test(priority = 1, description = "Move cursor to menu Training then click sub menu Video Download")
    public void navigateToTrainingVideoDownload() {
        trainingPage.moveToSubMenu("Training");
        trainingPage.moveToSubMenuAndClick("Video Download");
        String pageText = trainingPage.getTextFromElement(trainingPage.msgInfo);
        Assert.assertEquals(pageText, "We can't find products matching the selection.");

        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Video Download - Training");
    }

}
