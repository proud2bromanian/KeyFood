package utils;

import java.time.Duration;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

public class SeleniumWrappers extends BaseTest {

	public SeleniumWrappers(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//WebElement element =  driver.findElement(locator);
	//element.click();
	
	
	public void sendEnter() {
		
		try {
			Log.info("calling method <sendEnter>");
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).perform();
			
		}catch(Exception e) {
			Log.error(e.getMessage());
		}
		
	}
	
	public List<WebElement> getWebElementList(By locator){	
		return driver.findElements(locator);
		
	}
	
	
	
	
	public WebElement getWebElement(By locator) {
		waitForElementToBeVisible(locator);
		return driver.findElement(locator);
	}
		
	
	public void dragAndDrop(By locator, int x, int y) {
		
		try {
			Actions action =  new Actions(driver);
		//	action.dragAndDropBy(element, x, y).perform();	
			action.clickAndHold(getWebElement(locator)).moveByOffset(x, y).release().perform();
						
		}catch(NoSuchElementException e) {
			new TestException(e.getMessage());	
		}
		
	}
	
	

	public void hoverElement(By locator) {
	try {
		//WebElement element = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(locator)).perform();
		
	}catch(NoSuchElementException e) {
		new TestException(e.getMessage());
		}
		
	}
	
	
	
	
	/**
	 * Custom click method, that waits for element to be clickable before triggering click
	 * @param locator --> webelement locator
	 */
	public void click(By locator) {
		
		try {
			waitForElementToBeClickable(locator);
			WebElement element =  driver.findElement(locator);
			Log.info("called method <Click()> on element :" + element.getAttribute("outerHTML"));
			element.click();
		//	getWebElement(locator).click();
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <Click> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
			
		}catch (StaleElementReferenceException e) {
			waitForElementToBeClickable(locator);
			WebElement element =  driver.findElement(locator);
			Log.info("called method <Click()> on element :" + element.getAttribute("outerHTML"));
			element.click();		}
		
	}
	
	
	public void waitForElementToBeClickable(By locator) {
		try {
			Log.info("Called method <waitForElementToBeClickable> on element with locator :" + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeClickable> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void waitForElementToBeVisible(By locator) {
		try {
			Log.info("Called method <waitForElementToBeVisible> on element with locator :" + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));	
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToBeVisible> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public boolean checkElementIsDisplayed(By locator) {
		
		 return driver.findElement(locator).isDisplayed();
	}
	
	public void waitForElementToBeDisabled(By locator) {
		try {
			Log.info("Called method <waitForElementToDisabled> on element with locator :" + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeContains(locator, "disabled", "true"));	
			
		}catch(NoSuchElementException e) {
			Log.error("Element not found on method <waitForElementToDisabled> after 10 sec wait");
			Log.error(e.getMessage());
			throw new TestException(e.getMessage());
		}
	}
	
	public void sendKeys(By locator, String textToBeSend) {
		try {
			
			waitForElementToBeVisible(locator);
			WebElement element  = driver.findElement(locator);
			Log.info("called clear on method <sendkeys> on element " + element.getAttribute("outerHTML"));
			element.clear();
			Log.info("called sendkeys on method <sendkeys> on element " + element.getAttribute("outerHTML"));
			element.sendKeys(textToBeSend);
			
		}catch(NoSuchElementException e) {
			Log.error("Failed method <sendKeys> with error " + e.getMessage());
			throw new TestException(e.getMessage());

		}
		
		
	}
	public void dropdownSelect(By locator, String value) {
		try {
			waitForElementToBeVisible(locator);
			WebElement element  = driver.findElement(locator);
			Select select = new Select(element);
			Log.info("called select on method <dropdownSelect> on element " + element.getAttribute("outerHTML"));
			select.selectByValue(value);			
		}catch(NoSuchElementException e) {
			Log.error("Failed method <dropdownSelect> with error " + e.getMessage());
			throw new TestException(e.getMessage());
		}
	
	}
	public void navigateBack() {
		driver.navigate().back();
	}
	
	
	
	

}
