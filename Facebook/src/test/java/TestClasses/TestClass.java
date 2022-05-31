package TestClasses;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browsers.Base;
import pomClasses.FriendsPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import utils.Utility;

public class TestClass {
	
	WebDriver driver;
	LoginPage loginpage;
	HomePage homepage;
	FriendsPage friendspage;
	SoftAssert soft;
	@Parameters ("browserName")
	@BeforeTest
	public void launchBrowser(String browser){
		System.out.println(browser);
	{
		if(browser.equals("Chrome"))
	     driver =  Base.openChromebrowser();
    }
	
	{
		if(browser.equals("Edge"))
	     driver =  Base.openEdgebrowser();
    }
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	@BeforeClass
	public void createPOMobject()
	{
		loginpage = new LoginPage(driver);
		homepage = new HomePage(driver);
		friendspage = new FriendsPage(driver);
		soft = new SoftAssert();
	}
	
	@BeforeMethod
	public void logintoApplication() 
	{
         driver.get("https://www.facebook.com/");
	     driver.manage().window().maximize();
	     loginpage.sendemailorphone();
	     loginpage.sendepassword();
	     loginpage.clickonlogIn();
	   }
	
	@Test
	public void verifyHomepage() throws InterruptedException 
	{
         homepage.clikonfrinds();
	     Thread.sleep(3000);
	 	 friendspage.clickonallfriends();
	 	 Thread.sleep(3000);
	 	 String url = driver.getCurrentUrl();
	 	 //System.out.println(url);
	     String  title = driver.getTitle();
//	     //System.out.println(title);
//	     Assert.assertEquals(url,"https://www.facebook.com/friends/list");
//		 Assert.assertEquals(title,"All friends | Facebook"); 
		 soft.assertEquals(url, "https://www.facebook.com/friends/list");
		 soft.assertEquals(title, "All friends | Facebook");
    }
	@Test
	public void verifyMarketPlace() throws InterruptedException
	{
		
	   homepage.clickonmarketpace();
	   Thread.sleep(3000);
		
	   String url = driver.getCurrentUrl();
	   String title = driver.getTitle();
	   
//	  Assert.assertEquals(url,"https://www.facebook.com/marketplace/?ref=bookmark");
//	  Assert.assertEquals(title,"Facebook Marketplace | Facebook");
	  soft.assertEquals(url, "https://www.facebook.com/marketplace/?ref=bookmark");
	  soft.assertEquals(title, "Facebook Marketplace | Facebook");
  }
	
	@AfterMethod
	public void logoutFromApplication(ITestResult result) throws InterruptedException, IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, 110);
		}
		 Thread.sleep(3000);
		 friendspage.logoutfromfb(driver);
	 	 
	}
	@AfterClass
	public void clearObject()
	{
		loginpage = null;
		homepage = null;
		friendspage = null;
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver = null;
	    System.gc();
	    
	}
	

}
