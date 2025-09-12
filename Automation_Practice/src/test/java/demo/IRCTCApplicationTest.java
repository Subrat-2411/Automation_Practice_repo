package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class IRCTCApplicationTest {

	
	@Test
	public void handlingPopup()
	{
		String fromPlace="SBC";
		
		String toPlace="BHUBANESWAR ";
		
		String resQuota="GENERAL";
		
		String month="September";
		
//		String year="2025";
		
		String date="30";
		
		String classes="Anubhuti Class (EA)";
		
		ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.irctc.co.in/");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		WebElement fromTF = driver.findElement(By.xpath("//span[@class='ng-tns-c58-8 ui-autocomplete ui-widget']/input"));
		
		fromTF.click();
		
		fromTF.sendKeys(fromPlace);
		
		driver.findElement(By.xpath("//span[contains(text(),'"+fromPlace+"')]")).click();
		
		WebElement toTF = driver.findElement(By.xpath("//span[@class='ng-tns-c58-9 ui-autocomplete ui-widget']/input"));
		
		toTF.click();
		
		toTF.sendKeys(toPlace);
		
		driver.findElement(By.xpath("//span[text()=' "+toPlace+"- BBS ']")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'ui-dropdown-label') and contains(text(),'GENERAL')]")).click();
		
		
		driver.findElement(By.xpath("//li[@role='option']/span[text()='"+resQuota+"']")).click();
		
		driver.findElement(By.xpath("//span[contains(@class,'ui-calendar')]")).click();
		
		for(;;) {
		try {
			
			driver.findElement(By.xpath("//span[text()='"+month+"']/following-sibling::span/ancestor::div[contains(@class,'ui-datepicker-group')]/descendant::a[text()='"+date+"']")).click();
			break;
		} 
		catch (Exception e) {
		
			driver.findElement(By.xpath("//span[contains(@class,'ui-datepicker-next-icon')]")).click();
			
		}
		}
		
		System.out.println("Date Selected Successfully");
		
		driver.findElement(By.xpath("//span[contains(@class,'ui-dropdown-label') and contains(text(),'All')]")).click();
		
		driver.findElement(By.xpath("//li[@role='option']/span[text()='"+classes+"']")).click();
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		driver.close();
		
		
		
		
		
		
		
		
	}
}
