package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    public WebDriver driver;
    private Utility eleUtils;
    public SearchPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
    }

    public By inputSearch = By.id("search");

    public By pageHeader = By.xpath("//span[@class='base']");

    public By textItemSearch = By.xpath("//li[@class='item search']");

    public void setInputSearchAndEnter(String searchInput) {
        eleUtils.type(driver, inputSearch, searchInput);
        eleUtils.pressEnter(driver, inputSearch);
    }
    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }
}
