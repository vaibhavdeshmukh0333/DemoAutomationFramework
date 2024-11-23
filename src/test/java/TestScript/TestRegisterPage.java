package TestScript;

import java.time.Duration;
import java.util.List;

import javax.swing.ActionMap;
import javax.xml.xpath.XPath;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.checkerframework.checker.units.qual.g;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.DataDriven;

import UtilityClass.RobotClass;


public class TestRegisterPage extends Baseclass 
{
	/**
	 * Below method is pass url of current page
	 * 
	 */
	
	@BeforeClass
	private void PassRegUrl()
	{
		ActionsMethod.NavigateTo(driver, "https://demo.automationtesting.in/Register.html");
		
	}

	
	/**
	 * 
	 * @param F_Name
	 * @param L_Name
	 * @param Address
	 * @param Email
	 * @param no
	 * @throws InterruptedException 
	 */
	@Test(dataProvider="GetData")
	public void RegPage(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws InterruptedException
	{
		
		ActionsMethod.Navigate(driver); //refresh page becoz we perform drop down handling
		/**
		 * below webelement find and perform opretion on element by using data driven
		 */
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(F_Name);
		
		/**
		 * find webelement based on firstname text filed by using selenium 4 relative locator
		 */
		WebElement LastName=driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(FirstNameTextBox));
		LastName.clear();
		LastName.sendKeys(L_Name);
		
		/**
		 * find webelement based on firstname text filed by using selenium 4 relative locator
		 */
		WebElement Add=driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(FirstNameTextBox));
		Add.clear();
		Add.sendKeys(Address);
		
		/**
		 * find webelement based on Address text filed abd address find above webelemt by using selenium 4 relative locator
		 */
		WebElement email=driver.findElement(RelativeLocator.with(By.tagName("input")).below(Add));
		email.clear();
		email.sendKeys(Email);
		
		/**
		 * find webelement based on email text filed and email find webelement above element by using selenium 4 relative locator
		 * 
		 * pass number so data driven return double value so convert number into long and after convert string
		 */
		WebElement contact=driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
		int num=(int)no;
		String phone=String.valueOf(num);
		contact.clear();
		contact.sendKeys(phone);
		
		
		/**
		 * Select Gender By using data driven
		 */
		
		if(Gen.equalsIgnoreCase("Male")) //check data is male or nor if it is male then click on male otherwise female
		{
			WebElement male=driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[5]/div/label[1]/input[1]"));
			ActionsMethod.Click(male);
		}
		else if(Gen.equalsIgnoreCase("Female"))
		{
			WebElement Female=driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[5]/div/label[2]/input"));
			ActionsMethod.Click(Female);
		}
		
		
		/**
		 * write code for test checkbox as per sport
		 */
		
		List<WebElement> AllCheckBox=driver.findElements(By.xpath("//form[@id='basicBootstrapForm']/div[6]/div/div/label"));
		
		
		for(String word:hobbies.trim().split(","))
		{
			int count=0;
			for(WebElement Hobbie:AllCheckBox)
			{
				System.out.println("Singel hobbies: "+Hobbie.getText());
				
				count++;
				if(Hobbie.getText().contains(word))
				{
					System.out.println("Counter: "+count);
					System.out.println("Singel Shobbies is: "+Hobbie.getText());
					WebElement checkBox=driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[6]/div/div["+count+"]/input"));
					ActionsMethod.Click(checkBox);
					break;
				}
				
			}
		}
		
		
		/**
		 * Perform Drop down Handling 
		 * 
		 */
		
		List<WebElement> AllLanguage=driver.findElements(By.xpath("//form[@id='basicBootstrapForm']/div[7]//div/multi-select/div[2]/ul/li/a"));
		
		String SplitLang[]=lang.trim().split(",");
		
		WebElement ClickOnLanguage=driver.findElement(By.id("msdd"));
		ActionsMethod.ScrollBy(driver, ClickOnLanguage);
		ActionsMethod.Click(ClickOnLanguage);
		
		for(String Word:lang.trim().split(","))
		{
			for(WebElement SingelLanguage:AllLanguage)
			{
				if(SingelLanguage.getText().contains(Word))
				{
					ActionsMethod.Click(SingelLanguage);
				}
			}
		}
		
		/**
		 * click on page because close dropdown
		 */
		WebElement ClickOnOutside=driver.findElement(By.xpath("//div[@class='row ']"));
		WebDriverWait w=new WebDriverWait(driver, Duration.ofSeconds(20));
		w.until(ExpectedConditions.elementToBeClickable(ClickOnOutside));
		ActionsMethod.Click(driver,ClickOnOutside);
		
		
		/**
		 * Code Select skill by using Select class
		 */
		WebElement ClickOnSkill=driver.findElement(RelativeLocator.with(By.tagName("select")).below(ClickOnLanguage));
		ClickOnSkill.click();
	
