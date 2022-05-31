package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (xpath = "//input[@type='text'] ")
	private WebElement emailorphone;
	
	@FindBy (xpath = "//input[@id='pass'] ")
	private WebElement password;
	
	@FindBy (xpath = "//button[text()='Log In'] ")
	private WebElement logIn ;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void sendemailorphone()
	{
		emailorphone.sendKeys("8888244120");
	}
	public void sendepassword()
	{
		password.sendKeys("amol@143");
	}
	public void clickonlogIn()
	{
		logIn.click();
	}
	
//	public void logintofb()
//	{
//		emailorphone.sendKeys("8888244120");
//		password.sendKeys("amol@143");
//		logIn.click();
//	}

}
