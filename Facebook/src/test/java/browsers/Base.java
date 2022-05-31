package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Base {
	
	public static WebDriver openChromebrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromeDriverexe\\chromedriver.exe");
		
	      WebDriver driver = new ChromeDriver();
	      
	      return driver;
	}
	
	
	public static WebDriver openEdgebrowser()
	{
		System.setProperty("webdriver.edge.driver","D:\\edge\\msedgedriver.exe");
		
	      WebDriver driver = new EdgeDriver();
	      
	      return driver;
	}



}
