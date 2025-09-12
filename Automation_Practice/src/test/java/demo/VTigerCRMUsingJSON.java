package demo;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class VTigerCRMUsingJSON {

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException, ParseException
	{
		
		JSONParser jp=new JSONParser();// Creating an object of jsonparser
		
		Object obj = jp.parse(new FileReader("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VTigerCRMData.json"));// Converting json object into java representation object
		
		JSONObject jo=(JSONObject) obj;// Downcasting java object to JSONObject Type
		
		String browser = jo.get("browser").toString();// Return type is Object so either perform typecast or call toString() method.
		String url = jo.get("url").toString();
		String username = jo.get("username").toString();
		String password = jo.get("password").toString();
		
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		
		else if(browser.equals("edge"))
			driver=new EdgeDriver();
		
		else if(browser.equals("safari"))
			driver=new SafariDriver();
		
		else
			driver=new ChromeDriver();
		
        Random ran=new Random();
		
		int ranNum = ran.nextInt(100);
		
		FileInputStream fis2=new FileInputStream("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\CommonData\\VtigerCRMData.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis2);
		
		Sheet sh = wb.getSheet("Organization");
		
		Row row = sh.getRow(1);
		
		Cell cell1 = row.getCell(2);
		
		Cell cell2 = row.getCell(3);
		
		String oName = cell1.toString()+ranNum;
		
		String website = cell2.toString();
		
		wb.close();
		
		
		
		// basic common codes
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// basic business utility
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		
		
		// To perform actions on the application
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(oName);
		
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
		
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		String mainId = driver.getWindowHandle();
		
		Set<String> allIds = driver.getWindowHandles();
		
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			
			if(driver.getCurrentUrl().contains("action=Popup&popuptype"))
				break;
		}
		
		// Verifying member of 
		String oname="Facebook_41";	
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(oname);
		
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
		driver.findElement(By.xpath("//a[text()='"+oname+"']")).click();
		
		driver.switchTo().alert().accept();
		
		driver.switchTo().window(mainId);
		
		// delete organisation.................
		
				
		driver.findElement(By.xpath("(//input[contains(@value,'Save')])[1]")).click();
		
		driver.findElement(By.xpath("//input[@name='Delete']")).click();
		
		driver.switchTo().alert().accept();
		
//		WebElement headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
//		
//		if(headerText.getText().contains(oName))
//			System.out.println("Organization is created successfully.");
//		
//		else
//			System.out.println("Organization is not created yet.");
//		
//		
		WebElement icon = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(icon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.quit();
		
		
	}

}
