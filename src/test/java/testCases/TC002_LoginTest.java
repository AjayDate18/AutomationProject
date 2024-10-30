package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBaseClass.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	
		@Test(groups={"Sanity","Master"})
		public void verify_Login()
		{
			try
			{
			logger.info("Starting TC002_Login Test");
			HomePage hp= new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			LoginPage lp= new LoginPage(driver);
			lp.setEmail("ajaymore21@gmail.com");
			lp.setPassword("Ajay@21");
			lp.clickLogin();
			
			//My Account
			MyAccountPage myacc=new MyAccountPage(driver);
			boolean targetPage=myacc.isMyAccountExists();
			
			Assert.assertEquals(targetPage,true);
			logger.info("Finished TC_002_Login Test...");
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
				Assert.fail();
			}
			
		}
}
