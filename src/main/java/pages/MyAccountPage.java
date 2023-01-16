package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class MyAccountPage extends SeleniumWrappers{

	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
	}
	
	public By usernameField = By.id("username");
	public By passwordField = By.id("password");
	public By loginButton = By.cssSelector("button[name='login']");
	
	public By loginErrorMsg = By.cssSelector("ul[class='woocommerce-error'] strong");
	public By usernameGreetings = By.cssSelector("div[class='woocommerce-MyAccount-content'] strong");
	public By logoutButton = By.linkText("Log out");
	
	public void loginInApp(String user, String pass) {
		sendKeys(usernameField, user);
		sendKeys(passwordField, pass);
		click(loginButton);
	}
	
	public boolean loginMsgIsDisplayed(By locator) {
		
		return driver.findElement(locator).isDisplayed();
	}
	
}
