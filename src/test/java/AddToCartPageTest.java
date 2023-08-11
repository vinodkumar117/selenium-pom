import base.TestBase;
import commonUtils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.SearchPage;

public class AddToCartPageTest extends TestBase {

    public WebDriver driver;
    AddToCartPage addToCartPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver= getWebDriver();
        addToCartPage= new AddToCartPage(driver);
    }

    /*This method will search for a product and add to cart.
     * And it will validate whether product is added to cart.
     */

    @Test(priority = 1, description = "Validate Add to cart functionality")
    public void verifyAddToCart() {
        addToCartPage.searchAndAddToCart("Jacket");
        String productCount = addToCartPage.getTextFromElement(addToCartPage.getCartProductCount);
        Assert.assertEquals(productCount, "1");
    }

}
