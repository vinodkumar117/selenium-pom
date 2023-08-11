import base.TestBase;
import commonUtils.ExcelReader;
import commonUtils.PropertyFileReader;
import commonUtils.Utility;
import pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchPageTest extends TestBase {

    public WebDriver driver;
    SearchPage searchPage;
    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        driver= getWebDriver();
        searchPage = new SearchPage(driver);
    }

    /*This method will be executed based on the data provided in Excel
     * Currently Excel sheet createAccount searchInput two rows, hence this method will run two times
     * It will search for the product
     * And it will validate whether product search page is visible.
     */

    @Test(dataProvider="dataSearch", priority = 1, description = "Validate Search")
    public void verifySearch(String searchInput) {
        searchPage.setInputSearchAndEnter(searchInput);
        String text = searchPage.getTextFromElement(searchPage.textItemSearch);
        Assert.assertEquals(text, "Search results for: '"+searchInput+"'");
    }

    @DataProvider
    public Object[][] dataSearch() throws Exception{

        Object[][] testDataSearch = ExcelReader.getDataFromSheet("searchInput");

        return testDataSearch;

    }
}
