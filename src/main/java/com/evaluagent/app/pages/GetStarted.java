package com.evaluagent.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.evaluagent.app.AbstractComponents.AbstractComponents;

public class GetStarted extends AbstractComponents {
	WebDriver driver;
	public GetStarted(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
			//PageFactory
			
	@FindBy(xpath="//h2[text()='Get Started with EvaluAgent']")
	WebElement welcomeText;
			
		public Boolean VerifyGetStartedPageDisplayed() {
			Boolean match = welcomeText.isDisplayed();
			return match;


}
}
