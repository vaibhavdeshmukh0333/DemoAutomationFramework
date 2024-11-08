package TestScript;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pom.Registerpage;
import Superclass.Baseclass;
import UtilityClass.ActionsMethod;
import UtilityClass.Customexception;
import UtilityClass.DataDriven;
import UtilityClass.ListenerClass;
import UtilityClass.Loggerclass;
import UtilityClass.RobotClass;


@Listeners(ListenerClass.class)
public class TestRegister extends Baseclass
{
	Registerpage rp;
	
	@BeforeClass(groups= {"smoke","regression"})
	public void navigateRegisterPage() throws Customexception
	{
		try
		{
			if(driver!=null)
			{
				ActionsMethod.Get(driver, p.getProperty("RegisterPage"));
				Loggerclass.info("Launch Regsiter Page");
			}
		}
		catch (WebDriverException e) {
			Loggerclass.error("Internet Connection OFF Please check Internet Connection");
			throw new Customexception("Internet Connection OFF Please check Internet Connection: "+e.getMessage());
		}
		catch (NullPointerException e) {
			Loggerclass.error("WebDriver is NULL");
			throw new Customexception("WebDriver is NULL: "+e.getMessage());
		}
		catch(Exception e)
		{
			Loggerclass.error("URL Issue");
			throw new Customexception("URL Issure: "+e.getMessage());
		}
		
	}
	
	@Test(alwaysRun=true,groups= {"smoke","regression"})
	public void verifyRegisterPage()
	{
		Assert.assertEquals(driver.getTitle(),"Register");
	}
	
	@Test(dataProvider="GetData",groups= {"regression"})
	public void VerifyRegisterPage(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception, InterruptedException
	{
		ActionsMethod.Navigate(driver); //refresh page becoz we perform drop down handling
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.firstName(F_Name);
		rp.lastName(L_Name);
		rp.address(Address);
		rp.emailAddress(Email);
		int num=(int) no;
		String number=Integer.toString(num);
		rp.contact(number);
		
		/**
		 * Select Gender By using excel sheet data
		 */
		
		if(Gen.equalsIgnoreCase("Male")) //check data is male or nor if it is male then click on male otherwise female
		{
			rp.male();
		}
		else if(Gen.equalsIgnoreCase("Female"))
		{
			rp.female();
		}
		
		
		/**
		 * write code for test checkbox 
		 */
		
		for(String word:hobbies.trim().split(","))
		{
			rp.selectCheckbox(word);
		}
		
		/**
		 * Perform Drop down Handling 
		 * 
		 */
		
		rp.clickOnLaunageOption();
		
		String SplitLang[]=lang.trim().split(",");
		
		for(String singleLang:SplitLang)
		{
			rp.selectLaunage(singleLang);
		}
		
		rp.outsideClick();
		rp.skill();
		rp.selectSkill(Skill);
	
		/**
		 * Select Country code
		 */
		rp.country();
		rp.selectCountry(Country);
		/**
		 * 
		 * Code for Select birth date
		 */
		int ye=(int) Year;
		String year=Integer.toString(ye);
		rp.year();
		rp.selectYear(year);
		rp.month();
		rp.selectMonth(m);

		rp.day();
		int d=(int) Day;
		String input=Integer.toString(d);
		rp.selectDay(input);
		
		/**
		 * Enter Password code
		 */
		rp.password(password);
		rp.confirmPassword(confirmpassword);
		
		/**
		 * Code Select Image
		 */
		//rp.selectimage();
		//RobotClass.PerformWindowHandling(path);
		rp.submit();
	}
	
	//@Test(dataProvider="GetData")
	public void verifyFirstName(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.firstName(F_Name);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyLastName(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.lastName(L_Name);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyAddress(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.address(Address);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyEmailid(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.emailAddress(Email);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyContactNumber(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		String number=Double.toString(no);
		rp.contact(number);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyGender(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		if(Gen.equalsIgnoreCase("Male")) //check data is male or nor if it is male then click on male otherwise female
		{
			rp.male();
		}
		else if(Gen.equalsIgnoreCase("Female"))
		{
			rp.female();
		}
	}
	
	//@Test(dataProvider="GetData")
	public void verifyHobiee(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		
		for(String word:hobbies.trim().split(","))
		{
			rp.selectCheckbox(word);
		}
	}
	
	
	//@Test(dataProvider="GetData")
	public void verifyLanguage(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		
		rp.clickOnLaunageOption();
		
		String SplitLang[]=lang.trim().split(",");
		
		for(String singleLang:SplitLang)
		{
			rp.selectLaunage(singleLang);
		}
	}
	
	
	//@Test(dataProvider="GetData")
	public void verifySkill(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		
		rp.outsideClick();
		rp.skill();
		rp.selectSkill(Skill);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyCountry(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		
		rp.country();
		rp.selectCountry(Country);
	}
	
	
	//@Test(dataProvider="GetData")
	public void verifyYear(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		String year=Double.toString(Year);
		rp.year();
		rp.selectYear(year);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyMonth(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.month();
		rp.selectMonth(m);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyDay(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.day();
		String input=Double.toString(Day);
		rp.selectDay(input);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyPassword(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.password(password);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyConfirmPassword(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.confirmPassword(confirmpassword);
	}
	
	//@Test(dataProvider="GetData")
	public void verifyImage(String F_Name,String L_Name,String Address,String Email,double no,
			String Gen,String hobbies, String lang,String Skill,String Country,
			double Year,String m, double Day, String password ,String confirmpassword,
			String path) throws Customexception, InterruptedException
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.selectimage();
		RobotClass.PerformWindowHandling(path);
	}
	
	//@Test
	public void verifySubmitBtn() throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.submit();
	}
	
	@Test(groups= {"smoke"})
	public void verifyRegisterPageByUsingValidData() throws Customexception
	{
		rp=PageFactory.initElements(driver, Registerpage.class);
		rp.firstName("Vaibhav");
		rp.lastName("Deshmukh");
		rp.address("Pune");
		rp.emailAddress("abc@gmail.com");
		rp.contact("9844335676");
		ActionsMethod.Scrollby(driver, 500,500);
		rp.submit();
		
	}
	
	@AfterClass(groups= {"smoke","regression"})
	void tearDown()
	{
		CloseTab();
	}
	
	@DataProvider
	public Object[][] GetData()
	{
		return DataDriven.readData("src\\test\\resources\\ExcelSheet\\TestData.xlsx", "Sheet1");
	}
}
