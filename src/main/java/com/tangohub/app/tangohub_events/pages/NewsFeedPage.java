package com.tangohub.app.tangohub_events.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tangohub.app.tangohub_events.AbstractComponents.AbstractComponents;

public class NewsFeedPage extends AbstractComponents {
	WebDriver driver;
	public NewsFeedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
			//PageFactory
			
		@FindBy(xpath="//h1[text()='News Feed']")
		WebElement newsFeed;
			
		public Boolean VerifyNewsFeedDisplayed() {
			Boolean match = newsFeed.isDisplayed();
			return match;


}
}
