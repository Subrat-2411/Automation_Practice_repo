package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class ReadingMutipleRowDatasCondition {

	@Test
	public void mutipleRowDatasCondition() throws Throwable 
	{
		
		String expId="TC_100";
      FileInputStream fis2=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\VtigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Organization");
		
		String column2Data="";
		String column3Data="";
		String column4Data="";
		int rowCount = sh.getLastRowNum();
		
		boolean flag=false;
		
		for (int i = 0; i <=rowCount; i++) {
			String data="";
			try {
				
				data = sh.getRow(i).getCell(0).toString();
				if(data.equals(expId)) {
					flag=true;
				column2Data=sh.getRow(i).getCell(1).toString();
				
				column3Data=sh.getRow(i).getCell(2).toString();
				
				column4Data=sh.getRow(i).getCell(3).toString();
				}
			} 
			
			catch (Exception e) {
				
				
			}
			
			
		}
		if(flag==true)
		System.out.println(column2Data+"\t"+column3Data+"\t"+column4Data);
		
		else
			System.out.println("No Such Data is Available in Workbook");
	}
}
