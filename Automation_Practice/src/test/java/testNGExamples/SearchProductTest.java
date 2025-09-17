package testNGExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SearchProductTest{

	@Test
	public void searchProductTest()
	{
		WebDriver driver=new ChromeDriver();
		
		/*you use the **decorate()** method (from EventFiringDecorator) 
		 * 
		 *to attach your custom WebDriverListener to the WebDriver.*/
		
		WebDriver limp=new EventFiringDecorator<WebDriver>(new WebDriverListenerImp()).decorate(driver);
		
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		limp.get("https://www.amazon.in/");
		
		limp.findElement(By.xpath("//button[text()='Continue shopping']")).click();
		
		limp.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile",Keys.ENTER);
		
		limp.close();
	}
}
