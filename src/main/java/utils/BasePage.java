package utils;


import org.openqa.selenium.WebDriver;

import pages.BlogPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.GenericBlogPage;
import pages.HomePage;
import pages.MenuPage;
import pages.MyAccountPage;
import pages.ProductCategoryPage;
import pages.ProductPage;
import pages.WishlistPage;

public class BasePage  extends SeleniumWrappers{

	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public MenuPage menu  =  new MenuPage(driver);
	public MyAccountPage myAccountPage =  new MyAccountPage(driver);
	public ProductPage productPage =  new ProductPage(driver);
	public CartPage cartPage =  new CartPage(driver);
	public CheckoutPage checkoutPage =  new CheckoutPage(driver);
	public HomePage homePage = new HomePage(driver);
	public BlogPage blogPage = new BlogPage(driver);
	public GenericBlogPage genericBlogPage = new GenericBlogPage(driver);
	public ProductCategoryPage productCategoryPage = new ProductCategoryPage(driver);
	public WishlistPage wishlistPage = new WishlistPage(driver);
	

}
