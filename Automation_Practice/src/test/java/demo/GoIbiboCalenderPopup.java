package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class GoIbiboCalenderPopup {

	@Test
	public void popup()
	{
		
		String fromPlace="Bengaluru";
		
		String toPlace="Chennai";
		
		String monthYear="December 2025";
		
		String date="24";
		
		ChromeOptions opt=new ChromeOptions();
		
		opt.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.goibibo.com/");
		
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		
		WebElement fromTF = driver.findElement(By.xpath("//span[text()='From']"));
		
		fromTF.click();
		
		driver.findElement(By.xpath("//span[text()='From']/following-sibling::input")).sendKeys(fromPlace);
		
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ' and contains(text(),'"+fromPlace+"')]")).click();
		
//		driver.findElement(By.xpath("//span[text()='To']")).click();
		
		WebElement toTF = driver.findElement(By.xpath("//p[contains(text(),'Enter')]/preceding-sibling::span[text()='To']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].click();",toTF);
		
		driver.findElement(By.xpath("//span[text()='To']/following-sibling::input")).sendKeys(toPlace);
		
		driver.findElement(By.xpath("//span[@class='autoCompleteTitle ' and contains(text(),'"+toPlace+"')]")).click();
		
//		driver.findElement(By.xpath("//span[text()='From']/../p")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		for(;;)
		{
		try {
			
			driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Caption']/following-sibling::div//p[text()='"+date+"']")).click();
		
			break;
			
		}
		
		catch (Exception e) {
			
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
		}
		
		driver.close();
	}
}
