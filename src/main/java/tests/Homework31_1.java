package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class Homework31_1 extends BaseTest{
	
	
	@Test
	public void homework31SecondEdition() {
		app.click(app.menu.myAccountLink);
		app.sendKeys(app.myAccountPage.usernameField, "florin");
		app.sendKeys(app.myAccountPage.passwordField, "florin@123");
		app.click(app.myAccountPage.loginButton);
		
		List <Integer> list =  Arrays.asList(1,2,3,4);		
		for(int i = 1; i <=list.size();i++) {			
			int menulistIndex = 0;
			int categoryPageIndex = 2;
			switch(list.indexOf(i)) {  		
			 
			 case 1:  menulistIndex = 2;
			 			categoryPageIndex =7;		
	         break;
			 case 2:  menulistIndex = 6;
			 			categoryPageIndex =3;
	         break;
			 case 3:  menulistIndex = 3;
			 			categoryPageIndex =10;
	         break;
			}
			
			app.click(app.menu.productCategoriesButton);
			app.getWebElementList(app.menu.productCategoriesMenuList).get(menulistIndex).click();
			app.getWebElementList(app.productCategoryPage.products).get(categoryPageIndex).click();
			app.click(app.productPage.addToWishlistButton);
			app.click(app.productPage.closeWishlistPopupButton);			
		}
		app.click(app.menu.wishlistLink);
		for( int row =0; row< app.getWebElementList( app.wishlistPage.wishlistRow).size() ;row++) {
			
			//System.out.println(app.getWebElementList(app.wishlistPage.wishlistProductName).get(row).getText());
			
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
