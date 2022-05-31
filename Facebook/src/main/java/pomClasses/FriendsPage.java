package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FriendsPage {
	@FindBy (xpath = "//span[text()='All friends']")
	private WebElement Allfriends ;
	
	@FindBy (xpath = "(//div[@aria-label='Your profile'])[1]")
	private WebElement sysmbol ;
	
	@FindBy (xpath = "(//div[@data-visualcompletion='ignore-dynamic']//div[1]//span)[7]") 
	private WebElement logout ;
	
	
	private WebDriverWait wait;
	
	public FriendsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickonallfriends()
	{
		
		Allfriends.click();
        
	}
	public  void logoutfromfb(WebDriver driver)
	{
		
		Actions act = new Actions(driver);
		act.moveToElement(sysmbol).click().build().perform();
		wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(logout));
		act.moveToElement(logout).click().build().perform();
	}
	
}
