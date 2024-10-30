package utilities;


import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBaseClass.BaseClass;

public class ExtentReportManager implements ITestListener
{

	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;

	public void onStart(ITestContext context) 
	{
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report "+timeStamp+".html";
		sparkreporter=new ExtentSparkReporter(".\\reports\\"+repName);
		sparkreporter.config().setDocumentTitle("OpenCartAutomation Report");
		sparkreporter.config().setReportName("OpenCart Functional Testing");
		sparkreporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Application", "OpenCart");
		extent.setSystemInfo("Module","Admin");
		extent.setSystemInfo("SubModule", "Customers");
		extent.setSystemInfo("UserName", System.getProperty("user.name"));
		extent.setSystemInfo("Environment","QA");
	
		String os=context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System",os);
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
		
		List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
		if(!includedGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includedGroups.toString());
		}
		
		
		
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS,result.getName()+"Got Successfully Executed");	
    }
	
	public void onTestFailure(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"Got Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try 
		{
			
			String imgpath= new BaseClass().CaptureScreenShot(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public void onTestSkipped(ITestResult result) 
	{
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"Got Skipped");	
		test.log(Status.INFO,result.getThrowable().getMessage());
	}
   

  public void onFinish(ITestContext context) 
  {
        extent.flush();
		
		//Open Report Automatically
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName;
		File extentReport=new File(pathOfExtentReport);
		try 
		{
			Desktop.getDesktop().browse(extentReport.toURI());
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//Automatic Sent A Email
	}
	
}
