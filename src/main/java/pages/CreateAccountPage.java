package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

    public WebDriver driver;
    private Utility eleUtils;
    public CreateAccountPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }
    public By linkCreateAccount = By.xpath("//div[@class='panel header']//a[text()='Create an Account']");
    public By inputFirstName = By.id("firstname");
    public By inputLastName = By.id("lastname");
    public By inputEmail = By.id("email_address");
    public By inputPassword = By.id("password");
    public By inputConfirmPassword = By.id("password-confirmation");

    public By buttonCreateAccount = By.xpath("//button[@type='submit']/span[text()='Create an Account']");

    public By msgCreateAccount = By.xpath("//div[@role='alert']/div/div");

    public void createNewAccount(String firstname, String lastname, String email, String password, String confirmPassword, String createNewEmailAddress){
        if (createNewEmailAddress.equalsIgnoreCase("Yes")) {
            email="Automation"+System.currentTimeMillis()+"@gmail.com";
        }
        eleUtils.clickOnElement(driver,linkCreateAccount);
        eleUtils.type(driver, inputFirstName,firstname);
        eleUtils.type(driver, inputLastName,lastname);
        eleUtils.type(driver, inputEmail,email);
        eleUtils.type(driver, inputPassword,password);
        eleUtils.type(driver, inputConfirmPassword,confirmPassword);
        eleUtils.clickOnElement(driver,buttonCreateAccount);
    }
    public String getCreateAccMsg(){
        return eleUtils.getTextFromElement(driver,msgCreateAccount);

    }

    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }

}
