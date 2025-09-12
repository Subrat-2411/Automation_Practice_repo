package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestAutomationPracticeApplicationTest {

	@Test
	public void actionPerformance() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.findElement(By.xpath("//button[@name='start' or @name='stop' ]")).click();
		
		Thread.sleep(4000);
		
		WebElement staticTable = driver.findElement(By.xpath("//h2[contains(text(),'Static')]"));
		
		Actions act=new Actions(driver);
		
		act.scrollToElement(staticTable).perform();
		
		Thread.sleep(2000);
		
		WebElement dropLink = driver.findElement(By.xpath("//p[contains(text(),'Drop')]"));
		
		WebElement dragLink = driver.findElement(By.xpath("//div[@id='draggable']"));
		
		act.dragAndDrop(dragLink, dropLink).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//input[@type='file'])[1]")).sendKeys("C:\\Users\\Rutusmita prusty\\OneDrive\\Desktop\\keshav sir imp Java Questions 1.docx");
		
		WebElement labelsLink = driver.findElement(By.xpath("//h2[contains(text(),'Labels')]"));
		
		act.scrollToElement(labelsLink).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='comboBox']")).click();
		
		WebElement item10 = driver.findElement(By.xpath("//div[text()='Item 10']"));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)",item10);
		
		Thread.sleep(2000);
		
		item10.click();
		
		System.out.println("Item10 is Selected.");
		
		driver.close();
		
	}
}
