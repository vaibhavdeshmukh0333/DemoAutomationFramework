package UtilityClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class RobotClass 
{

	public static void PerformWindowHandling(String path) throws InterruptedException
	{
		try
		{
			System.out.println(path);
			Robot r=new Robot();
			Thread.sleep(3000);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(path), null);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
		catch (AWTException e) {
			e.printStackTrace();
		}
		
	}
}
