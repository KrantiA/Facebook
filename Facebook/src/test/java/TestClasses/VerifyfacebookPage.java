package TestClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.FriendsPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyfacebookPage {
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver","D:\\chromeDriverexe\\chromedriver.exe");
			
	     WebDriver driver = new ChromeDriver();
	     
	     driver.get("https://www.facebook.com/");
	     
	     driver.manage().window().maximize();
	     
	     LoginPage loginpage = new LoginPage(driver);
	     
	     loginpage.sendemailorphone();
	     loginpage.sendepassword();
	     loginpage.clickonlogIn();
	     
	    // Thread.sleep(1000);
	     
	     String url = driver.getCurrentUrl();
	     System.out.println(url);
	     
	     String title = driver.getTitle();
	     System.out.println(title);
	      
	     if(url.equals("https://www.facebook.com/") && title.equals("Facebook"))
	     {
	    	 System.out.println("pass");
	    	 
	     }
	     else
	     {
	    	 System.out.println("failed");
	     }
	     
	     Thread.sleep(3000);
	     HomePage homepage = new HomePage(driver);
	 	 homepage.clikonfrinds();
	 	 Thread.sleep(3000);
	 	 FriendsPage friendspage = new FriendsPage(driver);
	 	 friendspage.clickonallfriends();
	 	
	 	 Thread.sleep(3000);
	 	 
	     url = driver.getCurrentUrl();
	     System.out.println(url);
	     
	     title = driver.getTitle();
	     System.out.println(title);
	     
	     if(url.equals("https://www.facebook.com/friends/list") && title.equals("All friends | Facebook"))
	     {
	    	 System.out.println("pass");
	    	 
	     }
	     else
	     {
	    	 System.out.println("failed");
	     }
	     
	     Thread.sleep(3000);
	     friendspage.logoutfromfb(driver);
	     Thread.sleep(3000);
	     
	     // 2nd test case
	     
	     driver.get("https://www.facebook.com/");
	     loginpage = new LoginPage(driver);
	     loginpage.sendemailorphone();
	     loginpage.sendepassword();
	     loginpage.clickonlogIn();
	     
	     homepage = new HomePage(driver);
	     homepage.clickonmarketpace();
	     Thread.sleep(3000);
	     
	     url = driver.getCurrentUrl();
	     System.out.println(url);
	     
	     title = driver.getTitle();
	     System.out.println(title);
	     
	     if(url.equals("https://www.facebook.com/marketplace/?ref=bookmark") && title.equals("Facebook Marketplace | Facebook"))
	     {
	    	 System.out.println("pass");
	    	 
	     }
	     else
	     {
	    	 System.out.println("failed");
	     }
	     
	     friendspage = new FriendsPage(driver);
	     Thread.sleep(7000);
	 	 friendspage.logoutfromfb(driver);
	 	 Thread.sleep(3000);
	 	 driver.close();
	     
	     
	     
}

}
