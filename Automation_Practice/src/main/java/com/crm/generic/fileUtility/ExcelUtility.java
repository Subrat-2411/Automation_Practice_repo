package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Subrat Kumar Sahoo
 * This class contains all reusable methods to read the data from Excel file.
 */
public class ExcelUtility {

	/**@author Subrat Kumar Sahoo
	 * This method is used to get data from excel based on the sheetname,row,column.
	 * @param upperLimit
	 * @return String
	 */
	public String getDataFromExcel(String sheetName,int rownum,int colnum) throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/VTigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		String value=wb.getSheet(sheetName).getRow(rownum).getCell(colnum).toString();
		
		wb.close();
		
		return value;
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used to count the total no of rows.
	 * @param upperLimit
	 * @return int
	 */
	public int getRowCount(String sheetName) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VTigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		int value=wb.getSheet(sheetName).getLastRowNum();
		
		wb.close();

		return value;
	}
	
	
	/**@author Subrat Kumar Sahoo
	 * This method is used write data into excel based on the sheetname,row,column and data.
	 * @param upperLimit
	 * @return 
	 */

	public void setDataIntoExcel(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VTigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Cell cell = wb.getSheet(sheetName).getRow(rownum).createCell(colnum);
		
		cell.setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VTigerCRMData.xlsx");
		
		wb.write(fos);
		
		wb.close();
		
	}
}
