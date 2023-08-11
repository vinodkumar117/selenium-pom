package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage {

    public WebDriver driver;
    private Utility eleUtils;
    public WomenPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }
    public By menuWomen = By.xpath("//a[@role='menuitem']/span[text()='Women']");
    public By menuTopsWomen = By.xpath("//span[text()='Tops']");
    public By menuJacketsWomen = By.xpath("//span[text()='Jackets']");
    public By menuHoodiesWomen = By.xpath("//span[text()='Hoodies & Sweatshirts']");

    public By pageHeader = By.xpath("//span[@class='base']");

    public By menuIcon = By.xpath("//span[contains(@class,\"ui-menu-icon\")]");

    public By shoppingOptions = By.xpath("//strong[text()='Shopping Options']");

    public void moveToSubMenu(String menu){
        By menuXpath = By.xpath("//span[text()='"+menu+"']");
        eleUtils.waitForWebElement(driver,menuIcon);
        eleUtils.mouserHover(driver,menuXpath);
    }
    public void moveToSubMenuAndClick(String menu){
        By menuXpath = By.xpath("//span[text()='"+menu+"']");
        eleUtils.mouserHoverAndClick(driver,menuXpath);
        eleUtils.waitForWebElement(driver,shoppingOptions);
    }

    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }

}
