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
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData/VTigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Contacts");
		
		int rownum = sh.getLastRowNum();
		
		for(int i = 0; i < rownum; i++) {
		    Row row = sh.getRow(i);
		    
		    int colnum = row.getLastCellNum(); 
		    
		    for (int j = 0; j < colnum; j++) {
		    	
		        //String value = getCellValue(row, j); 
		    	Cell cell=row.getCell(j);
		    	
		    	if(cell==null||cell.toString().isEmpty())
		    		
		        System.out.print("N/A"+"\t");
		    	
		    	else
		    		System.out.print(cell.toString()+"\t");
		    }
		    System.out.println(); 
		}
		wb.close();
	}
//	public static String getCellValue(Row row,int col)
//	{
//		 
//        if (row == null)
//        	return "N/A";
//
//        Cell cell = row.getCell(col);
//        
//        if (cell == null)
//        	return "N/A";
//        		
//        else if(cell.toString().isEmpty()) 
//            return "N/A";
//
//        return cell.toString();
//    }
}
