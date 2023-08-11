package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TrainingPage {

    public WebDriver driver;
    private Utility eleUtils;
    public TrainingPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }
    public By menuTraining = By.xpath("//a[@role='menuitem']/span[text()='Training']");
    public By menuVideoDownload = By.xpath("//span[text()='Video Download']");
    public By msgInfo = By.xpath("//div[@class='message info empty']/div");
    public By menuIcon = By.xpath("//span[contains(@class,\"ui-menu-icon\")]");

    public void moveToSubMenu(String menu){
        By menuXpath = By.xpath("//span[text()='"+menu+"']");
        eleUtils.waitForWebElement(driver,menuIcon);
        eleUtils.mouserHover(driver,menuXpath);
    }
    public void moveToSubMenuAndClick(String menu){
        By menuXpath = By.xpath("//span[text()='"+menu+"']");
        eleUtils.waitForWebElement(driver,menuIcon);
        eleUtils.mouserHoverAndClick(driver,menuXpath);
        eleUtils.waitForWebElement(driver,msgInfo);
    }

    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }

}
