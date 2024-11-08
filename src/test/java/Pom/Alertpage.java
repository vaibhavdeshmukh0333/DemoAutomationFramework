/**
 * Alert page class to object repository 
 * 
 */

package Pom;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;
import UtilityClass.Waits;
import bsh.This;

public class Alertpage 
{
	
	WebDriver driver;// create driver instance to initialze driver
	
	//create parameter constructor
	public Alertpage(WebDriver driver) {
		this.driver=driver;
	}
	
	//finds webelement
	@FindBy(xpath="//div[@id='OKTab']/button")
	private WebElement simpleAlert;
	
	@FindBy(id="OKTab")
	private WebElement genrateSimpleAlert;
	
	@FindBy(xpath="//a[text()='Alert with OK & Cancel ']")
	private WebElement okCancelBtn;
	
	@FindBy(xpath="//button[text()='click the button to display a confirm box ']")
	private WebElement confirmationAlert;
	
	@FindBy(xpath="//a[text()='Alert with Textbox ']")
	private WebElement alertTextBox;
	
	@FindBy(xpath="//button[text()='click the button to demonstrate the prompt box ']")
	private WebElement promptAlert;
	
	
	//create method of intialize webelement
	public void simpleAlert() throws InterruptedException, Customexception
	{
		//Waits.applyVisibilityOf(driver,simpleAlert,10);
		try
		{
			if(ActionsMethod.isDisplay(simpleAlert) 
			&& ActionsMethod.isEnable(simpleAlert))
			{
				if(ActionsMethod.isDisplay(genrateSimpleAlert) 
				&& ActionsMethod.isEnable(genrateSimpleAlert))
				{
					Loggerclass.log.info("Verify Element Display and enable");
					ActionsMethod.Click(genrateSimpleAlert);
					Loggerclass.log.info("Click on Alert Genrate btn");
					ActionsMethod.alert(driver);
					Loggerclass.log.info("Handle Simple Alert Sucessfully");
							
				}
				else
				{
					Loggerclass.log.error("simple alert button is not present or enabled..");
					System.out.println("simple alert button is not present or enabled..");
				}
				
			}
			else
			{
				Loggerclass.log.error("OK button is not present or enabled..");
				System.out.println("OK button is not present or enabled..");
			}
			
		}
		catch (NoSuchElementException e) {
			Loggerclass.log.error("Element is not found Please check loctor");
			throw new Customexception("Element is not found"+e.getMessage());
		}
		catch (UnhandledAlertException e) {
			Loggerclass.log.error("Unable to handle alert:");
			throw new Customexception("Unable to handle alert: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.log.error("An unexpected error occurred:");
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	
	
	public void ConfirmationAlert() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(okCancelBtn)
			&&ActionsMethod.isEnable(okCancelBtn))
			{
				Loggerclass.log.info("Verify okCancelBtn Element Display and enable");
				ActionsMethod.Click(okCancelBtn);
				
				if(ActionsMethod.isDisplay(confirmationAlert)
				&&ActionsMethod.isEnable(confirmationAlert))
				{
					Loggerclass.log.info("Verify confirmationAlert Element Display and enable");
					ActionsMethod.Click(confirmationAlert);
					Loggerclass.log.info("Click on Alert Confirmation btn");
					ActionsMethod.DismissAlert(driver);
					Loggerclass.log.info("handle Confirmation Alert Sucessfully");
				}
				else
				{
					Loggerclass.log.error("Confirmation alert button is not present or enabled..");
					System.out.println("Confirmation alert button is not present or enabled..");
				}
			}
			else
			{
				Loggerclass.log.error("OK Cancel button is not present or enabled..");
				System.out.println("OK Cancel button is not present or enabled..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.log.error("Element is not found Please check loctor");
			throw new Customexception("Element not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.log.error("An unexpected error occurred");
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void acceptConfirmationAlert() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(okCancelBtn)
			&&ActionsMethod.isEnable(okCancelBtn))
			{
				Loggerclass.log.info("Verify okCancelBtn Element Display and enable");
				ActionsMethod.Click(okCancelBtn);
				
				if(ActionsMethod.isDisplay(confirmationAlert)
				&&ActionsMethod.isEnable(confirmationAlert))
				{
					Loggerclass.log.info("Verify confirmationAlert Element Display and enable");
					ActionsMethod.Click(confirmationAlert);
					Loggerclass.log.info("Click on Alert Confirmation btn");
					ActionsMethod.alert(driver);
					Loggerclass.log.info("handle accept ConfirmationAlert Alert Sucessfully");
				}
				else
				{
					Loggerclass.log.error("Confirmation alert button is not present or enabled..");
					System.out.println("Confirmation alert button is not present or enabled..");
				}
			}
			else
			{
				Loggerclass.log.error("OK Cancel button is not present or enabled..");
				System.out.println("OK Cancel button is not present or enabled..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.log.error("Element is not found Please check loctor");
			throw new Customexception("Element not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.log.error("An unexpected error occurred");
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void PromptAlert() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(alertTextBox)
				&& ActionsMethod.isEnable(alertTextBox))
			{
				ActionsMethod.Click(alertTextBox);
				Loggerclass.log.info("Verify alertTextBox Element Display and enable");
				if(ActionsMethod.isDisplay(promptAlert)
					&&ActionsMethod.isEnable(promptAlert))
				{
					Loggerclass.log.info("Verify promptAlert Element Display and enable");
					ActionsMethod.Click(promptAlert);
					Loggerclass.log.info("Click on Alert promptAlert btn");
					Alert a=driver.switchTo().alert();
					System.out.println(a.getText());
					a.sendKeys("Vaibhav");
					a.accept();
					Loggerclass.log.info("Handle prompt Alert sucessfully");
				}
				else
				{
					Loggerclass.log.info("Prompt alert button is not present or enabled");
					System.out.println("Prompt alert button is not present or enabled");
				}
			}
			else
			{
				Loggerclass.log.info("Alert with Text Box button is not present or enabled.");
				System.out.println("Alert with Text Box button is not present or enabled.");
			}
		}
		catch (Exception e) {
			Loggerclass.log.info("An unexpected error occurred");
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
}
