package commonUtils;

import base.TestBase;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Utility extends TestBase{

	// return the page title
	public String getPageTitle(WebDriver driver){
		return driver.getTitle();
	}

	// To check if element is present, if present then return true otherwise false
	public boolean isElementPresent(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("LONG_WAIT_TIMEOUT"))));

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        if(element != null){
			return true;
		}
		else {
			return false;
		}
	}

	//To wait for element to be present
	public WebElement waitForWebElement(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("LONG_WAIT_TIMEOUT"))));

		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		return element;
	}

    // To click on web element
	public void clickOnElement(WebDriver driver,By locator)
	{
		WebElement element = waitForElementToBeClickable(driver,locator);

		element.click();

	}

	// Wait for element to be clickable
	public WebElement waitForElementToBeClickable(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("LONG_WAIT_TIMEOUT"))));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

		return element;
	}

	//To get the current time
	public static String getCurrentTimeStamp()
	{
		String date=new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date());
		
		return date;
	}

	// TO fetch the time from element
	public String getTextFromElement(WebDriver driver, By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(PropertyFileReader.getProperty("LONG_WAIT_TIMEOUT"))));

		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		return element.getText();

	}

	// To move cursor on web element
	public void mouserHover(WebDriver driver, By locator)
	{
		WebElement element = waitForWebElement(driver, locator);
		Actions action = new Actions(driver);

		action.moveToElement(element).perform();
	}

	//// To move cursor on web element and click
	public void mouserHoverAndClick(WebDriver driver, By locator)
	{
		WebElement element =driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
	}

	//To press Enter button
	public void pressEnter(WebDriver driver, By locator)
	{
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(locator);
		element.sendKeys(Keys.ENTER);
	}

	// To type in input field
	
	public void type(WebDriver driver,By locator,String text)
	{
		WebElement element = waitForWebElement(driver, locator);
		element.sendKeys(text);


	}
	

	
}