		List<WebElement> AllOptions=ActionsMethod.SelectClass(ClickOnSkill);
		System.out.println("All Element is: "+AllOptions.size());
		ActionsMethod.SelectClass(Skill,ClickOnSkill);
		ClickOnOutside.click();
	
		/**
		 * Select Country code
		 */
		try
		{
			WebElement ClickOnSelectCountry=driver.findElement(By.xpath("//span[@role='combobox']"));
			ActionsMethod.Click(driver, ClickOnSelectCountry);
			
			List<WebElement> AllCountry=driver.findElements(By.xpath("//ul[@role='tree']/li"));
			for(WebElement SingelCountry:AllCountry)
			{
				if(SingelCountry.getText().equals(Country))
				{
					SingelCountry.click();
					break;
				}
			}
		}
		catch (ElementClickInterceptedException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		/**
		 * 
		 * Code for Select birth date
		 */
		WebElement year=driver.findElement(By.id("yearbox"));
		year.click();
		int Ye=(int) Year;		// convert double into int because numeric value read double 
		String y=Integer.toString(Ye); 
		ActionsMethod.SelectClass(y, year);
		
		WebElement mon=driver.findElement(By.xpath("//select[@placeholder='Month']"));
		mon.click();
		
		ActionsMethod.SelectClass(m, mon);
		
		WebElement day=driver.findElement(By.id("daybox"));
		day.click();
		int da=(int) Day;
		String d=Integer.toString(da);
		
		ActionsMethod.SelectClass(d, day);
		
		/**
		 * Enter Password code
		 */
		WebElement Pass=driver.findElement(By.id("firstpassword"));
		Pass.sendKeys(password);	
		
		WebElement ConfirmPass=driver.findElement(By.id("secondpassword"));
		ConfirmPass.sendKeys(confirmpassword);
		
		/**
		 * Code Select Image
		 */
		WebElement SelectImg=driver.findElement(By.id("imagesrc"));
		ActionsMethod.Click(driver, SelectImg);
		
		RobotClass.PerformWindowHandling(path);

		
		WebElement Submit =driver.findElement(By.id("submitbtn"));
		Submit.click();
}
	/**
	 * Below method write for create different method as per text filed and check that filed but pass paramter as per 
	 * excel sheet data
	 */
	/*@Test(dataProvider="GetData")
	public void CheckFirstName(String F_Name,String L_Name,String Address,String Email,double no)
	{
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		FirstNameTextBox.clear();
		FirstNameTextBox.sendKeys(F_Name);
	}
	
	@Test(dataProvider="GetData")
	public void CheckLastName(String F_Name,String L_Name,String Address,String Email,double no)
	{
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement LastName=driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(FirstNameTextBox));
		LastName.clear();
		LastName.sendKeys(L_Name);
	}
	@Test(dataProvider="GetData")
	public void CheckAddress(String F_Name,String L_Name,String Address,String Email,double no)
	{
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement Add=driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(FirstNameTextBox));
		Add.clear();
		Add.sendKeys(Address);
	}
	
	@Test(dataProvider="GetData")
	public void CheckEmail(String F_Name,String L_Name,String Address,String Email,double no)
	{
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement Add=driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(FirstNameTextBox));
		WebElement email=driver.findElement(RelativeLocator.with(By.tagName("input")).below(Add));
		email.clear();
		email.sendKeys(Email);
	}
	
	@Test(dataProvider="GetData")
	public void CheckContact(String F_Name,String L_Name,String Address,String Email,double no)
	{
		WebElement FirstNameTextBox=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement Add=driver.findElement(RelativeLocator.with(By.tagName("textarea")).below(FirstNameTextBox));
		WebElement email=driver.findElement(RelativeLocator.with(By.tagName("input")).below(Add));
		WebElement contact=driver.findElement(RelativeLocator.with(By.tagName("input")).below(email));
		int n=(int) no;
		String num=String.valueOf(n);
		contact.clear();
		contact.sendKeys(num);
	}*/
	
	
	@DataProvider
	public static Object[][] GetData()
	{
		return DataDriven.readData("src\\test\\resources\\ExcelSheet\\TestData.xlsx", "Sheet1");
	}
	
	@AfterClass
	public void teardown()
	{
		CloseTab();
	}
}
