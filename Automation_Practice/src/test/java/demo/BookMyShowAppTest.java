package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class BookMyShowAppTest {              // Access Denied.............................

	@Test
	public void popUp()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://in.bookmyshow.com/");
		
		driver.findElement(By.xpath("//span[text()='Detect my location']")).click();
		
		driver.findElement(By.xpath("//img[@alt='Param Sundari']")).click();
		
		driver.findElement(By.xpath("(//span[text()='Book tickets'])[1]")).click();
		
		driver.close();
	}
}
