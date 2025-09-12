package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBusCalenderPopup {

	@Test
	public void calendarPopup()
	{
		
		String fromPlace="Bangalore";
		
		String toPlace="Chennai";
		
		String month="October";
		
		String date="23";
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.redbus.in/");
		
		 WebElement fromTF = driver.findElement(By.xpath("//div[text()='From']"));
		
		 fromTF.click();
		 
		 driver.findElement(By.xpath("//input[@id='srcDest']")).sendKeys(fromPlace);
		 
		 driver.findElement(By.xpath("//div[contains(@aria-label,'"+fromPlace+"')]")).click();
		 
		
		 WebElement toTf = driver.findElement(By.xpath("//div[text()='To']"));
		 
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 
		 js.executeScript("arguments[0].click();",toTf);
		 
		 driver.findElement(By.xpath("//input[@id='srcDest']")).sendKeys(toPlace);
		 
		 
  // to send data to the TF
		
		 driver.findElement(By.xpath("//div[contains(@aria-label,'"+toPlace+"')]")).click();
		 
		 driver.findElement(By.xpath("//div[@class='dojWrapper___1f3d15']")).click();
		 
//		 driver.findElement(By.xpath("//span[.='31']")).click();
		 
		WebElement nextIcon = driver.findElement(By.xpath("//i[contains(@aria-label,'Next month')]"));
		
		for(;;) {
		
		try {
			driver.findElement(By.xpath("//p[text()='"+month+"']/../../following-sibling::ul//span[text()='"+date+"']")).click();
			break;
		} catch (Exception e) {
		
			nextIcon.click();
		}
		}
		
//		driver.close();
		
		System.out.println("Done");
		
		
	}
}
