package UtilityClass;


import java.util.Set;

import org.openqa.selenium.WebDriver;

import Superclass.Baseclass;

public class WindowHandeling 
{
	static String parentId;
	static Set<String> allWindowIds;
	
	public static boolean handleWindow(WebDriver driver, String url, String title)
	{
		//get parent id
		parentId=driver.getWindowHandle();
		boolean flag=false;
		allWindowIds=driver.getWindowHandles();	//get all window ids 
		
		for(String id:allWindowIds)
		{
			if(!parentId.contains(id))
			{
				driver.switchTo().window(id);
				if(url.contains(driver.getCurrentUrl()) && title.contains(driver.getTitle()))
				{
					System.out.println(driver.getCurrentUrl());
					System.out.println(driver.getTitle());
					flag=true;
					break;
				}
				
			}
			
		}
		return flag;
	}
	
	public static void switchTOParentWindow(WebDriver driver)
	{
		driver.switchTo().window(parentId);
	}
}
