package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumWrappers;

public class BlogPage extends SeleniumWrappers {

	public BlogPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public By blogArticle = By.cssSelector("article[class*='status-publish'] div h2 a");
	
	
	

}
