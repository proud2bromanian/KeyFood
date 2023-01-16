package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class CheckoutPage extends SeleniumWrappers {

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By termAndCondCHeckbox = By.id("terms");
	public By placeOrderButton = By.id("place_order");
	public By mandatoryBillingAdressFields = By.cssSelector("ul[class='woocommerce-error']>li");
	public By orderplacedMessage = By.xpath("//p[contains(@class,'woocommerce-thankyou-order-received')]");
	public By orderplacedNumber = By.xpath("//li[contains(@class,'woocommerce-order-overview__order')]/strong");
	
	
	
	
	
}
