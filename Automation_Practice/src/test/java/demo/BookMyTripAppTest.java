package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class BookMyTripAppTest {

	@Test
	public void handlingPopup() throws InterruptedException
	{
		String place="September";
		
		String date1="6";
		
		String date2="9";
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.makemytrip.com/");
		
		driver.findElement(By.xpath("//span[contains(@class,'close')]")).click();// close icon  popup
		
		driver.findElement(By.xpath("//span[contains(@data-cy,'close')]")).click();// another close icon popup
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='toCity']")).click();
		
		driver.findElement(By.xpath("//p[text()='New Delhi, India']")).click();
		
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		//journey date
		
		for(;;)
		{
		  try {
			driver.findElement(By.xpath("//div[text()='"+place+" 2025']/..//following-sibling::div/descendant::div/p[text()='"+date1+"']")).click();
			
			break;
		   }
	      catch (Exception e) {
			
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			
		   }
		}
		
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		
		// return date 

		for(;;)
		{
		  try {
			driver.findElement(By.xpath("(//div[text()='"+place+"']/../following-sibling::div/descendant::div/p[text()='"+date2+"'])[1]")).click();
			
			break;
		   }
	      catch (Exception e) {
			
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			
		   }
		}
		
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
