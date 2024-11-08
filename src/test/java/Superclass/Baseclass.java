package Superclass;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import UtilityClass.Customexception;
import UtilityClass.Extentreport;
import UtilityClass.ListenerClass;
import UtilityClass.Loggerclass;
import UtilityClass.ReadWriteFile;
import UtilityClass.Waits;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;


@Listeners(ListenerClass.class)
public class Baseclass 
{

	/**
	 * Declered variable for access every one becoz it is common
	 */
	public static WebDriver driver;
	public static Properties p;
	public static DesiredCapabilities d;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentHtmlReporter HtmlReport;
	public static ExtentSparkReporter spartreport;
	
	
	/**
	 * Read And Write Property file and method execute at time of project execution
	 */
	@BeforeSuite(groups= {"smoke","regression"})
	public static void ReadPropertyFile()
	{
		
		FileInputStream fis=ReadWriteFile.ReadFile("src\\test\\resources\\PropertyFile\\Property.properties");
		//PropertyConfigurator.configure("src\\test\\resources\\PropertyFile\\log.properties");
		try
		{	
			
			DOMConfigurator.configure("log4j2.xml");
			Loggerclass.StartTest("Testing");
			p=new Properties();
			p.load(fis);
			Loggerclass.log.info("Read Property File");
			
			
		}
		catch (IOException e) 
		{
			Loggerclass.log.error("Problem Occured to read property file");
			e.printStackTrace();
			throw new RuntimeException("IOExceptions ", e);
		}
		finally
		{
			if(fis!=null)
			{
				try
				{
					fis.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * method for get browser name for lunching if use testng.xml file for launch browser then override value
	 * to property file variable otherwise launch browser by using property file
	 * @param browserNameXml
	 * @throws Customexception 
	 * @optional annotation Specifies that the current parameter is optional. 
	 * TestNG will pass in a specified default value, or null if none is specified.
	 */
	
	@Parameters("browser")
	@BeforeClass(groups= {"smoke","regression"})
	public static void setUp(@Optional String browserNameTestNgXml) throws Customexception
	{
		String browserName=p.getProperty("browser");//get browser name by using property file method
		//System.out.println("browser name: "+browserName);
		if(browserNameTestNgXml !=null && !browserNameTestNgXml.isEmpty()) //check browser name came by using testng.xml file then override value.
		{
			browserName=browserNameTestNgXml; //overrride value on browsername
			//System.out.println("Overright browser: "+browserName);
		}
		//Loggerclass.log.info("Setting up the test with browser");
		launchBrowser(browserName);// call launchbrowser method and pass parameter to launch browser
	}
	
	/**
	 * Launch browser code and configure browser setting
	 * @throws Customexception 
	 */

	public static WebDriver launchBrowser(String browserName) throws Customexception
	{
		//System.out.println(browserName);
		try
		{
			if(browserName.contains("chrome"))
			{
				/*
				 * Using Desiredcapabilites set browser name version and platform
				 */
				d=new DesiredCapabilities();
				d.setBrowserName("Chrome");
				//d.setVersion("120.0.6099.217");
				d.setPlatform(Platform.WINDOWS);
				d.setCapability("unexpectedAlertBehaviour", "ignore");
				/**
				 * Using Chromeoptions class set browser settings such as browser open private mode(incognito mode) and loading strategy
				 *  after desiredcapabilties merge chromeoptions
				 */
				ChromeOptions option=new ChromeOptions();	//create object of chromeoptions class
				//option.addArguments("--incognito");			// open browser incognito mode
				option.addArguments("--start-maximized");	//maximized browser
				//option.addArguments("--window-size=1200,800");	//configure window size
				option.setAcceptInsecureCerts(true);// handle ssl certificates
				/**
				 * disable browser cookies 
				 */
				/*option.addArguments("--disable-extensions");
				option.addArguments("--disable-save-password");
				option.addArguments("--disable-extensions-file-access-check");
				option.addArguments("--disable-extensions-http-throttling");
				option.addArguments("--disable-extensions-domain");
				option.addArguments("--disable-extensions-web-access-control");
				option.addArguments("--disable-sync");*/
				
				
				option.setPageLoadStrategy(PageLoadStrategy.NORMAL);	//set pageloadstrategy
				option.merge(d);	//merge desiredcapabilties with chromeoptions and pass to chrome driver
				
				driver=new ChromeDriver(option); //launch browser and pass chrome options object to chromedriver for pass setting of driver
				
				driver.manage().deleteAllCookies();// delete all cookies
				//driver.manage().window().maximize();	//code maximize window
				
				//apply implicit wait on driver by using two way
				Waits.applyImplicitlyWait(driver, "sec", 10);
				
				driver.navigate().refresh();
				Loggerclass.log.info("Launch Chrome browser");
			}
			else if(browserName.contains("firefox"))
			{
				/**
				 * confgure browser version name and platform by using desiredcapablities
				 */
				d=new DesiredCapabilities();
				d.setBrowserName("FireFox");
				d.setVersion("latest");
				d.setPlatform(Platform.WIN11);
				
				/**
				 * configure browser setting by using firefoxoptions class method
				 */
				FirefoxOptions option=new FirefoxOptions();
				option.addArguments("--private");
				option.addArguments("--start-maximized");
				option.setPageLoadStrategy(PageLoadStrategy.NORMAL);
				
				option.merge(d);	//merge desiredcapbitlies with firefoxoptions
				driver=new FirefoxDriver(option);	//launch browser
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				Waits.applyImplicitlyWait(driver, "sec", 10);
				driver.navigate().refresh(); //refersh page
				Loggerclass.log.info("Launch Firefox browser");
			}
			
			else if(browserName.contains("edge"))
			{
				/**
				 * Configure Edge browser name, platform and version by using desiredcapabilites
				 */ 
				d=new DesiredCapabilities();
				d.setBrowserName("Edge Browser");
				d.setVersion("latest");
				d.setPlatform(Platform.WIN11);
				
				/**
				 * configure browser setting by using EdgeOptions class
				 */
				
				EdgeOptions option=new EdgeOptions();
				option.addArguments("--InPrivate");
				option.addArguments("--start-maximized");
				//option.addArguments("--window-size=1200,800");
				//option.addArguments("download.default.directory"+path);
				/**
				 * Configure disable cookies
				 */
				/*option.addArguments("--disable-extensions");
				option.addArguments("--disable-save-password");
				option.addArguments("--disable-extensions");
				option.addArguments("--disable-extensions-file-access-check");
				option.addArguments("--disable-extensions-http-throttling");
				option.addArguments("--disable-extensions-domain");
				option.addArguments("--disable-extension-web-access-control");
				option.addArguments("--disable-sync");*/
				
				option.merge(d); //merge desiredcapbilities and edgeoptions
				
				driver=new EdgeDriver(option);
				Waits.applyImplicitlyWait(driver, "sec", 10);
				Loggerclass.log.info("Launch Edge browser");
			}
			else
			{
				 Loggerclass.log.error("Unsupported browser");
				throw new Customexception("Unsupported browser: " + browserName);
			}
		}
		catch (WebDriverException e) {
			Loggerclass.error("Internet Disconnected check internet connection");
			throw new Customexception("Internet Disconnected check internet connection: "+e.getMessage());
		}
		catch(Exception e)
		{
			Loggerclass.log.error("Unable to support browser");
			throw new Customexception("Error occurred while launching the browser: "+e.getMessage());
		}
		
		
		return driver;
	}
	
	
	/**
	 * method for verify browser if correct
	 */
	//@Test(groups={"smoke", "regression"})
	private void VerifyBrowser()
	{
		//type case driver to remotewebdriver and using methods of remotewebdriver to get browser name
		String ActulBrowser =((RemoteWebDriver)driver).getCapabilities().getBrowserName();
		String ExpectedBrowser=((RemoteWebDriver)driver).getCapabilities().getBrowserName();
		Assert.assertEquals(ActulBrowser, ExpectedBrowser);
		Loggerclass.info("Verify browser");
	}
	
	/**
	 * close tab method
	 */
	public void CloseTab()
	{
		Loggerclass.EndTest("current tab");
		driver.close();
	}
	
	
	/**
	 * quit browser method
	 */
	public void teardown()
	{
		Loggerclass.EndTest("Testing");
		driver.quit();
	}
}
