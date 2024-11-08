package TestScript;


import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v113.dom.model.BackendNode;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.WindowPage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.ListenerClass;
import UtilityClass.Loggerclass;
import UtilityClass.WindowHandeling;

@Listeners(ListenerClass.class)
public class TestWindowHandle extends Baseclass
{

	WindowPage w;//create variable of windowpage
	
	/**
	 * Navigate Window page method
	 * @throws Customexception
	 */
	@BeforeClass(groups= {"smoke","regression"})
	void navigateTOWindowPage() throws Customexception
	{
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver,"https://demo.automationtesting.in/Windows.html");
				Loggerclass.info("Launch Window Page");
			}
			
		}
		catch (WebDriverException e) {
			Loggerclass.error("Internet Connection OFF Please check Internet Connection");
			throw new Customexception("Internet Connection OFF Please check Internet Connection: "+e.getMessage());
		}
		catch (NullPointerException e) {
			Loggerclass.error("WebDriver is NULL");
			throw new Customexception("WebDriver is NULL: "+e.getMessage());
		}
		catch(Exception e)
		{
			Loggerclass.error("URL Issue");
			throw new Customexception("URL Issure: "+e.getMessage());
		}
	}
	
	@Test(alwaysRun=true,groups= {"smoke","regression"})
	public void verifyWindowPage()
	{	
		Loggerclass.StartTest("Verify Window page ");
		Assert.assertEquals(driver.getTitle(), "Frames & windows");
		Loggerclass.EndTest("Verify Window Page");
	}
	
	/**
	 * single window handling
	 * @throws InterruptedException
	 * @throws Customexception
	 */
	@Test(groups= {"smoke",})
	void verifySingelwindowHandle() throws InterruptedException, Customexception
	{
		Loggerclass.StartTest("singelwindowHandle method");
		w=PageFactory.initElements(driver, WindowPage.class);
		w.openNewTab();
		w.clickBtn();
		//Loggerclass.info("Click on window btn");
		
		//handle window by using window handel code that is retured Utility package
		boolean status=WindowHandeling.handleWindow(driver, "https://www.selenium.dev/", "Selenium");
		
		if(status==true)// verify page
		{
			driver.findElement(By.xpath("//span[text()='Documentation']")).click();//perform opreation inside page
		}
		WindowHandeling.switchTOParentWindow(driver);//navigate parent page
		Loggerclass.EndTest("singelwindowHandle method");
	}
	
	/**
	 * Verify Seprate window handle 
	 * @throws Customexception 
	 */
	 @Test(groups= {"regression"})
	void verifySeprateWindowHandle() throws Customexception
	{
		Loggerclass.StartTest("SeprateWindowHandle method");
		w=PageFactory.initElements(driver,WindowPage.class);
		w.clickOpenNewSeperateWindowBtn();
		w.clickOnSpreateWindowClickBtn();
		//Loggerclass.info("create seprate window");
		
		//handle window by using window handel code that is retured Utility package
		boolean status=WindowHandeling.handleWindow(driver, "https://www.selenium.dev/", "Selenium");
				
		if(status==true)// verify page
		{
			driver.findElement(By.xpath("//span[text()='Documentation']")).click();//perform opreation inside page
		}
		WindowHandeling.switchTOParentWindow(driver);//navigate parent page
		Loggerclass.EndTest("SeprateWindowHandle method");
		
	}
	
	 
	 /**
	  * Verify Multiple Window Handleing
	 * @throws Customexception 
	  */
	 
	 @Test(priority=3,groups= {"regression"})
	 void verifyMultipleWindowHandling() throws Customexception
	 {
		 Loggerclass.StartTest("MultipleWindowHandling Method");
		 w=PageFactory.initElements(driver,WindowPage.class);
		 w.openSeperateMultipleWindowsBtn();
		 w.clickOnMultipleWindowClickBtn();
		 
		//handle window by using window handel code that is retured Utility package
		boolean status=WindowHandeling.handleWindow(driver, "https://www.selenium.dev/", "Selenium");
				
		if(status==true)// verify page
		{
			driver.findElement(By.xpath("//span[text()='Documentation']")).click();//perform opreation inside page
		}
		WindowHandeling.switchTOParentWindow(driver);//navigate parent page
		Loggerclass.EndTest("MultipleWindowHandling method");
	 }
	 
	 @AfterClass(groups= {"smoke","regression"})
	 public void tearDown()
	 {
		 teardown();
	 }
}
