package demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FlipkartApplicationTest {

	@Test
	public void mouseHoverAndClick()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.flipkart.com/");
		
		 WebElement fashionLink = driver.findElement(By.xpath("//span[text()='Fashion']"));
		 
		 Actions act=new Actions(driver);
		 
		 act.moveToElement(fashionLink).perform();
		 
		 driver.findElement(By.xpath("//a[contains(text(),'T-Shirts')]")).click();
		 
		 driver.findElement(By.xpath("(//img[contains(@src,'rukminim2')])[3]")).click();
		 
		switchToWindow(driver,"t-shirts");
		
		WebElement cartButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", cartButton);
		
		cartButton.click();
		
		System.out.println("Cart Page is Displayed.");
		 
		 driver.quit();
	}
	public static void switchToWindow(WebDriver driver,String expURL)
	{
		Set<String> allIds = driver.getWindowHandles();
		
		for(String id:allIds)
		{
			driver.switchTo().window(id);
			
			if(driver.getCurrentUrl().contains(expURL))
				break;
		}
	}
}
