package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy (xpath = "//span[text()='Friends']") 
	private WebElement friends ;
	
	@FindBy (xpath = "//span[text()='Marketplace'//]")
	private WebElement marketplace;
	
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clikonfrinds()
	{
		
		friends.click();
		
	}
	
	public void clickonmarketpace()
	{
		marketplace.click();
	}
	
	
	

}
