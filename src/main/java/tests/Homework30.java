package tests;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;

import org.apache.logging.log4j.core.pattern.NotANumber;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import utils.BaseTest;
import utils.TestNgListener;

@Listeners(TestNgListener.class)
public class Homework30 extends BaseTest {
	
	
	@Test(priority =1)
	public void homework30Ex1()  {
		
		app.click(app.menu.myAccountLink);
		app.myAccountPage.loginInApp("florin", "florin@123");
		app.sendKeys(app.menu.searchField, "Pretzels");
		app.sendEnter();
		
		Double pricePerPiece = app.productPage.getProductSalePrice();
		app.click(app.productPage.addToCartButton);
		
		assertEquals(app.productPage.getAddedToCartAlertMessage(), "“Rold Gold Tiny Twists Pretzels” has been added to your cart.");
		
		app.menu.click(app.menu.cartLink);
		
		app.cartPage.increaseProductQty(1);
		//app.click(app.cartPage.increaseQtyButton);
		DecimalFormat dec = new DecimalFormat();
		
		
		
		app.cartPage.waitForElementToBeDisabled(app.cartPage.updateButton);		
		assertEquals(app.cartPage.getTotalPrice(), Double.parseDouble(dec.format( pricePerPiece * app.cartPage.getQty())));
		app.click(app.cartPage.proccedToCheckoutButton);
		app.click(app.checkoutPage.termAndCondCHeckbox);
		app.click(app.checkoutPage.placeOrderButton);
		assertEquals(app.getWebElement(app.checkoutPage.orderplacedMessage).getText(), "Thank you. Your order has been received.");
		assertTrue(app.getWebElement(app.checkoutPage.orderplacedNumber).getText()!="");
		app.click(app.menu.myAccountLink);
		app.click(app.myAccountPage.logoutButton);
		
	}
	@Test(priority = 2)
	public void homework30Ex2() {
		
		app.click(app.menu.blogLink);
		int numberOfArticles= app.getWebElementList(app.blogPage.blogArticle).size();
		assertEquals(numberOfArticles, 4);
		
		
		for (int i=0; i <numberOfArticles;i++) {
			
			app.getWebElementList(app.blogPage.blogArticle).get(i).click();
			String comment = String.valueOf("Test"+" " +(Math.floor(Math.random()*1000)+1));
			app.genericBlogPage.sendKeys(app.genericBlogPage.commentField, comment);
			app.genericBlogPage.sendKeys(app.genericBlogPage.authorField, "florin");
			app.genericBlogPage.sendKeys(app.genericBlogPage.emailField, "test@test.com");
			app.genericBlogPage.sendKeys(app.genericBlogPage.urlField, "http://test.com");
			app.genericBlogPage.click(app.genericBlogPage.submitButton);
			assertEquals(app.getWebElement(app.genericBlogPage.commentPosted).getText(), "Your comment is awaiting moderation.");
			app.navigateBack();
			app.navigateBack();
			
		}
	}
	
}
