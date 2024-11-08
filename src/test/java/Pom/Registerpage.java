/**
 * Register Page is used to create object repository
 */

package Pom;

import java.time.Duration;
import java.time.Year;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.Loggerclass;

public class Registerpage 
{

	//creaet webdriver variable
	WebDriver driver;
	WebDriverWait w;
	//create parameterized constructor
	public Registerpage(WebDriver driver) 
	{
		this.driver=driver;
		w=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//find webelemets of register page
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath="//textarea[@ng-model='Adress']")
	private WebElement Address;
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='tel']")
	private WebElement phoneTextBox;
	
	@FindBy(xpath="//form[@id='basicBootstrapForm']/div[5]/div/label[1]/input[1]")
	private WebElement male;
	
	@FindBy(xpath="//form[@id='basicBootstrapForm']/div[5]/div/label[2]/input")
	private WebElement female;
	
	@FindBys(@FindBy(xpath="//form[@id='basicBootstrapForm']/div[6]/div/div/label"))
	private List<WebElement> checkBoxs;
	
	@FindBys(@FindBy(xpath="//form[@id='basicBootstrapForm']/div[7]//div/multi-select/div[2]/ul/li/a"))
	private List<WebElement> selectLanguage;
	
	@FindBy(id="msdd")
	private WebElement languageOption;
	
	@FindBy(xpath="//div[@class='row ']")
	private WebElement outsideClick;
	
	@FindBy(id="Skills")
	private WebElement skills;
	
	@FindBy(xpath="//span[@role='combobox']")
	private WebElement country;
	
	@FindBys(@FindBy(xpath="//ul[@role='tree']/li"))
	private List<WebElement> allCountry;
	
	@FindBy(id="yearbox")
	private WebElement selectYear;
	
	@FindBy(xpath="//select[@placeholder='Month']")
	private WebElement selectMonth;
	
	@FindBy(id="daybox")
	private WebElement day;
	
	
	@FindBy(id="firstpassword")
	private WebElement password;
	
	@FindBy(id="secondpassword")
	private WebElement confirmPassword;
	
	@FindBy(id="imagesrc")
	private WebElement selectImg;
	
	@FindBy(id="submitbtn")
	private WebElement submitBtn;
	
	
	
	/**
	 * below element is anchor tags 
	 */
	@FindBys(@FindBy(xpath="(//div[@class='container'])[2]/div/ul/li/a"))
	private List<WebElement> anchorTag;
	
	@FindBys(@FindBy(xpath="(//div[@class='container'])[2]/div/ul/li[4]/ul/li/a"))
	private List<WebElement> subAnchorTag;
	
	
	
	
	public void firstName(String name) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(firstName) && ActionsMethod.isEnable(firstName))
			{
				firstName.clear();
				ActionsMethod.sendKeys(firstName,name);
				Loggerclass.info("Entered First Name");
			}
			else
			{
				Loggerclass.error("First Name text box is not display or enable..");
				System.out.println("First Name text box is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("First Name Text Field is not found: "+e.getMessage());
			throw new Customexception("First Name Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	
	
	public void lastName(String name) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(lastName) && ActionsMethod.isEnable(lastName))
			{
				lastName.clear();
				ActionsMethod.sendKeys(lastName,name);
				Loggerclass.info("Entered Last Name");
			}
			else
			{
				Loggerclass.error("Last Name text box is not display or enable..");
				System.out.println("Last Name text box is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Last Name Text Field is not found: "+e.getMessage());
			throw new Customexception("Last Name Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void address(String name) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(Address) && ActionsMethod.isEnable(Address))
			{
				Address.clear();
				ActionsMethod.sendKeys(Address,name);
				Loggerclass.info("Entered Address");
			}
			else
			{
				Loggerclass.error("Address text box is not display or enable..");
				System.out.println("Address text box is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Address Text Field is not found: "+e.getMessage());
			throw new Customexception("Address Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void emailAddress(String name) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(email) && ActionsMethod.isEnable(email))
			{
				email.clear();
				ActionsMethod.sendKeys(email,name);
				Loggerclass.info("Entered email");
			}
			else
			{
				Loggerclass.error("email text box is not display or enable..");
				System.out.println("email text box is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("email Text Field is not found: "+e.getMessage());
			throw new Customexception("email Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void contact(String name) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(phoneTextBox) && ActionsMethod.isEnable(phoneTextBox))
			{
				phoneTextBox.clear();
				ActionsMethod.sendKeys(phoneTextBox,name);
				Loggerclass.info("Entered phoneTextBox");
			}
			else
			{
				Loggerclass.error("phone text box is not display or enable..");
				System.out.println("phone text box is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("phone  Text Field is not found: "+e.getMessage());
			throw new Customexception("phone  Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void male() throws Customexception
	{
		w=new WebDriverWait(driver,Duration.ofSeconds(10));
		try
		{
			if(ActionsMethod.isDisplay(male) && ActionsMethod.isEnable(male))
			{
				w.until(ExpectedConditions.elementToBeClickable(male));
				ActionsMethod.Click(male);
				Loggerclass.info("Click on male");
			}
			else
			{
				Loggerclass.error("male filed is not display or enable..");
				System.out.println("male filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("male filed is not found: "+e.getMessage());
			throw new Customexception("male filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void female() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(female) && ActionsMethod.isEnable(female))
			{
				w.until(ExpectedConditions.elementToBeClickable(female));
				ActionsMethod.Click(female);
				Loggerclass.info("Click on female");
			}
			else
			{
				Loggerclass.error("female filed is not display or enable..");
				System.out.println("female filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("female filed is not found: "+e.getMessage());
			throw new Customexception("female filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}
	}
	
	public void selectCheckbox(String hobiee)
	{
		
			int count=0;
			for(WebElement Hobbie:checkBoxs)
			{
				System.out.println("Singel hobbies: "+Hobbie.getText());
				
				count++;
				if(Hobbie.getText().contains(hobiee))
				{
					//System.out.println("Counter: "+count);
					//System.out.println("Singel Shobbies is: "+Hobbie.getText());
					
					WebElement checkBox=driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[6]/div/div["+count+"]/input"));
					w.until(ExpectedConditions.visibilityOf(checkBox));
					ActionsMethod.Click(checkBox);
					break;
				}
				Loggerclass.info("Select Hobiee");
			}
	}
	
	public void clickOnLaunageOption() throws Customexception
	{
		ActionsMethod.ScrollBy(driver, languageOption);
		try
		{
			w.until(ExpectedConditions.visibilityOf(languageOption));
			if(ActionsMethod.isDisplay(languageOption) && ActionsMethod.isEnable(languageOption))
			{
				
				ActionsMethod.Click(languageOption);
				Loggerclass.info("Click on language Option");
			}
			else
			{
				Loggerclass.error("language Option filed is not display or enable..");
				System.out.println("language Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("language Option filed is not found: "+e.getMessage());
			throw new Customexception("language Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	public void selectLaunage(String lang)
	{
		for(WebElement SingelLanguage:selectLanguage)
		{
			
			if(SingelLanguage.getText().contains(lang))
			{
				ActionsMethod.Click(SingelLanguage);
			}
		}
		Loggerclass.info("Select Lanuguage");
	}
	
	public void outsideClick()
	{
		
		ActionsMethod.Click(outsideClick);
		Loggerclass.info("Click outSide");
	}
	
	public void skill() throws Customexception
	{
		try
		{
			w.until(ExpectedConditions.visibilityOf(skills));
			if(ActionsMethod.isDisplay(skills) && ActionsMethod.isEnable(skills))
			{
				ActionsMethod.Click(skills);
				Loggerclass.info("Click on skills Option");
			}
			else
			{
				Loggerclass.error("skills Option filed is not display or enable..");
				System.out.println("skills Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("skills Option filed is not found: "+e.getMessage());
			throw new Customexception("skills Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	public void selectSkill(String input)
	{
		w.until(ExpectedConditions.elementToBeClickable(skills));
		Select s=new Select(skills);
		ActionsMethod.SelectClass(input, skills);
			
	}
	
	public void country() throws Customexception
	{
		try
		{
			w.until(ExpectedConditions.visibilityOf(country));
			if(ActionsMethod.isDisplay(country) && ActionsMethod.isEnable(country))
			{
				ActionsMethod.Click(country);
				Loggerclass.info("Click on country Option");
			}
			else
			{
				Loggerclass.error("country Option filed is not display or enable..");
				System.out.println("country Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("country Option filed is not found: "+e.getMessage());
			throw new Customexception("country Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	
	public void selectCountry(String input)
	{
		try
		{
			
			for(WebElement SingelCountry:allCountry)
			{
				w.until(ExpectedConditions.elementToBeClickable(SingelCountry));
				if(SingelCountry.getText().equals(input))
				{
					ActionsMethod.Click(SingelCountry);
					break;
				}
			}
			Loggerclass.info("Select Country");
		}
		catch (ElementClickInterceptedException e) {
			Loggerclass.error("country ElementClickIntercepted");
			e.printStackTrace();
		}
		catch (Exception e) {
			Loggerclass.error("country ElementClickIntercepted");
			e.printStackTrace();
		}
	}
	
	public void year() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(selectYear) && ActionsMethod.isEnable(selectYear))
			{
				ActionsMethod.Click(selectYear);
				Loggerclass.info("Click on Year Option");
			}
			else
			{
				Loggerclass.error("Year Option filed is not display or enable..");
				System.out.println("Year Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Year Option filed is not found: "+e.getMessage());
			throw new Customexception("Year Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	public void selectYear(String input)
	{
		Select s=new Select(selectYear);
		ActionsMethod.SelectClass(input, selectYear);
			
	}
	public void month() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(selectMonth) && ActionsMethod.isEnable(selectMonth))
			{
				ActionsMethod.Click(selectMonth);
				Loggerclass.info("Click on Month Option");
			}
			else
			{
				Loggerclass.error("Month Option filed is not display or enable..");
				System.out.println("Month Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Month Option filed is not found: "+e.getMessage());
			throw new Customexception("Month Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	public void selectMonth(String input)
	{
		Select s=new Select(selectMonth);
		ActionsMethod.SelectClass(input, selectMonth);
			
	}
	public void day() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(day) && ActionsMethod.isEnable(day))
			{
				ActionsMethod.Click(day);
				Loggerclass.info("Click on day Option");
			}
			else
			{
				Loggerclass.error("day Option filed is not display or enable..");
				System.out.println("day Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("day Option filed is not found: "+e.getMessage());
			throw new Customexception("day Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	public void selectDay(String input)
	{
		
		Select s=new Select(day);
		ActionsMethod.SelectClass(input, day);
			
	}
	
	public void password(String input) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(password) && ActionsMethod.isEnable(password))
			{
				password.clear();
				ActionsMethod.sendKeys(password, input);
				Loggerclass.info("Entered password");
			}
			else
			{
				Loggerclass.error("Password text box is not display or enable..");
				System.out.println("Password text box is not display or enable.");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("Password Text Field is not found: "+e.getMessage());
			throw new Customexception("Password Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	public void confirmPassword(String input) throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(confirmPassword) && ActionsMethod.isEnable(confirmPassword))
			{
				confirmPassword.clear();
				ActionsMethod.sendKeys(confirmPassword, input);
				Loggerclass.info("Entered confirm Password");
			}
			else
			{
				Loggerclass.error("confirm Password text box is not display or enable..");
				System.out.println("confirm Password text box is not display or enable.");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("confirm Password Text Field is not found: "+e.getMessage());
			throw new Customexception("confirm Password Text Field is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	
	public void selectimage() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(selectImg) && ActionsMethod.isEnable(selectImg))
			{
				ActionsMethod.Click(selectImg);
				Loggerclass.info("Click on selectImg Option");
			}
			else
			{
				Loggerclass.error("selectImg Option filed is not display or enable..");
				System.out.println("selectImg Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("selectImg Option filed is not found: "+e.getMessage());
			throw new Customexception("selectImg Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	public void submit() throws Customexception
	{
		try
		{
			if(ActionsMethod.isDisplay(submitBtn) && ActionsMethod.isEnable(submitBtn))
			{
				submitBtn.submit();
				Loggerclass.info("Click on submitBtn Option");
			}
			else
			{
				Loggerclass.error("submitBtn Option filed is not display or enable..");
				System.out.println("submitBtn Option filed is not display or enable..");
			}
		}
		catch (NoSuchElementException e) {
			Loggerclass.error("submitBtn Option filed is not found: "+e.getMessage());
			throw new Customexception("submitBtn Option filed is not found: "+e.getMessage());
		}
		catch (Exception e) {
			Loggerclass.error("An unexpected error occurred: "+e.getMessage());
			throw new Customexception("An unexpected error occurred: "+e.getMessage());
		}	
	}
	
	
	
	public void navigateSwitchTo()
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='container'])[2]/div/ul/li/a")));
		
		for(WebElement ele:anchorTag)
		{
			if(ele.getText().equals("SwitchTo"))
			{
				new Actions(driver).moveToElement(ele).click().build().perform();
				break;
			}
		}
		
	}
	
	public void navigateAlert()
	{
		new WebDriverWait(driver,Duration.ofSeconds(10)).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='container'])[2]/div/ul/li[4]/ul/li/a")));
		
		for(WebElement ele:subAnchorTag)
		{
			if(ele.getText().equals("Alerts"))
			{
				new Actions(driver).moveToElement(ele).click().build().perform();
				break;
			}
		}
	}
	
	public void navigateFrame()
	{
		
		new WebDriverWait(driver,Duration.ofSeconds(10)).
		until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[@class='container'])[2]/div/ul/li[4]/ul/li/a")));
		
		for(WebElement singleOption:subAnchorTag)
		{
			if(singleOption.getText().contains("Frames"))
			{
				new Actions(driver).moveToElement(singleOption).click().build().perform();
				Loggerclass.info("Navigate Frame");
			}
		}
	}
	
	public void navigateWindow()
	{
		
		//WebElement element=driver.findElement(By.xpath("//a[text()='Windows']"));
		//element.click();
		for(WebElement element:subAnchorTag)
		{
			System.out.println(element.getText());
			if(element.getText().contains("Windows"))
			{
				element.click();
				break;
			}
		}
	}
}
