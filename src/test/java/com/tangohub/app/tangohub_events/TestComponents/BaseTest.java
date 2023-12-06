package com.tangohub.app.tangohub_events.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.tangohub.app.tangohub_events.pages.LoginPage;



public class BaseTest {

	//public WebDriver driver;
	public LoginPage loginPage;
	//public Properties prop = new Properties();
	

	/*public WebDriver initializeDriver(String browser) throws IOException

	{
		// properties class
		String host = getProp("host");
		//String bName = getProp("browser");
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//String browserName = System.getProperty("browser")!=null ? System.getProperty("browser"): (bName);
		//String browserName = prop.getProperty("browser");

		if (browser.contains("chrome")) {
			cap.setBrowserName("chrome");

		} else if (browser.equalsIgnoreCase("firefox")) {
			cap.setBrowserName("firefox");

			// Firefox
		} else if (browser.equalsIgnoreCase("edge")) {
			// Edge
			cap.setBrowserName("edge");
		}
		//String completeURL = "http://"+host+":4444";
		String completeURL = "http://localhost:4444";
		//URL gridUrl = new URL(completeURL);
		driver = new RemoteWebDriver(new URL(completeURL),cap);

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.manage().window().maximize();
		return driver;

	}
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public LoginPage launchApplication() throws IOException
	{
		
		driver = initializeDriver("browser");
		loginPage = new LoginPage(driver);
		
		String url = getProp("url");

		loginPage.goTo(url);
		return loginPage;
	
		
	}*/
	protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    public static String remote_url = "http://localhost:4444";
    public final static int TIMEOUT = 5;
   
	    @BeforeMethod
	    @Parameters("browser")
	    public void setUp(String browser) throws Exception {
	    	String url = getProp("url");
	        if(browser.equalsIgnoreCase("chrome")) {
	 
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--start-maximized");
	            options.addArguments("--headless=new");
	            options.addArguments("--remote-allow-origins=*");
	            driver.set(new RemoteWebDriver(new URL(remote_url), options));
	            System.out.println("Browser Started :"+ browser);
	 
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            FirefoxOptions options = new FirefoxOptions();
	            options.addArguments("--start-maximized");
	            options.addArguments("-headless");
	            driver.set(new RemoteWebDriver(new URL(remote_url), options));
	            System.out.println("Browser Started :"+ browser);
	 
	        } else if (browser.equalsIgnoreCase("edge")) {
	            EdgeOptions options = new EdgeOptions();
	            options.addArguments("--start-maximized");
	            options.addArguments("--headless=new");
	            driver.set(new RemoteWebDriver(new URL(remote_url), options));
	            System.out.println("Browser Started :"+ browser);
	 
	        } else {
	            throw new Exception ("Browser is not correct");
	        }
	 
	        driver.get().get(url);	        
	        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
	 
	  public WebDriver getDriver() {
	        return driver.get();
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
	
	//{map, map}

	}
	
	public String getScreenshot(String testCaseName,ThreadLocal<RemoteWebDriver> driver2) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver2;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}
	
	public String getProp(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "//src//main//java/com//tangohub//app//tangohub_events//resources//GlobalData.properties");
		prop.load(fis);
		String keyValue = prop.getProperty(key);
		return keyValue;
	}
	

	
	@AfterMethod(alwaysRun=true)
	
	public void tearDown()
	{
		driver.get().close();
	}
}
