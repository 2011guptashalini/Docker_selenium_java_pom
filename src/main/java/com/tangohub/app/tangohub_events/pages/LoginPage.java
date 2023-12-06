package com.tangohub.app.tangohub_events.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tangohub.app.tangohub_events.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
		//PageFactory
		
		@FindBy(id="user_login")
		WebElement userEmail;
		
		@FindBy(id="user_pass")
		WebElement passwordEle;
		
		@FindBy(id="wp-submit")
		WebElement submit;
		

		
		public NewsFeedPage loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			NewsFeedPage landingPage = new NewsFeedPage(driver);
			return landingPage;
			
			
		}



		public void goTo(String url) {
			driver.navigate().to(url);
			// TODO Auto-generated method stub
			
		}

}
