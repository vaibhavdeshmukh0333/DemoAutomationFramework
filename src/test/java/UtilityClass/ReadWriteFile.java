/**
 * This class use for Read and write external file such as property file, excel file
 */

package UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ReadWriteFile 
{

	public static File f;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	
	public static FileInputStream ReadFile(String FilePath)
	{
		
		f=new File(FilePath);
		try
		{
			fis=new FileInputStream(f);
			return fis;
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			throw new RuntimeException("FileNotFound: "+FilePath,e);
		}
	}
}
