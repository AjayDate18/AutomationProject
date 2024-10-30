package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage  extends BasePage
{
	public WebDriver driver;
	//constructor
	public AccountRegistrationPage(WebDriver driver) 
	{
		super(driver);
	}
	
	//Locators
	
	
	@FindBy(xpath="//input[@placeholder=\"First Name\"]")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@placeholder=\"Last Name\"]")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@placeholder=\"E-Mail\"]")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@placeholder=\"Telephone\"]")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@placeholder=\"Password\"]")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@placeholder=\"Password Confirm\"]")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]")
	WebElement chkSetPrivacy;
	
	@FindBy(xpath="//input[@type=\"submit\"]")
	WebElement btnContinue;

	@FindBy(xpath="//div[@id=\"content\"]//h1") 
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone)
	{
		txtTelephone.sendKeys(telephone);
	}
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	public void setConfirmPassword(String confpwd)
	{
		txtConfirmPassword.sendKeys(confpwd);
	}
	public void setPrivacy()
	{
		chkSetPrivacy.click();
		
	}
	
	public void clickContinue()
	{
		btnContinue.click();
		
		//Sol1
		 //btnContinue.submit();
		
		//Sol2
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//Sol3-->Explict Wait
		//WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(30));
		//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		
		//sol4 
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", "btnContinue");
		
		
	}
	
	
	public String getConfirmationMsg()
	{
		try 
		{
			return (msgConfirmation.getText());
		} catch (Exception e) 
		{
			return (e.getMessage());
		}
	}
}
