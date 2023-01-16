package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumWrappers;

public class CartPage extends SeleniumWrappers  {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By totalPrice = By.cssSelector("td[data-title='Total'] span[class*='woocommerce-Price-amount']");
	public By proccedToCheckoutButton = By.linkText("Proceed to checkout");
	
	public By increaseQtyButton = By.xpath("(//i[@class='klbth-icon-plus'])[1]");
	public By updateButton = By.cssSelector("button[name='update_cart']");
	public By addToCartButton= By.cssSelector("button[type='submit']");
	public By addToCartAllertMessage = By.cssSelector("div[class='woocommerce-message']");
	
	
	
	//public By productQty = By.cssSelector("div[class='quantity']>input[class*='input-text']").;
	
	public double getTotalPrice() {
		
		return Double.parseDouble(driver.findElement(totalPrice).getText().substring(1));
	}
	public void increaseProductQty(int times) {
		for(int i = 0; i < times; i++) {
			click(increaseQtyButton);
		}
	}
	public String getAddedToCartAlertMessage() {
		String initialString = driver.findElement(addToCartAllertMessage).getText().replace("View cart", "").substring(1);
		
		return initialString;
	
	}
	public int getQty() {
		String productQty =driver.findElement(By.cssSelector("div[class='quantity']>input[class*='input-text']")).getAttribute("value");
		return Integer.parseInt(productQty);
	}
	
	public WebElement getUpdateButton() {		
		 
		return driver.findElement(updateButton);
	}
	
	

}
