package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.SeleniumWrappers;

public class WishlistPage extends SeleniumWrappers {


	public WishlistPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	public By wishlistRow = By.cssSelector("tr[class='wishlist_item']");
	public By wishlistProductName= By.cssSelector("td[class='product-name'] a");
	public By wishlistAddToCartButton = By.cssSelector("td button[name='tinvwl-add-to-cart']");
	public By wishlistDropDown = By.cssSelector("select[name='product_actions']");
	public By checkAll = By.cssSelector("th input[type='checkbox']");
	public By errorMessage = By.xpath("//ul[@class='woocommerce-error']/li");
	public By submitDropdownAction = By.cssSelector("span button[name='tinvwl-action']");
}
