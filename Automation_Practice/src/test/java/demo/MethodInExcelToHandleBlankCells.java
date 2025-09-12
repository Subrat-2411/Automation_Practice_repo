package demo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class MethodInExcelToHandleBlankCells {

	@Test
	public void readDataFromExcel() throws IOException
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VtigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Organization");
		
		int rownum = sh.getLastRowNum();
		
		for(int i = 0; i < rownum; i++) {
		    Row row = sh.getRow(i);
		    
		    int colnum = row.getLastCellNum(); 
		    
		    for (int j = 0; j < colnum; j++) {
		    	
		        String value = getCellValue(row, j); 
		        System.out.println(value+"\t");
		    }
		    System.out.println(); 
		}
		wb.close();
	}
	public static String getCellValue(Row row,int col)
	{
		 
        if (row == null)
        	return "N/A";

        Cell cell = row.getCell(col);
        
        if (cell == null)
        	return "N/A";
        		
        else if(cell.toString().isEmpty()) 
            return "N/A";

        return cell.toString();
    }
}
