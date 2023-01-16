package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumWrappers;

public class GenericBlogPage extends SeleniumWrappers {

	public GenericBlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public By commentField = By.id("comment");
	public By authorField = By.id("author");
	public By emailField = By.id("email");
	public By urlField = By.id("url");
	public By submitButton = By.id("submit");
	public By commentPosted = By.xpath("//div[@class='comment-content']/div[@class='klb-post']/em");
}
