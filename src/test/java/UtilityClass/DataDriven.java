/**
 * ExcelSheet write and read code. here is two methods first methods is used for read excelsheet and workbook 
 * create object of workbook child class and return workbook.
 * 
 * second class here is main logic of read excel sheet
 */

package UtilityClass;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven
{
	//create static variables to hold data read and write excel file
	static Workbook w;
	static Sheet s;
	static Row r;
	static Cell c;
	static int LastRow;
	static int LastCell;
	
	/**
	 * method is read path of excel sheet and create object of workbook and pass file to workbook
	 * @param ExcelPath
	 */
	public static void readExcelSheet(String ExcelPath)
	{
		FileInputStream fis=ReadWriteFile.ReadFile(ExcelPath);
		try
		{
			w=new XSSFWorkbook(fis);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new RuntimeException("IoExcepyion",e);
		}
	}
	
	/**
	 * read data into the excel sheet and return object[][]
	 * @param ExcelPath
	 * @param SheetName
	 * @return
	 */
	public static Object[][] readData(String ExcelPath,String SheetName)
	{
		readExcelSheet(ExcelPath); // call readExcelSheet to read workbook
		s=w.getSheet(SheetName);
		//System.out.println(s.getSheetName());
		int LastRow=s.getLastRowNum();		//hold get last row value
		//System.out.println("Last Row: "+LastRow);
		
		
		int LastCell=s.getRow(0).getLastCellNum();//hold last cell value
		//System.out.println("Last Cell: "+LastCell);
		
		//create object[][] 
		Object[][] obj=new Object[LastRow+1][LastCell];
		
		//use for itreate row
		for(int i=0;i<=LastRow;i++)
		{
			Row r=s.getRow(i);// Hold first row
			
			//use for itreate cell
			for(int j=0;j<LastCell;j++)
			{
				Cell c=r.getCell(j); //Hold first cell
				
				
				switch(c.getCellTypeEnum())//check value is string or numeric 
				{
					//add string value object of two dimention array
					case STRING: obj[i][j]=c.getStringCellValue();
					//System.out.println(c.getStringCellValue());
						break;
				
					//add numeric value object of two dimention array
					case NUMERIC: obj[i][j]=c.getNumericCellValue();
					//System.out.println(c.getNumericCellValue());
					break;
				}
			}
		}
		
		return obj; // return object
	}
}
