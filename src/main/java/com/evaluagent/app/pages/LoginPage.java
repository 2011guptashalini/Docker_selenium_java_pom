package com.evaluagent.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evaluagent.app.AbstractComponents.AbstractComponents;

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
		
		@FindBy(id="username")
		WebElement userEmail;
		
		@FindBy(id="continue")
		WebElement continueButton;
		
		@FindBy(xpath="//input[@id=\"password\"]")
		WebElement passwordEle;
		
		@FindBy(xpath="//button[@class=\"btn btn-primary stage-two\"]")
		WebElement submit;
		
	
		
		

		
		public GetStarted loginApplication(String email,String password)
		{
			userEmail.sendKeys(email);
			waitForAWhile(10);
			continueButton.click();
			waitForAWhile(10);
			passwordEle.sendKeys(password);
			waitForAWhile(10);
			submit.click();
			waitForAWhile(10);
			GetStarted getStarted = new GetStarted(driver);
			return getStarted;
			
			
		}



		public void goTo(String url) {
			driver.navigate().to(url);
			// TODO Auto-generated method stub
			
		}

}
