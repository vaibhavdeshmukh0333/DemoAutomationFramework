package TestScript;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Superclass.Baseclass;
import UtilityClass.ActionsMethod;

public class TestBrokenLink extends Baseclass 
{
	
	@BeforeClass
	void OpenPage()
	{
		ActionsMethod.Get(driver,"https://demo.automationtesting.in/Register.html");
	}
	
	@Test
	void VerifyLink()
	{
		List<WebElement> AllLink=driver.findElements(By.tagName("a"));
		
		for(WebElement Link:AllLink)
		{
			String url=Link.getAttribute("href");
			System.out.println(url);
			if(url==null||url.isEmpty())
			{
				System.out.println("Url is Empty");
				continue;
			}
			try
			{
				URL Url=new URL(url);
				HttpURLConnection connection=(HttpURLConnection) Url.openConnection();
				connection.setConnectTimeout(3000);
				connection.connect();
				
				if(connection.getResponseCode()>=400)
				{
					System.out.println("Url is broken: "+connection.getResponseCode());
				}
				else
				{
					System.out.println("Url is not Broken: "+connection.getResponseCode());
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
