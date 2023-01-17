package pages;

import java.util.ArrayList;
import java.util.Arrays;

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
	public By productCategoriesMenuList = By.xpath("//li[contains(@class,'category-parent')]/a");
	
	
	
	public By cartCountIcon = By.xpath("//div[contains(@class, 'header-cart')]//span[@class='cart-count-icon']");
	
	
	
	
	public By getProductCategoryMenuLink(int value) {
		
		ArrayList<String> productCategoriesMenuNames = new ArrayList<String>(Arrays.asList("Fruits & Vegetables","Meats & Seafood","Breakfast & Dairy","Beverages","Breads & Bakery","Frozen Foods","Biscuits & Snacks","Grocery & Staples"));
		String selectedCategory = productCategoriesMenuNames.get(value);
		return By.xpath("//li[contains(@class,'category-parent')]/a[contains(text(),'"+ selectedCategory +"')]");
		
	}
	
	
	
}
