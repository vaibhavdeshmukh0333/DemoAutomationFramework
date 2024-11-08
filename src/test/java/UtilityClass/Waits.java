package UtilityClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits 
{
	/**
	 * Apply implicitly wait by using second and miniute
	 * @param driver
	 * @param timeout
	 */
	public static void applyImplicitlyWait(WebDriver driver, String time, int timeOut)
	{
		if(time.contains("sec"))
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		}
		else if(time.contains("min"))
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(timeOut));
		}
	}
	
	static WebDriverWait wait;		//create varibale for explicitwait
	
	public static void applyVisibilityOf(WebDriver driver,WebElement element, int timeOut)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void applyvisibility(WebDriver driver, String locator, String locatorName,int timeOut)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(locator.contains("id"))
		{
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locatorName)));
		}
		else if(locator.contains("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorName)));
		}
		else if(locator.contains("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorName)));
		}
		else
		{
			System.out.println("Select loctor");
		}
	}
	
	public static void applyAlert(WebDriver driver,int timeOut)
	{
		wait=new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void frame(WebDriver driver,int timeout,WebElement element)
	{
		wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
}
