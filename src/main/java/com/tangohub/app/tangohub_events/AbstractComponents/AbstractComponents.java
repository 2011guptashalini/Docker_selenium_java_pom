/*This file will have common methods specific to application */
package com.tangohub.app.tangohub_events.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void waitForElementToAppear(By findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
//	// Change this to the locators of Login to the application 
//	@FindBy(css = "[routerlink*='cart']")
//	WebElement cartHeader;
//	
//	@FindBy(css = "[routerlink*='myorders']")
//	WebElement orderHeader;
//	
//	public CartPage goToCartPage()
//	{
//		cartHeader.click();
//		CartPage cartPage = new CartPage(driver);
//		return cartPage;
//	}
//	
//	public OrderPage goToOrdersPage()
//	{
//		orderHeader.click();
//		OrderPage orderPage = new OrderPage(driver);
//		return orderPage;
//	}

}
