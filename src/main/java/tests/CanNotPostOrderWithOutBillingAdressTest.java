package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.text.DecimalFormat;

import org.testng.annotations.Test;

import utils.BaseTest;

public class CanNotPostOrderWithOutBillingAdressTest extends BaseTest {
	
	@Test
	public void cannotOrderWithoutBillingAddressTest() {
		//app.menu.sendKeys(app.menu.searchField, "Organic Maple Syrup");
		app.sendKeys(app.menu.searchField, "Organic Maple Syrup");
		app.sendEnter();
		assertEquals(driver.getCurrentUrl(), "https://keyfood.ro/product/organic-maple-syrup/");
		Double pricePerPiece = app.productPage.getProductSalePrice();
		app.productPage.increaseProductQty(4);
		app.click(app.productPage.addToCartButton);
		System.out.println(app.productPage.getAddedToCartAlertMessage());
		assertEquals(app.productPage.getAddedToCartAlertMessage(), "5 × “Organic Maple Syrup” have been added to your cart.");
		
		app.click(app.menu.cartLink);
		DecimalFormat dec = new DecimalFormat();
		
		assertEquals(app.cartPage.getTotalPrice(), Double.parseDouble(dec.format( pricePerPiece*5)));
		app.click(app.cartPage.proccedToCheckoutButton);
		app.click(app.checkoutPage.termAndCondCHeckbox);
		app.click(app.checkoutPage.placeOrderButton);
		
		assertFalse(app.getWebElementList(app.checkoutPage.mandatoryBillingAdressFields).size() == 0);
		
	}
}
