package TestScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pom.Registerpage;
import Superclass.Baseclass;

public class Demo extends Baseclass
{
	@BeforeClass
	public void url()
	{
		driver.get("https://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void testScript()
	{
		Registerpage r=PageFactory.initElements(driver, Registerpage.class);
		r.navigateSwitchTo();
		r.navigateAlert();
		
	}
}
