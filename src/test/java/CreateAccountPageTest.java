import base.TestBase;
import commonUtils.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CreateAccountPage;

public class CreateAccountPageTest extends TestBase {

    public WebDriver driver;
    CreateAccountPage createAccountPage;

    @BeforeMethod
    public void setUp(){
        driver= getWebDriver();
        createAccountPage = new CreateAccountPage(driver);
    }

    /*This method will be executed based on the data provided in Excel
     * Currently Excel sheet createAccount contains two rows, hence this method will run two times
     * First test case with new email id and second test case with existing email id.
     * And it will validate whether success or error message is displayed.
     */

    @Test(dataProvider = "dataCreateAccount",priority = 1, description = "Validate create account functionality")
    public void verifyCreateNewAccount(String firstname, String lastname, String email, String password, String confirmPassword,String createNewEmailAddress, String msgCreate) {

        createAccountPage.createNewAccount(firstname, lastname, email, password, confirmPassword, createNewEmailAddress);
        String message = createAccountPage.getTextFromElement(createAccountPage.msgCreateAccount);
        Assert.assertTrue(message.contains(msgCreate));
    }

    @DataProvider
    public Object[][] dataCreateAccount() throws Exception{

        Object[][] testDataCreateAcc = ExcelReader.getDataFromSheet("createAccount");

        return testDataCreateAcc;

    }


}
