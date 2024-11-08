package UtilityClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreport {

	//create instant variables for hold extent report 
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	/**
	 * generat report method 
	 */
	public static void Reports()
	{
		report=new ExtentReports(); //create instanse of extentreport class object 
		
		//create object Extentspark report and pass location where to stored file 
		spark=new ExtentSparkReporter("src\\test\\resources\\reports\\report.html");
		
		//configure report 
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		spark.config().setDocumentTitle("Simple Automation Script Report");
		spark.config().setReportName("Test Report");
		spark.config().setEncoding("UTF-8");
		spark.config().setTheme(Theme.STANDARD);
		report.attachReporter(spark);
	}
	
	public static void flush()
	{
		report.flush();	//flush report
	}
}
