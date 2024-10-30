package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBaseClass.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	
	
	
	@Test(groups={"Regression","Master"})
	public void verfy_account_registration()
	{
		logger.info("Starting TC001_AccountRegistrationTest");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on Register Link");
		hp.clickRegister();
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		logger.info("Providing Customer Details");
		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
		regPage.setEmail(randomString()+"@gmail.com");
		
		regPage.setTelephone(randomNumber());
		
		
		String password=randomAplhaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
	    regPage.setPrivacy();
	    regPage.clickContinue();
	   logger.info("Validating Expected Message");
	    
	    String confMsg=regPage.getConfirmationMsg();
	    if(confMsg.equals("Your Account Has Been Created!"))
	    {
	    	Assert.assertTrue(true);

	    }	
	    else
	    {
	    	logger.error("Test Failed..");
	    	logger.debug("Debug Test");
	    	Assert.assertTrue(false);
	    }	
	    
	    //Assert.assertEquals(confMsg, "Your Account Has Been Created!");
		
		
	}
	
	public String randomString()
	{
		String genratedString=RandomStringUtils.randomAlphabetic(5);
		return genratedString;
	}
	
	public String randomNumber()
	{
		String genratedNumber=RandomStringUtils.randomNumeric(10);
		return genratedNumber;
	}
	
	public String randomAplhaNumeric()
	{
		String genratedString=RandomStringUtils.randomAlphabetic(3);
		String genratedNumber=RandomStringUtils.randomNumeric(10);
		return (genratedString+"@"+genratedNumber);
	}
}
