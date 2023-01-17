package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class ProductCategoryPage extends SeleniumWrappers {
	
	
	public ProductCategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public By products = By.xpath("//div[contains(@class,'type-product')]//div[@class='thumbnail-wrapper']/a");
	//public By products = By.xpath("//h3[@class='product-title']/a");
	
	public By getProduct(String value) {
		
		
		
		return By.xpath(("//div[contains(@class,'type-product')]//div[@class='thumbnail-wrapper']/a/img[contains(@alt, '"+value +"')]/parent::a"));
		
	}
	
}
