/**
 * Frame Page to stored object repositiory
 */
package Pom;

import java.util.NoSuchElementException;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;
import UtilityClass.Waits;

public class Framepage
{
	WebDriver driver; //create instance of driver
	
	public Framepage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	@FindBy(id="singleframe")
	private WebElement switchSingleFrame;// web element used to switch to single frame
	
	@FindBy(xpath="//h5[text()='iFrame Demo']/parent::div/div/div/input")
	private WebElement textBox;//find textBox
	
	
	
	@FindBy(xpath="//a[text()='Iframe with in an Iframe']")
	private WebElement multipleFrameBtn;	//click on multiple frame options
	
	@FindBy(xpath="//div[@id='Multiple']/iframe")
	private WebElement nestedfirstFrame;	//switch nested first frame
	
	@FindBy(xpath="//h5[text()='Nested iFrames']")
	private WebElement nestedFirstFrameText;
	
	@FindBy(xpath="//h5[text()='Nested iFrames']/parent::div/iframe")
	private WebElement nestedSecondFrame; //webElement of second frame
	
	
	/**
	 * switch to single frame 
	 * @throws Customexception
	 */
	
	public void firstFrame() throws Customexception
	{
		
		try
		{	//check whether frame is present or not
			if(switchSingleFrame.isDisplayed() && switchSingleFrame.isEnabled() && switchSingleFrame!=null)
			{
				driver.switchTo().frame(switchSingleFrame);	//switch frame by using webelement
				Loggerclass.info("Switch Single Frame Sucessfully");
			}
			else
			{	//frame is not display or enable then print message
				Loggerclass.error("Single Frame unable to switch becoz it is not diplay or enable ot null");
				System.out.println("Single Frame unable to switch becoz it is not diplay or enable ot null");
			}
		}
		catch (NullPointerException e) {//handle exception
			Loggerclass.error("Frame is Null");
			throw new Customexception("Frame is null "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("Unbale to Handle Single frame");
			throw new Customexception("Unbale to Handle Single frame: "+e.getMessage());
		}
	}
	
	/**
	 * send value to textbox
	 * @param input
	 */
	public void passText(String input)
	{
		textBox.clear();
		textBox.sendKeys(input);
		Loggerclass.info("Send input sucessfully");
	}
	
	/**
	 * Click on multiple frame options
	 * @throws Customexception
	 */
	public void clickOnNestedFrameBtn() throws Customexception
	{
		try
		{	//verify frame display or enable
			if(multipleFrameBtn.isDisplayed() 
					&&multipleFrameBtn.isEnabled())
			{
				ActionsMethod.Click(multipleFrameBtn);
				Loggerclass.info("Click on Multiple Frame options");
			}
			else
			{
				Loggerclass.error("Mulitple frame options is not display or enable");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Element is not found");
			throw new Customexception("element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred:"+e.getMessage() );
		}
	}
	
	/**
	 * Switch to nested frame options
	 * @throws Customexception 
	 */
	public void switchToNestedFirstFrame() throws Customexception
	{
		try
		{
			if(nestedfirstFrame.isDisplayed() 
					&& nestedfirstFrame.isEnabled())
			{
				driver.switchTo().frame(nestedfirstFrame);
				Loggerclass.info("Switch to Single first Frame");
			}
			else
			{
				Loggerclass.info("unble to switch nested first frame");
				System.out.println("unble to switch nested first frame");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Unable to found switch");
			System.out.println("unable to found switch");
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred:"+e.getMessage() );
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	/**
	 * get single frame text
	 * @throws Customexception 
	 */
	public String getText() throws Customexception
	{
		String text=null;
		try
		{
			if(nestedFirstFrameText.isDisplayed()
					&& nestedFirstFrameText.isEnabled())
			{
				text=nestedFirstFrameText.getText();
				Loggerclass.info("get text sucessfully");
				
			}
			else
			{
				Loggerclass.error("text is not display or enable");
			}
			
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Text element is not found");
			throw new Customexception("text element is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred:"+e.getMessage());
			throw new Customexception("An unexpected error occurred:"+e.getMessage());
		}
		return text;
	}
	
	
	public void switchToNestedSecondFrame() throws Customexception
	{
		try
		{
			if(nestedSecondFrame.isDisplayed()
					&&
				nestedSecondFrame.isEnabled())
			{
				driver.switchTo().frame(nestedSecondFrame);
				Loggerclass.info("Switch to nested frame");
			}
			else
			{
				Loggerclass.error("Second frame is not display or enable");
				System.out.println("Second frame is not display or enable");
			}
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred:"+e.getMessage());
			throw new Customexception("An unexpected error occurred:"+e.getMessage());
			
		}
	}
}
