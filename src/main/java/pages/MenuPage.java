package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class MenuPage extends SeleniumWrappers {

	
	
	public MenuPage(WebDriver driver) {
		//this.driver = driver;
		super(driver);
	}
	
	public By myAccountLink = By.linkText("My account");
	public By searchField = By.id("dgwt-wcas-search-input-1");
	public By cartLink = By.linkText("CART");
	public By homeLink = By.linkText("HOME");
	public By blogLink = By.linkText("BLOG");
	
	public By wishlistLink = By.linkText("Wishlist");
	
	public By productCategoriesButton = By.cssSelector("div[class*='locked']");
	public By productCategoriesMenuList = By.cssSelector("li[class*='category-parent'] a");
	public By cartCountIcon = By.xpath("//span[@class='cart-count-icon']");
	
}
