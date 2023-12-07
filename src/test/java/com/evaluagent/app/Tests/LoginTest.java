package com.evaluagent.app.Tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import com.evaluagent.app.TestComponents.Retry;
import com.evaluagent.app.TestComponents.BaseTest;

public class LoginTest extends BaseTest{
	//String productName = "ZARA COAT 3";

	@Test(dataProvider="getData",groups= {"Smoke"}, retryAnalyzer=Retry.class)
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
		getStarted = loginPage.loginApplication(input.get("email"), input.get("password"));
		Boolean match = getStarted.VerifyGetStartedPageDisplayed();
		Assert.assertTrue(match);
	}
	

	
	//Extent Reports - 
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//com//evaluagent//app/Data//LoginCreds.json");
		return new Object[][]  {{data.get(0)}};
		
	}
	

	  
	
	
	
	
	
	
	
	


}
