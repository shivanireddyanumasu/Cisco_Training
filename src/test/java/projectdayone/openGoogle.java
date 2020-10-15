package projectdayone;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class openGoogle {
	WebDriver driver = null;
	@Test
	public void method1() {
	System.setProperty("webdriver.chrome.driver" , "C:\\Users\\shivanireddy\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get("http://google.com/");
	driver.close();
	}

}
