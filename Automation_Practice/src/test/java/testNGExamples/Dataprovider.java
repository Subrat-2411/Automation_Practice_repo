package testNGExamples;

import org.testng.annotations.DataProvider;

public class Dataprovider {

	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][2];// Here 3-> No. of times/rows and no of arguments/columns
		
		objArr[0][0]="Ramesh";
		
		objArr[0][1]="Sahoo";
		
		objArr[1][0]="Subrat";
		
		objArr[1][1]="sahoo";
		
		objArr[2][0]="Rashmi";
		
		objArr[2][1]="Sahoo";
		
		return objArr;
	}
}
