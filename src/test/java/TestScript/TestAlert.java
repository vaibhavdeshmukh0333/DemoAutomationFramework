package TestScript;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.Alertpage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.ListenerClass;
import UtilityClass.Loggerclass;
import UtilityClass.Waits;


@Listeners(ListenerClass.class)
public class TestAlert extends Baseclass {

	Alertpage a;
	//WebDriver driver;
	
	/*public TestAlert(WebDriver driver) {
		this.driver=driver;
	}*/
	
	
	@BeforeClass(groups= {"smoke","regression"})
	public void navigateAlertPage() throws Customexception
	{
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver, p.getProperty("AlertPage"));
				Loggerclass.info("Launch Alert Page");
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
	@Test(groups= {"smoke","regression"})
	public void verfiyAlert()
	{
		Loggerclass.StartTest("Verify Alert Page");
		Assert.assertEquals(driver.getTitle(),"Alerts");
		Loggerclass.EndTest("Verify Alert Page");
	}
	@Test(groups= {"regression"})
	public void verifySimpleAlert() throws InterruptedException, Customexception
	{
		Loggerclass.StartTest("Simple Alert Method");
		a=PageFactory.initElements(driver, Alertpage.class);
		a.simpleAlert();
		Loggerclass.EndTest("Simple Alert Method ");
	}
	
	
	@Test(groups= {"smoke","regression"})
	private void verifyCancelConfirmationAlert() throws InterruptedException, Customexception
	{
		Loggerclass.StartTest("verify Cancel Confirmation Alert Method");
		a=PageFactory.initElements(driver, Alertpage.class);
		a.ConfirmationAlert();
		Loggerclass.EndTest("verify Cancel Confirmation Alert Method ");
	}
	
	
	@Test(groups= {"regression"})
	public void verifyPromptAlert() throws Customexception, InterruptedException
	{
		Loggerclass.StartTest("Prompt Alert Method");
		a=PageFactory.initElements(driver,Alertpage.class);
		a.PromptAlert();
		Loggerclass.EndTest("Prompt Alert Method ");
	}
	
	@Test(groups= {"regression"})
	public void verifyAccpectConfirmationAlert() throws Customexception
	{
		Loggerclass.StartTest("Accept Confirmation Alert Method");
		a=PageFactory.initElements(driver, Alertpage.class);
		a.acceptConfirmationAlert();
		Loggerclass.EndTest("Accept Confirmation Alert Method");
	}
	
	/**
	 * quit page after class
	 */
	@AfterClass(groups= {"smoke","regression"})
	private void tearDown()
	{
		CloseTab();
	}
}
