package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import utils.BaseTest;

public class Homework31_2 extends BaseTest {

	@Test
	public void homework() {	
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap <String, Integer>() {{ 
		put("Fresh Produce Melons Each", 0); 
		put("Vital Farms Pasture-Raised Egg Bites Bacon & Cheddar", 2);
		put("Shimmer Pastel Almond Blend", 6);
		put("Zevia Kidz Strawberry Lemonade Zero Calorie Soda", 3);
		}};				
		
		app.click(app.menu.myAccountLink);
		app.sendKeys(app.myAccountPage.usernameField, "florin");
		app.sendKeys(app.myAccountPage.passwordField, "florin@123");
		app.click(app.myAccountPage.loginButton);			
		
		for (Map.Entry<String, Integer> pair : map.entrySet()) {		
			  app.click(app.menu.productCategoriesButton);
			  app.click(app.menu.getProductCategoryMenuLink(pair.getValue()));
			  app.click(app.productCategoryPage.getProduct(pair.getKey()));
			  app.click(app.productPage.addToWishlistButton);
			  app.click(app.productPage.closeWishlistPopupButton);					
		}
		
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

	
}
