package pages;

import commonUtils.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage {

    public WebDriver driver;
    private Utility eleUtils;

    SearchPage searchPage;
    public AddToCartPage(WebDriver driver)
    {
        this.driver=driver;
        eleUtils = new Utility();
        searchPage = new SearchPage(driver);
    }

    public By inputSearch = By.id("search");

    public By productImage = By.xpath("//li[1]//img[@class='product-image-photo']");

    public By successMessage = By.xpath("//div[@role='alert']/div/div");

    public By selectSizeXS = By.xpath("//div[@aria-label='XS']");

    public By selectColor = By.xpath("//div[@aria-label='Gray']");

    public By buttonAddToCart = By.xpath("//button[@title='Add to Cart']/span");

    public By getCartProductCount = By.xpath("//span[@class='counter-number']");

    public By buttonCheckOut = By.id("top-cart-btn-checkout");

    public void searchAndAddToCart(String searchInput) {
        eleUtils.type(driver, inputSearch, searchInput);
        eleUtils.pressEnter(driver, inputSearch);
        eleUtils.mouserHoverAndClick(driver,productImage);
        eleUtils.clickOnElement(driver,selectSizeXS);
        eleUtils.clickOnElement(driver,selectColor);
        eleUtils.clickOnElement(driver,buttonAddToCart);
        eleUtils.waitForWebElement(driver,successMessage);
        eleUtils.clickOnElement(driver,getCartProductCount);
    }
    public String getTextFromElement(By locator){
        return eleUtils.getTextFromElement(driver, locator);

    }
}
