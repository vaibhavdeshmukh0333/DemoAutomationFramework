/**
 * Contains Windows Handel repository
 */

/**
 * 
 */
/**
 * 
 */



/**
 * 
 */
package Pom;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;

public class WindowPage 
{
	WebDriver driver;
	
	public WindowPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	@FindBy(xpath="//a[text()='Open New Tabbed Windows ']")
	private WebElement OpenNewTabbedBtn;
	
	@FindBy(xpath="//button[contains(text(),' click')]")
	private WebElement clickOnNewWindow;
	
	@FindBy(xpath="//a[text()='Open New Seperate Windows']")
	private WebElement OpenNewSeperateWindowBtn;
	
	@FindBy(xpath="//a[text()='Open Seperate Multiple Windows']")
	private WebElement openSeperateMultipleWindowsBtn;
	
	@FindBy(xpath="//button[contains(@onclick,'newwindow')]")
	private WebElement clickOnSeprateWindow;
	
	@FindBy(xpath="//button[contains(@onclick,'multiwindow')]")
	private WebElement multipleWindowClickBtn;
	
	/**
	 * Click Open New Tabbed Windows option
	 * @throws Customexception
	 */
	
	public void openNewTab() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(OpenNewTabbedBtn)
			&&ActionsMethod.isEnable(OpenNewTabbedBtn))
			{
				ActionsMethod.Click(OpenNewTabbedBtn);
				Loggerclass.info("Click on Open New Tab Btn");
			}
			else
			{
				Loggerclass.error("New Tab Btn is not present or enable");
				System.out.println("New Tab Btn is not present or enable");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	
	/**
	 * Click on click btn method
	 * @throws Customexception 
	 */
	public void clickBtn() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(clickOnNewWindow)
					&&ActionsMethod.isEnable(clickOnNewWindow))
					{
						ActionsMethod.Click(clickOnNewWindow);
						Loggerclass.info("Click on New window");
					}
					else
					{
						Loggerclass.error("Click btn is not present or enable");
						System.out.println("Click btn is not present or enable");
					}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void clickOpenNewSeperateWindowBtn() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(OpenNewSeperateWindowBtn)
			&&ActionsMethod.isEnable(OpenNewSeperateWindowBtn))
			{
				ActionsMethod.Click(OpenNewSeperateWindowBtn);
				Loggerclass.info("Click on New Seperate Window Btn");
			}
			else
			{
				Loggerclass.error("New Seperate Window Btn is not present or enable");
				System.out.println("New Seperate Window Btn is not present or enable");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	public void openSeperateMultipleWindowsBtn() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(openSeperateMultipleWindowsBtn)
			&&ActionsMethod.isEnable(openSeperateMultipleWindowsBtn))
			{
				ActionsMethod.Click(openSeperateMultipleWindowsBtn);
				Loggerclass.info("Click on open Seperate Multiple Windows Btn");
			}
			else
			{
				Loggerclass.error("open Seperate Multiple Windows Btn is not present or enable");
				System.out.println("open Seperate Multiple Windows Btn is not present or enable");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	/**
	 * Sprate Window Click btn method
	 */
	public void clickOnSpreateWindowClickBtn() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(clickOnSeprateWindow)
					&&ActionsMethod.isEnable(clickOnSeprateWindow))
					{
						ActionsMethod.Click(clickOnSeprateWindow);
						Loggerclass.info("Click on Sprate window Click btn");
					}
					else
					{
						Loggerclass.error("Sprate Window Click btn is not present or enable");
						System.out.println("Sprate Window Click btn is not present or enable");
					}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	/**
	 * Multiple Window Click btn method
	 */
	public void clickOnMultipleWindowClickBtn() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(multipleWindowClickBtn)
					&&ActionsMethod.isEnable(multipleWindowClickBtn))
					{
						ActionsMethod.Click(multipleWindowClickBtn);
						Loggerclass.info("Click on Multiple window Click btn");
					}
					else
					{
						Loggerclass.error("Multiple Window Click btn is not present or enable");
						System.out.println("Multiple Window Click btn is not present or enable");
					}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("Element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
}
