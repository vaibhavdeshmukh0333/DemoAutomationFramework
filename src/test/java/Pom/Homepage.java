package Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;

public class Homepage
{

	//create WebDriver variable
	WebDriver driver;
	
	//create parameterized consrtuctor
	public Homepage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//find WebElements
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement singIn;
	
	@FindBy(id="btn2")
	private WebElement skipSignIn;
	
	public void skipSignInbtn() throws Customexception
	{
		try 
		{
			if(skipSignIn.isDisplayed()
					&&
					skipSignIn.isEnabled())
			{
				ActionsMethod.Click(skipSignIn);
			}
			else
			{
				System.out.println("skip singIn btn is not display or enable");
			}
		}
		catch (Exception e) {
			Loggerclass.error("Unsupport element Exceptions");
			throw new Customexception("Unsupport element Exceptions: "+e.getMessage());
		}
	}
}
