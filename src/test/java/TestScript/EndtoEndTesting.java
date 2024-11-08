package TestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pom.Alertpage;
import Pom.Homepage;
import Pom.Registerpage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;

public class EndtoEndTesting extends Baseclass
{
	
	TestHome h;
	Registerpage p;
	TestRegister r;
	TestFrame f;
	TestWindowHandle w;
	
	@BeforeClass
	void openApplication() throws Customexception
	{
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver,Baseclass.p.getProperty("HomePageUrl"));
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
	
	
	@Test(priority=0,groups= {"smoke"})
	public void EndtoEndtesting() throws Customexception, InterruptedException
	{
		 h=new TestHome();
		 h.navigateHomePage();
		 h.skipSing();
		 
		 r=new TestRegister();
		 r.verifyRegisterPageByUsingValidData();
		 
		 p=PageFactory.initElements(driver, Registerpage.class);
		 p.navigateSwitchTo();
		 p.navigateAlert();
		 TestAlert a=new TestAlert();
		 a.verifyAccpectConfirmationAlert();
		 
		 p.navigateSwitchTo();
		 p.navigateFrame();
		 f=new TestFrame();
		 f.performSingleFrameHandling();
		 
		 p.navigateSwitchTo();
		 p.navigateWindow();
		 w=new TestWindowHandle();
		 w.verifySingelwindowHandle();
		 
	}
	
	@AfterClass
	public void tearDown()
	{
		CloseTab();
	}
}
