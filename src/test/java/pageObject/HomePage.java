package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	WebDriver driver;
	
	//Constructor
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}

	
	//Locators
	@FindBy(xpath="//span[@class=\"caret\"]")
	WebElement locMyAccount;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	WebElement locMyRegister;
	
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement linklogin;
	
	
	//Action Method
	public void clickMyAccount()
	{
		
		
		locMyAccount.click();
		
		
	}
	public void clickRegister()
	{

		locMyRegister.click();
		
	
	}
	public void clickLogin()
	{
		linklogin.click();
	}
	
	
	
}
