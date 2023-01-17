package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class ProductPage extends SeleniumWrappers {

	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public By salePrice = By.cssSelector("p[class='price'] span[class*='woocommerce-Price-amount']");
	public By increaseQtyButton = By.xpath("(//i[@class='klbth-icon-plus'])[1]");
	public By addToCartButton= By.cssSelector("button[name='add-to-cart']");
	public By addToCartAllertMessage = By.cssSelector("div[class='woocommerce-message']");
	public By addToWishlistButton = By.xpath("//div[@class='product-actions']//a");
	public By closeWishlistPopupButton = By.cssSelector("button[class*='tinvwl_button_close']");
	
	public double getProductSalePrice() {
		String price = driver.findElement(salePrice).getText().replace("$", "");
		
		return Double.parseDouble(price);
		
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
	

}
