package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import utils.BaseTest;

public class Homework31 extends BaseTest {

	
	@Test
	public void homework() {
		
		app.click(app.menu.myAccountLink);
		app.sendKeys(app.myAccountPage.usernameField, "florin");
		app.sendKeys(app.myAccountPage.passwordField, "florin@123");
		app.click(app.myAccountPage.loginButton);
		
		
		app.click(app.menu.productCategoriesButton);
		app.getWebElementList(app.menu.productCategoriesMenuList).get(0).click();
		app.getWebElementList(app.productCategoryPage.products).get(2).click();
		app.click(app.productPage.addToWishlistButton);
		app.click(app.productPage.closeWishlistPopupButton);
		
		app.click(app.menu.productCategoriesButton);
		app.getWebElementList(app.menu.productCategoriesMenuList).get(2).click();
		app.getWebElementList(app.productCategoryPage.products).get(7).click();
		app.click(app.productPage.addToWishlistButton);
		app.click(app.productPage.closeWishlistPopupButton);
		
		app.click(app.menu.productCategoriesButton);
		app.getWebElementList(app.menu.productCategoriesMenuList).get(6).click();
		app.getWebElementList(app.productCategoryPage.products).get(3).click();
		app.click(app.productPage.addToWishlistButton);
		app.click(app.productPage.closeWishlistPopupButton);
		
		app.click(app.menu.productCategoriesButton);
		app.getWebElementList(app.menu.productCategoriesMenuList).get(3).click();
		app.getWebElementList(app.productCategoryPage.products).get(10).click();		
		app.click(app.productPage.addToWishlistButton);
		app.click(app.productPage.closeWishlistPopupButton);
		
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
