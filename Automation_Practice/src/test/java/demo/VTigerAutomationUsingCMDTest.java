package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class VTigerAutomationUsingCMDTest {

	@Test
	public void createOrganization() throws EncryptedDocumentException, IOException
	{
		String browser = System.getProperty("browser");
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		
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
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(url);
		
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'action=index')]")).click();
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(oName);
		
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
		
		driver.findElement(By.xpath("(//input[contains(@value,'Save')])[1]")).click();
		
		WebElement headerText = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		
		if(headerText.getText().contains(oName))
			System.out.println("Organization is created successfully.");
		
		else
			System.out.println("Organization is not created yet.");
		
		WebElement icon = driver.findElement(By.xpath("//img[contains(@src,'softed/images/user.PNG')]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(icon).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		driver.close();
	}
	
}
