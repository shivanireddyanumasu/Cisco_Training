package basePage;



import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();	

	
	public static WebDriver driver;
	public static Logger logger;
	@BeforeClass
	public void setup() {
		
		
	   System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		

	
	//logging into file
	logger=Logger.getLogger("Hippo");
	PropertyConfigurator.configure("Log4j.properties");
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	/***************************************************************************************************************************
                            COMMON METHODS 
     ********************************************************************************************************************/
	
	//Wait till page load
		public void waitForLoad(WebDriver driver) {
		    ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
		           public Boolean apply(WebDriver driver) {
		                 return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
		           }
		    };
		    WebDriverWait wait = new WebDriverWait(driver, 60);
		    wait.until(pageLoadCondition);
		}
		
		//Getting THE URL
		public String getUrl() {
			try {
				String sURL=driver.getCurrentUrl();
				if(!sURL.isEmpty()) {
					logger.info("Opening the URL : " + sURL);
					driver.manage().deleteAllCookies();
				} else
					throw(new IllegalArgumentException("String sURL is empty"));
			}catch(Exception e) {
				throw e;
			}
			return null;
		}
		
		//Getting the page Title
		public String getTitle() {
			try {
				String sTitle=driver.getTitle();
				if(!sTitle.isEmpty()) {
					logger.info("The Title is  : " + sTitle);
					driver.manage().deleteAllCookies();
				} else
					throw(new IllegalArgumentException("String sTitle is empty"));
			}catch(Exception e) {
				throw e;
			}
			return null;
		}
		
		//To get the browser name we are currently running scripts
		public void browserName() {
			Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
            String browserName = caps.getBrowserName();
            logger.info("Browser is: "+browserName);
		}
		
		//PageLoad
		public void  pageLoad()
				{
					try
					{
						JavascriptExecutor js = (JavascriptExecutor)driver;
						String test = js.executeScript("return document.readyState").toString();
						
						while (!test.equalsIgnoreCase("complete"))
						{
						driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
						test = js.executeScript("return document.readyState").toString();
						}
					}
					catch (Exception ex)
					{
						Assert.fail(ex.getMessage());
					}
				}
		
	     //deleting cookies
		public void deletecookies() {
			if (driver.findElements(By.xpath("//*[@id=\"truste-consent-content\"]")).size() > 0) {
				driver.findElement(By.xpath("//*[@id=\"truste-consent-button\"]")).click();
			}
		}

		//screenshot capture
		public void captureScreen(WebDriver driver,String tname) throws IOException {
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File Source = ts.getScreenshotAs(OutputType.FILE);
//			File Target = new File(System.getProperty("usr.dir") + "/Screenshots/" + tname + ".png");
//		    FileUtils.copyFile(Source,Target);
		}
    
	
	       
          	
	
	
	

}

