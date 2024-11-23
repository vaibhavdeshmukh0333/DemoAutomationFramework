/**
 * This is a listener class which is used to handle events of the TestNG execution process and 
 * create an Extent report according to the test result, attaching screenshots along with the date and time.
 */

package UtilityClass;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.xmlbeans.impl.soap.Detail;
import org.openqa.selenium.devtools.v113.audits.model.DeprecationIssueDetails;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;

import Superclass.Baseclass;

public class ListenerClass implements ITestListener
{
	/**
	 * Create a variable of SimpleDateFormat to hold the current date and time,
	 * and a dateTime string to hold the current date and time returned by the SimpleDateFormat class.
	 */
	SimpleDateFormat simpleDateFormat;		//it varibale for create object of that class 
	String dateTime;
	
	
	public void onStart(ITestContext context) 
	{
		//System.out.println("Call Extent Report class");
		Loggerclass.info("Extent Report Initialization ");
		Extentreport.Reports();// Call the Reports class to initialize the Extent report.
	}
	
	
	public void onTestStart(ITestResult start) 
	{
		//System.out.println("Start method: "+start.getName());	//print meassage on console to start method name
	}
	
	/**
	 * Attached report,screenshot when test case is passed
	 */
	public void onTestSuccess(ITestResult pass) {
		
		String passTest=pass.getMethod().getMethodName();	//Hold pass method name
		
		//create object of SimpleDateFormat class to generate format.
		simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		dateTime=simpleDateFormat.format(new Date());//using format method create object of date class and it it returned string 
		
		try {
			//call screenshot utility class for captured screenshot
			String ScreenShot_dir=Screenshots.CaptureScreenShot(Baseclass.driver, "src\\test\\resources\\Pass\\"+passTest+"_"+dateTime);
			//create test report by using createTest method of extent report class and attched screen shot
			Extentreport.report.createTest(passTest).log(Status.PASS,"Test pass").addScreenCaptureFromPath(ScreenShot_dir);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Attached report,screenshot when test case is Skipped
	 */
	public void onTestSkipped(ITestResult skip) {
		
		
		String skipTest=skip.getMethod().getMethodName();//Hold skip method name
		//create object of SimpleDateFormat class to generate format.
		simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		//using format method create object of date class and it it returned string 
		dateTime=simpleDateFormat.format(new Date());
		
		
		try
		{
			//call screenshot utility class for captured screenshot and hold path captured screenshot
			String screenShotDir=Screenshots.CaptureScreenShot(Baseclass.driver,"src\\test\\resources\\skip\\"+skipTest+"_"+dateTime);
			//create test report by using createTest method of extent report class and attched screen shot
			Extentreport.report.createTest(skipTest).log(Status.SKIP,"Test Skip").addScreenCaptureFromPath(screenShotDir);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Attached report,screenshot when test case is Failed
	 */
	public void onTestFailure(ITestResult fail) {
	
		
		String failTest=fail.getMethod().getMethodName(); //Hold fail method name
		//create object of SimpleDateFormat class to generate format.
		simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd_HH-mm-ss");
		//using format method create object of date class and it it returned string 
		dateTime=simpleDateFormat.format(new Date());
		
		try {
			//call screenshot utility class for captured screenshot and hold path captured screenshot
			String screenShotDir=Screenshots.CaptureScreenShot(Baseclass.driver, "src\\test\\resources\\Fail\\"+failTest+"_"+dateTime);
			//create test report by using createTest method of extent report class and attched screen shot
			Extentreport.report.createTest(failTest).log(Status.FAIL, "Test Fail")
			.addScreenCaptureFromPath(screenShotDir);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onFinish(ITestContext context) 
	{
		//flush report
		Extentreport.flush();
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
}
