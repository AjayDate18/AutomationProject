package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBaseClass.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String expresult)
	{
		logger.info("Starting TC003_LoginDDT");
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		//My Account
		MyAccountPage myacc=new MyAccountPage(driver);
		boolean targetPage=myacc.isMyAccountExists();
		
		if(expresult.equalsIgnoreCase("Valid"))
		{
			if(targetPage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}	
		}	
		else
		{
			if(targetPage==true)
			{
				myacc.clickLogout();
				Assert.assertTrue(false);
			}	
			else
			{
				Assert.assertTrue(false);
			}	
			
		}
		logger.info("Finish TC003_LoginDDT");
		
		
		
	}
	
}
