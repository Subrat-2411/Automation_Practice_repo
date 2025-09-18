package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.generic.fileUtility.ExcelUtility;

public class FlipkartPriceTest {
	
//	ExcelUtility eutil=new ExcelUtility();

	@Test(dataProvider = "getData")
	public void flipkartPriceTest(String productName,String brandName,int rowIndex) throws IOException,InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(productName,Keys.ENTER);
		
//		Thread.sleep(2000);
		
		String price=driver.findElement(By.xpath("//div[text()='"+brandName+"']/ancestor::div[@class='yKfJKb row']/descendant::div[contains(text(),'₹')]")).getText();
		
		System.out.println(brandName+"  price : "+price);
		
		ExcelUtility eutil=new ExcelUtility();

		eutil.setDataIntoExcel("Sheet1",rowIndex,2, price);
		
		driver.close();
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		ExcelUtility eutil=new ExcelUtility();

		int rowCount=eutil.getRowCount("Sheet1");
		
		Object[][] obj=new Object[rowCount][3];
		
		for(int i=0;i<rowCount;i++)
		{
			obj[i][0]=eutil.getDataFromExcel("Sheet1", i+1,0);
			
			obj[i][1]=eutil.getDataFromExcel("Sheet1", i+1,1);
			
			obj[i][2]=i+1;
		}
		
//		obj[0][0]="iphone15";
//		obj[0][1]="Apple iPhone 15 (Black, 128 GB)";
//		obj[1][0]="samsung laptop";
//		obj[1][1]="Samsung Galaxy Book4 Metal Intel Core i5 13th Gen 1335U - (8 GB/512 GB SSD/Windows 11 Home) NP750XGJ-K...";
//		obj[2][0]="tv";
//		obj[2][1]="MarQ by Flipkart 80 cm (32 inch) HD Ready LED TV";

		return obj;
	}
}
