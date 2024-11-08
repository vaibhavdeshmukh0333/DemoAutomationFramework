package UtilityClass;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsMethod
{
	WebDriver driver;
	public ActionsMethod(WebDriver driver) {
		this.driver=driver;
	}
	static Actions a;
	static JavascriptExecutor js;
	static Select s;
	
	/**
	 * WebElement Methods
	 * 
	 */
	/**
	 * Overload method of click
	 * @param Element
	 */
	public static void Click(WebElement Element)
	{
		Element.click();
	}
	public static void Click(WebDriver driver,WebElement Element)
	{
		a=new Actions(driver);
		a.click(Element).build().perform();
	}
	
	public static boolean isDisplay(WebElement element)
	{
		return element.isDisplayed();
	}
	
	public static boolean isEnable(WebElement element)
	{
		return element.isEnabled();
	}
	
	public static void sendKeys(WebElement element,String input)
	{
		element.sendKeys(input);
	}
	
	public static boolean isSelect(WebElement element)
	{
		return element.isSelected();
	}
	/**
	 * Driver methods
	 * @param driver
	 * @param Element
	 */
	public static void Get(WebDriver driver, String Url)
	{
		driver.get(Url);
	}
	
	public static void NavigateTo(WebDriver driver, String Url)
	{
		driver.navigate().to(Url);
	}
	public static void Navigate(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
	/**
	 * JavaScript methods
	 * @param driver
	 * @param Element
	 */
	public static void JavaScriptClick(WebDriver driver,WebElement Element)
	{
		js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",Element);
	}
	
	public static void ScrollBy(WebDriver driver, WebElement Element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", Element);
	}
	public static void Scrollby(WebDriver driver,int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	/**
	 * Select class methods
	 * @param index
	 * @param element
	 */
	public static void SelectClass(int index, WebElement element)
	{
		s=new Select(element);
		if(!s.isMultiple())
		{
			s.selectByIndex(index);
		}
	}
	public static void SelectClass(String VisibelText, WebElement element)
	{
		s=new Select(element);
		if(!s.isMultiple())
		{
			s.selectByVisibleText(VisibelText);
		}
	}
	public static void SelectClass(WebElement element,String value)
	{
		s=new Select(element);
		if(!s.isMultiple())
		{
			s.selectByValue(value);
			
		}
	}
	public static List<WebElement> SelectClass(WebElement element)
	{
		s=new Select(element);
		return s.getOptions();
	}
	/**
	 * Alert methods
	 * @param driver
	 */
	public static void alert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public static void DismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	public static void alert(WebDriver driver,String input)
	{
		driver.switchTo().alert().sendKeys(input);
	}
	public static String GetTextalert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	
	/**
	 * DrapAndDrop Method
	 */
	public static void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement descElement)
	{
		a=new Actions(driver);
		a.dragAndDrop(srcElement,descElement).build().perform();
	}
	
}
