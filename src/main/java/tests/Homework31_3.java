package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework31_3 extends BaseTest {
	
	
	@Test
	public void homeworkv4() {
		app.click(app.menu.myAccountLink);
		app.sendKeys(app.myAccountPage.usernameField, "florin");
		app.sendKeys(app.myAccountPage.passwordField, "florin@123");
		app.click(app.myAccountPage.loginButton);	
		addProductToWishlist("Fresh Produce Melons Each", 0); 
		addProductToWishlist("Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar", 2);
		addProductToWishlist("Shimmer Pastel Almond Blend", 6);
		addProductToWishlist("Zevia Kidz Strawberry Lemonade Zero Calorie Soda", 3);
	    app.click(app.menu.wishlistLink);
		
		for( int row =0; row< app.getWebElementList( app.wishlistPage.wishlistRow).size() ;row++) {					
			assertTrue(app.getWebElementList(app.wishlistPage.wishlistProductName).get(row).isDisplayed());
			assertTrue(app.getWebElementList(app.wishlistPage.wishlistAddToCartButton).get(row).isDisplayed());			
		}
		
		app.click(app.wishlistPage.checkAll);
		app.dropdownSelect(app.wishlistPage.wishlistDropDown,"add_selected");
		app.click(app.wishlistPage.submitDropdownAction);		
		assertEquals(app.getWebElement(app.menu.cartCountIcon).getText(), "3");
		assertEquals(app.getWebElement(app.wishlistPage.errorMessage).getText(), "Product “Zevia Kidz Strawberry Lemonade Zero Calorie Soda” could not be added to cart because some requirements are not met.");
		
	}
	
	public void addProductToWishlist(String productName, int productCategoryIndex) {
		app.click(app.menu.productCategoriesButton);
		  app.click(app.menu.getProductCategoryMenuLink(productCategoryIndex));
		  app.click(app.productCategoryPage.getProduct(productName));
		  app.click(app.productPage.addToWishlistButton);
		  app.click(app.productPage.closeWishlistPopupButton);
	}
}
