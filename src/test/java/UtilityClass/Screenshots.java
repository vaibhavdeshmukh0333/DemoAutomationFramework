package UtilityClass;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots 
{

	
	public static String CaptureScreenShot(WebDriver driver, String path) throws IOException
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		//System.out.println(path);
		File src=t.getScreenshotAs(OutputType.FILE);
		File desc=new File(path+".png");
		try
		{
			FileUtils.copyFile(src, desc);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		Loggerclass.info("Captured ScreenShot Sucessfully");
		//System.out.println(desc.getAbsolutePath());
		return desc.getAbsolutePath();		//it return absolute path of captured screenshot
	}
	
	public static String ScreenShot(WebDriver driver)
	{
		TakesScreenshot t=(TakesScreenshot) driver;
		return t.getScreenshotAs(OutputType.BASE64);
	}
}
