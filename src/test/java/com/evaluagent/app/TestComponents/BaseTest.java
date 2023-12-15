package com.evaluagent.app.TestComponents;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.evaluagent.app.pages.LoginPage;
import com.evaluagent.app.pages.GetStarted;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BaseTest {

	public LoginPage loginPage;
	public GetStarted getStarted;
	
	public static WebDriver driver;
    public static String remote_url = "http://localhost:4444";
    public final static int TIMEOUT = 5;
    DesiredCapabilities cap = new DesiredCapabilities();
   
	    @BeforeMethod
	    @Parameters("browser")
	    public LoginPage setUp(@Optional("firefox")String browser) throws Exception {
	    	String url = getProp("url");
	        if(browser.equalsIgnoreCase("chrome")) {
	        	ChromeOptions chromeOptions = new ChromeOptions();
	            chromeOptions.addArguments("--disable-dev-shm-usage");
	            driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(), chromeOptions);
	            
	            System.out.println("Browser Started :"+ browser);
	 
	        } else if (browser.equalsIgnoreCase("firefox")) {
	           
	            cap.setBrowserName("firefox");
	            driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(), cap);
	            
	            System.out.println("Browser Started :"+ browser);
	 
	        } else if (browser.equalsIgnoreCase("edge")) {
	        	EdgeOptions edgeOptions = new EdgeOptions();
	        	edgeOptions.addArguments("--disable-dev-shm-usage");
	            driver = new RemoteWebDriver(new URI("http://localhost:4444").toURL(), edgeOptions);
	            
	            System.out.println("Browser Started :"+ browser);
	 
	        } else {
	            throw new Exception ("Browser is not correct");
	        }
	        loginPage = new LoginPage(driver);
	        loginPage.goTo(url);
	        Thread.sleep(15000);
	        //loginPage.loginApplication("2011guptashalini@gmail.com", "Test@2007");
	        
			  
	        return loginPage;
	        
	    }
	    
	    
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	

	}
	

	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	public String getProp(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java//com//evaluagent//app/resources//GlobalData.properties");
		prop.load(fis);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}
	
  
	
	@AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.quit();
		}
	   

  
	
	
}

	


