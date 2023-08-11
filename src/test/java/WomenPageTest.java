
import base.TestBase;
import commonUtils.PropertyFileReader;
import commonUtils.Utility;
import pages.WomenPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WomenPageTest extends TestBase {

    public WebDriver driver;
    WomenPage womenPage;

    @BeforeMethod
    public void setUp(){
        driver= getWebDriver();
        womenPage = new WomenPage(driver);
    }

    /*
     This method will move cursor to Women menu then sub menu Tops and then click on sub menu jackets
     And then validate whether user is landed on jackets page
     */
    @Test(priority = 1, description = "Navigate to menu Women then sub menu Tops and then click sub menu Jackets")
    public void navigateToWomenSubMenuJackets() {
        womenPage.moveToSubMenu("Women");
        womenPage.moveToSubMenu("Tops");
        womenPage.moveToSubMenuAndClick("Jackets");
        String pageText = womenPage.getTextFromElement(womenPage.pageHeader);
        Assert.assertEquals(pageText, "Jackets");
    }

    /*
     This method will move cursor to Women menu then sub menu Tops and then click on sub menu Hoodies & Sweatshirts
     And then validate whether user is landed on Hoodies & Sweatshirts page
     */
    @Test(priority = 2, description = "Navigate to menu Women then sub menu Tops and then click sub menu Hoodies & Sweatshirts")
    public void navigateToWomenSubMenuHoodies() {
        womenPage.moveToSubMenu("Women");
        womenPage.moveToSubMenu("Tops");
        womenPage.moveToSubMenuAndClick("Hoodies & Sweatshirts");
        String pageText = womenPage.getTextFromElement(womenPage.pageHeader);
        Assert.assertEquals(pageText, "Hoodies & Sweatshirts");


        // *** Making this test to fail to cover the screenshot capture scenario ***
        Assert.assertTrue(true);
    }


}
