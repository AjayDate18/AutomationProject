package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage  extends BasePage
{
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath="//h2[contains(text(),'My Account')]")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][13]")
	WebElement linklogout;
	
	
	public boolean isMyAccountExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickLogout()
	{
		linklogout.click();
	}
}
