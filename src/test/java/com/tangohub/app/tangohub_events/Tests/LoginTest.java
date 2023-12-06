package com.tangohub.app.tangohub_events.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tangohub.app.tangohub_events.pages.NewsFeedPage;

import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.tangohub.app.tangohub_events.TestComponents.BaseTest;

public class LoginTest extends BaseTest{
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Smoke"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
		NewsFeedPage newsFeedPage = loginPage.loginApplication(input.get("email"), input.get("password"));
		Boolean match = newsFeedPage.VerifyNewsFeedDisplayed();
		Assert.assertTrue(match);
	}
	

	
	//Extent Reports - 
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//com//tangohub//app//tangohub_events//Data//LoginCreds.json");
		return new Object[][]  {{data.get(0)}};
		
	}
	

	  
	
	
	
	
	
	
	
	


}
