package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadingDatasFromMultipleRows {

	@Test
	public void readingMultipleDatas() throws EncryptedDocumentException, IOException
	{

		FileInputStream fis2=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\VtigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Organization");
		
		String column1Data="";
		String column2Data="";
		String column3Data="";
		int rowCount = sh.getLastRowNum();
		
		for (int i = 0; i <=rowCount; i++) {
			
			
			try {
				Row row = sh.getRow(i);
				
				column1Data = row.getCell(0).toString();
				
				column2Data = row.getCell(1).toString();
				
				column3Data = row.getCell(3).toString();
			} catch (Exception e) {
				System.out.println("No data available");
			}
			finally {
				wb.close();
			}
			
			System.out.println(column1Data+"\t"+column2Data+"\t"+column3Data);
		}
	}
}
