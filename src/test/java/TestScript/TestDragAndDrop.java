/**
 * Test sattic and dynamic dropDown
 */

package TestScript;

import java.time.Duration;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pom.DragdropPage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;


public class TestDragAndDrop extends Baseclass
{
	
	DragdropPage dd;		//create variable of DragdropPage class	
	
	/**
	 * open static DragAndDown page
	 * @throws Customexception
	 */
	@Test(priority=0,groups= {"smoke","regression"})
	void navigateStaticDragAndDropPage() throws Customexception
	{
		
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver,p.getProperty("staticdropdown"));
				Loggerclass.log.info("Launched static dropdown Page");
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
	
	/**
	 * Verify page
	 */
	@Test(priority=1,groups= {"smoke","regression"})
	void verfiyStaticPage()
	{
			Loggerclass.log.info("start verfiy static page");
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(driver.getCurrentUrl(),p.getProperty("staticdropdown"));
			sa.assertEquals(driver.getTitle(),p.getProperty("staticdrodownTitle"));
			Loggerclass.log.info("verfiy static drag and drop Page");
			ActionsMethod.Scrollby(driver, 300,300);
		
	}
	
	/**
	 * If page varified than perform opreation 
	 * @throws Customexception
	 */
	@Test(priority=2,dependsOnMethods="verfiyStaticPage",groups= {"regression"})
	void performStaticDragAndDrop() throws Customexception
	{
		Loggerclass.log.info("start static page method");
		dd=PageFactory.initElements(driver,DragdropPage.class);
		dd.performStaticOpreation();
		Loggerclass.log.info("start End page method");
		
		
	}
	
	/**
	 * open dynamic	 dragAndDown Page by creating new window
	 * @throws Customexception
	 */
	@Test(priority=3,groups= {"smoke","regression"})
	void navigateDynamicDragAndDropPage() throws Customexception
	{
		driver.switchTo().newWindow(WindowType.WINDOW);//create new window to perform opreation on dynamic
		
		try
		{
			
			if(driver!=null)
			{
				ActionsMethod.Get(driver,"https://demo.automationtesting.in/Dynamic.html");
				Loggerclass.log.info("Launched Dynamic dropdown Page");
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
	
	/**
	 * verify dynamic page
	 */
	@Test(priority=4)
	void verfiydynamicPage()
	{
			Loggerclass.log.info("start verfiy Dynamic page");
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(driver.getCurrentUrl(),p.getProperty("staticdropdown"));
			sa.assertEquals(driver.getTitle(),p.getProperty("staticdrodownTitle"));
			Loggerclass.log.info("verfiy Dynamic drag and drop Page");
			ActionsMethod.Scrollby(driver, 300,300);
		
	}
	
	/**
	 * if dynamic verified then perform opreation
	 * @throws Customexception
	 */
	@Test(priority=5,dependsOnMethods="verfiydynamicPage")
	void performDynamicDragAndDrop() throws Customexception
	{
		Loggerclass.log.info("start dynamic page method");
		
		dd=PageFactory.initElements(driver,DragdropPage.class);
		dd.performDynamicOpreation();
		Loggerclass.log.info("start End page method");
		
	}
	
	
	@Override
	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
