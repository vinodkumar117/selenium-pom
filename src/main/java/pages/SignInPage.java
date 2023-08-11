package pages;


import base.TestBase;
import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends TestBase {

    public WebDriver driver;
    private Utility eleUtils;
    public SignInPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }
    public By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");

    public By inputEmail = By.id("email");
    public By inputPassword = By.id("pass");

    public By buttonSignIn = By.name("send");

    public By loggedInClass= By.xpath("//span[@class='logged-in']");

    public void userSignIn(String username, String password){
        eleUtils.clickOnElement(driver,signInLink);
        eleUtils.type(driver, inputEmail,username);
        eleUtils.type(driver, inputPassword,password);
        eleUtils.clickOnElement(driver,buttonSignIn);
    }


}
