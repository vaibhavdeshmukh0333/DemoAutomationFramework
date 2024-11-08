/**
 * contais dropDown WebElement and there actions methods
 */

package Pom;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;
import UtilityClass.Waits;


public class DragdropPage 
{

	WebDriver driver;	//create driver varibale 
	public DragdropPage(WebDriver driver) {
		this.driver=driver; //initalize driver
	}
	
	
	//find WebElement and achive encapsulation
	@FindBy(id="angular")
	private WebElement firstImg;
	
	@FindBy(id="mongo")
	private WebElement secondImg;
	
	@FindBy(id="node")
	private WebElement thirdImg;
	
	@FindBy(id="droparea")
	private WebElement dropArea;
	
	/**
	 * provide static dropDown handel code
	 * @throws Customexception
	 */
	public void performStaticOpreation() throws Customexception
	{
		 
		try
		{
			//check element display, enable or not
			if(ActionsMethod.isDisplay(firstImg)&&ActionsMethod.isEnable(firstImg)
					||ActionsMethod.isDisplay(secondImg)&&ActionsMethod.isEnable(secondImg)
					||ActionsMethod.isDisplay(thirdImg)&&ActionsMethod.isEnable(thirdImg))
			{
				Waits.applyVisibilityOf(driver,firstImg,30);//apply wait 
				Loggerclass.log.info("Verify All Elements Display and enable");
				ActionsMethod.dragAndDrop(driver,firstImg,dropArea);	//call dragDrop methods which is define utility packages
				Loggerclass.log.info("perform firstImg dropDown");
				Waits.applyVisibilityOf(driver,secondImg,30);
				ActionsMethod.dragAndDrop(driver,secondImg,dropArea);
				Loggerclass.log.info("Perform secondImg dropDown");
				Waits.applyVisibilityOf(driver,thirdImg,30);
				ActionsMethod.dragAndDrop(driver,thirdImg,dropArea);
				Loggerclass.log.info("perform thirdImg dropDown");
			}
			else
			{
				Loggerclass.log.error("any dropDown element is not enable or display");
				System.out.println("any dropDown element is not enable or display");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.log.error("Element is not found Please check loctor"+e.getMessage());
			throw new Customexception("Element is not found Please check loctor"+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.log.error("An unexpected error occurred:"+e.getMessage());
			throw new Customexception("An unexpected error occurred:"+e.getMessage());
		}
	}
	
	/**
	 * provid dynamic drop down handel code
	 * @throws Customexception
	 */
	public void performDynamicOpreation() throws Customexception
	{
		//check element presnt or not
		try
		{
			if(ActionsMethod.isDisplay(firstImg)&&ActionsMethod.isEnable(firstImg)
					||ActionsMethod.isDisplay(secondImg)&&ActionsMethod.isEnable(secondImg)
					||ActionsMethod.isDisplay(thirdImg)&&ActionsMethod.isEnable(thirdImg))
			{
				Waits.applyVisibilityOf(driver,firstImg,30);
				Loggerclass.log.info("Verify All Elements Display and enable");
				ActionsMethod.dragAndDrop(driver,firstImg,dropArea);
				Loggerclass.log.info("perform firstImg dropDown");
				Waits.applyVisibilityOf(driver,secondImg,30);
				ActionsMethod.dragAndDrop(driver,secondImg,dropArea);
				Loggerclass.log.info("Perform secondImg dropDown");
				Waits.applyVisibilityOf(driver,thirdImg,30);
				ActionsMethod.dragAndDrop(driver,thirdImg,dropArea);
				Loggerclass.log.info("perform thirdImg dropDown");
			}
			else
			{
				Loggerclass.log.error("any dropDown element is not enable or display");
				System.out.println("any dropDown element is not enable or display");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.log.error("Element is not found Please check loctor"+e.getMessage());
			throw new Customexception("Element is not found Please check loctor"+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.log.error("An unexpected error occurred:"+e.getMessage());
			throw new Customexception("An unexpected error occurred:"+e.getMessage());
		}
	}
}
