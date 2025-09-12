package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteDataBackToExcel {

	@Test
	public void writeData() throws Throwable
	{
FileInputStream fis2=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\VtigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Organization");
		
		Row row = sh.getRow(0);
		
		Cell cell = row.createCell(4);
		
		cell.setCellType(CellType.STRING);
		
		cell.setCellValue("status");
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\VtigerCRMData.xlsx");
		
		wb.write(fos);
		
		System.out.println("Writing Completed");
		
		wb.close();
		
		
		
	}
}
