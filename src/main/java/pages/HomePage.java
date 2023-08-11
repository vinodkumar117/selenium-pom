package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {

    public WebDriver driver;
    private Utility eleUtils;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }
    public By companyLogo=By.xpath("//a[@class='logo']/img");

    public By buttonShopNewYoga=By.xpath("//span[@class='action more button']");

    public By linkWhatIsNew=By.xpath("//button[text()='Sign out']");

    public By loginButton=By.xpath("//button[text()='Log in']");

    public By headerShopNewYoga = By.xpath("//span[@class='base']");

    public By dropDownWomen = By.xpath("//span[text()='Women']");


    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }

}
