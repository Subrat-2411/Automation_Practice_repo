package demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class HandlingBrokenLinks {

	@Test
	public void brokenLinks() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.rbi.org.in/");
		
		driver.findElement(By.xpath("//button[text()='English']")).click();
		
		List<WebElement> allLinks =  driver.findElements(By.xpath("//a"));
		
		int count=0;
		
		for (WebElement link : allLinks) {
			
				String eachLink = link.getDomAttribute("href");// getting Attribute values 
				try {
				
				URL url=new URL(eachLink);
//			URI uri=new URI(eachLink);
				
				HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();// Making Connection
				
				int statusCode = httpConn.getResponseCode();// Getting Status Codes 
				
				if(statusCode>=400)// Client Side Error
				{
					count++;
					System.out.println(eachLink+"--->>>>"+statusCode);
				}
			
			} catch (Exception e) {
				
			
			}
				
		}
		System.out.println("No. of Broken Links :"+count);
		driver.close();
		
		
	}
}
