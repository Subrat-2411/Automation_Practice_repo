package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class QspidersDemoApplicationTest{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://demoapps.qspiders.com/");
		
		driver.findElement(By.xpath("(//*[local-name()='svg'])[1]")).click();
		
		driver.findElement(By.xpath("//section[contains(text(),'Shadow')]/../section/*")).click();
		
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		
		// OPen Shadow root elements .............
		
		SearchContext shadow_host1 = driver.findElement(By.xpath("(//h1[text()='Login']/../form/div)[1]")).getShadowRoot();
		
		shadow_host1.findElement(By.cssSelector("input[type='text']")).sendKeys("SOhan");

		SearchContext shadow_host2 = driver.findElement(By.xpath("(//h1[text()='Login']/../form/div)[2]")).getShadowRoot();
		
		shadow_host2.findElement(By.cssSelector("input[type='text']")).sendKeys("Sahoo");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		// Closed Shadow Root elements ..............
		
		driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("h1[text()='Login']")).click();
		
		Actions act=new Actions(driver);
		
		act.sendKeys(Keys.TAB).sendKeys("jbfkj").build().perform();
		
		Thread.sleep(2000);
		
		driver.close();
	}

}
