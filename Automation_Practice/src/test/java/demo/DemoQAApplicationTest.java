package demo;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoQAApplicationTest {

	@Test
	public void handlingAlerts()
	{
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoqa.com/");
		
		WebElement alertLink = driver.findElement(By.xpath("(//div[@class='card-body'])[3]"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].click();",alertLink);
		
		driver.findElement(By.xpath("//span[contains(text(),'Browser')] ")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'New Window Me')]")).click();
		
		String pId = driver.getWindowHandle();
		
		Set<String> allIds = driver.getWindowHandles();
		
		System.out.println(allIds.size());
		
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			if(!driver.getTitle().contains("DEMOQA"))
			{	
				driver.close();
				break;
			}
	    }
		
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();	
		
		WebElement promptAlert = driver.findElement(By.xpath("(//span[starts-with(text(),'On button')])[3]"));
		
		js.executeScript("arguments[0].scrollIntoView(true)",promptAlert);
		
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Subrat Kumar Sahoo");
		
		alert.accept();
		
		driver.close();
		
		System.out.println("Execution Completed ");
	}
}
