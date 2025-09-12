package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AirIndiaAppTest {

	
	@Test
	public void handingPopUp() throws InterruptedException
	{
       WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.airindia.com/");
		
		Thread.sleep(5000);
		
		WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));// accept Cookies
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		wait.until(ExpectedConditions.elementToBeClickable(cookies));
		
		cookies.click();
		
		SearchContext shadow_host1 = driver.findElement(By.xpath("//ai-origin-destination[@destination-label='Destination']")).getShadowRoot();
		
		SearchContext shadow_host2 = shadow_host1.findElement(By.cssSelector("ai-complete[modal-title='Departure']")).getShadowRoot();
		
		shadow_host2.findElement(By.cssSelector("input[class='ai-input']")).click();
		
		driver.close();
	
	}
}
