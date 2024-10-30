package testBaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	
	
	
	public static WebDriver driver;
	public Logger logger;
	//public Properties prop;
	
	@Parameters("browser")
	@BeforeClass(groups= {"Sanity","Regression","Master","DataDriven"})
	public void setUp(String br) throws IOException
	{
		
		//Loading Config.properties file
      // FileReader file=new FileReader(".//src//test//resources//config.properties"); 
	  //FileInputStream file=new FileInputStream(".//src//test//resources//config.properties");
     
		
		//To Load log4j2.xmal file in resources folder
	   logger=LogManager.getLogger(this.getClass());
	
		
	   
	   
	   
	   
	   
		
		if(br.toLowerCase().equals("chrome"))
		{
			driver=new ChromeDriver();
		}		
		else
		{
			System.out.println("Invalid Browser");
		}	
			
		
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://tutorialsninja.com/demo/"); //Refer Config.properties
		driver.manage().window().maximize();
		
		}
	
	@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	 public void tearDown()
	{
		driver.close();
	}
	
	public String CaptureScreenShot(String testName)
	{
		String timestamp=new SimpleDateFormat("yyyyMMddmmss").format(new Date());
		
		TakesScreenshot takescreenshor=(TakesScreenshot) driver;
		File source=takescreenshor.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+timestamp+".jpeg";
		File targetFile=new File(targetFilePath);
		source.renameTo(targetFile);
		
		return targetFilePath;
		
	}
	
}
